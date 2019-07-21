/*
Author: Achanta
*/
package assignment;

public class FlowEdge {
    //Start vertex of the Edge
    protected final int from;
    //End vertex of the Edge
    protected final int to;
    //Maximum capacity of the Edge
    protected final int capacity;
    //Flow of the path from start to End of Edge
    protected int flow;

    //FlowEdge
    public FlowEdge(int from, int to, int capacity, int flow) {
        if(from < 0 || to < 0 || capacity < 0) throw new IndexOutOfBoundsException("vertex or capacity should not be negative");
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = flow;
    }

    //Returns other vertex on the Edge
    protected int otherVertex(int v) {
        if (v == from) return to;
        else if (v == to) return from;
        else throw new IllegalArgumentException("Illegal vertex");
    }

    //Returns residual capacity of the edge in the direction
    protected int residualCapacity(int v) {
        if (v == from) return flow;                   // backward edge
        else if (v == to) return capacity - flow;     // forward edge
        else throw new IllegalArgumentException("Illegal vertex");
    }

    //Updating residual flow with curr value
    protected void addResidualFlow(int v, int curr) {
      if      (v == from) flow -= curr;           // backward edge
      else if (v == to) flow += curr;           // forward edge
      else throw new IllegalArgumentException("Illegal endpoint");
    }
}
