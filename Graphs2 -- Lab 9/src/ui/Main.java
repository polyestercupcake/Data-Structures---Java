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
		//OldGraph myGraph = new OldGraph();
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

        myGraph.addEdge(new Edge(a, a, 3));
        myGraph.addEdge(new Edge(a, c, 4));
        myGraph.addEdge(new Edge(a, b, 1));
        myGraph.addEdge(new Edge(c, c, 3));
        
        myGraph.addEdge(new Edge(a, e, 6));
        myGraph.addEdge(new Edge(b, c, 9));
        
        myGraph.addEdge(new Edge(d, c, 3));
        myGraph.addEdge(new Edge(d, e, 1));
       
        // REQUIRED METHODS
//        System.out.println(myGraph.isComplete()); 
//        System.out.println(myGraph.getShortestPath(a, b));
//        System.out.println(myGraph.isStronglyConnected());
        System.out.println(myGraph.isWeaklyConnected()); // works
        // BOUNS METHODS
//        System.out.println(myGraph.hasStrongEulerCycle()); 
//        System.out.println(myGraph.getStrongEulerCycle(a));

    }
}