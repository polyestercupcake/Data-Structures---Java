package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.Edge;
import model.Graph;
import model.IVertex;
import model.Vertex;

class TestGraph {
	
	/**
	 * @author Tanner
	 */
	@Test
	public void insertion_gets_weight() {
		Graph myGraph = new Graph();
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
        
        assertTrue(myGraph.getEdges().get(3).getWeight() == 3);
	}

}
