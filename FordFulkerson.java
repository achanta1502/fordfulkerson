/*
Author: Achanta
*/
package assignment;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    protected int max_flow = 0;
    protected FlowEdge[] parent;
    public FordFulkerson(FlowNetwork graph, int source, int sink) {
      //flow value at the sink(total flows at the sink)
      for (FlowEdge e : graph.adjEdges(sink)) {
        if (sink == e.from) max_flow -= e.flow;
        else               max_flow += e.flow;
      }
      //Find minimum residual capacity of the edges along the
      // path filled by BFS
        while(BFS(graph, source, sink)) {
            int flow = Integer.MAX_VALUE;
            //compute max flow that can be possible
            for(int i = sink; i != source; i = parent[i].otherVertex(i)) {
              flow = Math.min(flow, parent[i].residualCapacity(i));
            }

            //augment flow and update residual capacities
            for(int i = sink; i != source; i = parent[i].otherVertex(i)) {
                parent[i].addResidualFlow(i, flow);
            }
            max_flow += flow;
        }
    }

    //To find path from source to sink
    private boolean BFS(FlowNetwork graph, int source, int sink) {
      //Marker to track the visited vertexes and mark all as not visited
      boolean[] visited = new boolean[graph.num_vertices];
      parent = new FlowEdge[graph.num_vertices];
      for(int i=0; i<visited.length; i++) {
        visited[i] = false;
      }

      Queue<Integer> q = new LinkedList<>();
      q.add(source);
      visited[source] = true;

      //until Queue is Empty we will continue to find a path from source to sink
      while(!q.isEmpty()) {
        int v = q.poll();

        //look at all the edges from vertex v
        for(FlowEdge e: graph.adjEdges(v)) {
          int other = e.otherVertex(v);

          //if there is residual capacity from v to other
          //add it to intermediate edge path and mark it as visited
          if(e.residualCapacity(other) > 0 && !visited[other]) {
              visited[other] = true;
              parent[other] = e;
              q.add(other);
          }
        }
      }

      //check is there augmenting path from source to sink
      return visited[sink];
    }
}
