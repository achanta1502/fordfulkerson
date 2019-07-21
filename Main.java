/*
Author: Achanta
*/
package assignment;


public class Main {
    protected static FlowEdge edge;
    public static void main(String[] args) {
        int V = 6;
        //Create flow network with vertices and then add edges to them
        //Maximum capacity should be 19
        FlowNetwork flowNetwork = new FlowNetwork(V);
        edge = new FlowEdge(0, 2, 7, 7);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(0, 1, 4, 4);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(0, 4, 10, 6);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(1, 5, 10, 4);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(3, 5, 7, 7);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(4, 5, 6, 6);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(2, 3, 10, 7);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(2, 1, 2, 0);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(2, 4, 2, 0);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(1, 3, 2, 0);
        flowNetwork.addEdge(edge);
        edge = new FlowEdge(4, 3, 2, 0);
        flowNetwork.addEdge(edge);
        //Maximum capacity of this network is 4
//        FlowNetwork flowNetwork = new FlowNetwork(V);
//        edge = new FlowEdge(0, 2, 3, 2);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(0, 1, 2, 2);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(1, 4, 1, 1);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(1, 3, 3, 1);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(2, 3, 1, 1);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(2, 4, 1, 1);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(3, 5, 2, 2);
//        flowNetwork.addEdge(edge);
//        edge = new FlowEdge(4, 5, 3, 2);
//        flowNetwork.addEdge(edge);
        //Given flow Network
        System.out.println(flowNetwork.toString());
        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, 5);
        //Maximum Flow Allowed
        System.out.println("Maximum flow for the given Network --> " + fordFulkerson.max_flow);
    }
}
