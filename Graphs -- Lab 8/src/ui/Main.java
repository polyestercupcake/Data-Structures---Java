package ui;

import model.Edge;
import model.Graph;
import model.OldGraph;
import model.IVertex;
import model.Vertex;

public class Main {
    public static void main(String[] args) {
        // instantiate a graph
		Graph myGraph = new Graph();
		//OldGraph myOldGraph = new OldGraph();
        // add vertices
        IVertex a = new Vertex('A');
        IVertex b = new Vertex('B');
        IVertex c = new Vertex('C');
        IVertex d = new Vertex('D');
        IVertex e = new Vertex('E');
        myGraph.addVertex(a);
        myGraph.addVertex(b);
        myGraph.addVertex(c);
        myGraph.addVertex(d);
        myGraph.addVertex(e);

        myGraph.addEdge(new Edge(a, a));
        myGraph.addEdge(new Edge(a, c));
        myGraph.addEdge(new Edge(a, b));
        myGraph.addEdge(new Edge(c, c));
        
        myGraph.addEdge(new Edge(a, e));
        myGraph.addEdge(new Edge(b, c));
        
        myGraph.addEdge(new Edge(d, c));
        myGraph.addEdge(new Edge(d, e));
       
        System.out.println(myGraph.isComplete()); 
        System.out.println(myGraph.isConnected());
        System.out.println("Depth: " + myGraph.depthFirstSearch());
        System.out.println("Breadth: " + myGraph.breadthFirstSearch());
        System.out.println(myGraph.hasStrongEulerCycle()); 
        System.out.println(myGraph.getStrongEulerCycle(a));
        System.out.println(myGraph.getShortestPath(a, b));
    }
}