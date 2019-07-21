/*
Author: Achanta
*/
package assignment;

import java.util.LinkedList;

public class FlowNetwork {
  //Number of Vertices in the Network
  protected static int num_vertices;
  //Number of Edges in the Network
  protected static int num_edges;
  //vertex mapping to different vetexes
  protected LinkedList<FlowEdge>[] adj;

    //Network Initialization
    public FlowNetwork(int V) {
        num_vertices = V;
        num_edges = 0;
        if(num_vertices < 0) throw new IllegalArgumentException("No non-negative vertices");
        adj = new LinkedList[num_vertices];
        for(int i=0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //Add an Edge to the Network
    protected void addEdge(FlowEdge e) {
      adj[e.from].add(e);
      adj[e.to].add(e);
      num_edges++;
    }

    //Returns adjacent edges connected to the given Vertex
    protected Iterable<FlowEdge> adjEdges(int v) {
      if(v < 0 || v  >= num_vertices) throw new IndexOutOfBoundsException("Invalid vertex");
      return adj[v];
    }

    //Returns vertex and its edges and flows for the given network
    @Override
    public String toString() {
      StringBuilder out = new StringBuilder();
      for(int i=0; i< adj.length; i++) {
        out.append("vertex: " + i + "\n");
        for(FlowEdge e: adj[i]) {
          out.append(e.from + " ----> " + e.to + " capacity:" + e.capacity + ", flow:" + e.flow + "\n");
        }
        out.append("\n");
      }
      return out.toString();
    }
}
