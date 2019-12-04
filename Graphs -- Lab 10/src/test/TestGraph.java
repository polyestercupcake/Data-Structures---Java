package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Edge;
import model.Graph;
import model.IEdge;
import model.IGraph;
import model.IGraph2;
import model.IVertex;
import model.Vertex;

class TestGraph {

	/**
	 * @author cberkstresser
	 */
	@Test
	public void isStronglyConnected1() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		diGraph.addEdge(new Edge(c, a, 3));
		assertTrue(diGraph.isStronglyConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void isStronglyConnected2() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		assertFalse(diGraph.isStronglyConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void isWeaklyConnected1() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		diGraph.addEdge(new Edge(c, a, 3));
		assertTrue(diGraph.isWeaklyConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void isWeaklyConnected2() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		assertTrue(diGraph.isWeaklyConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void isComplete1() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		diGraph.addEdge(new Edge(c, a, 3));
		assertFalse(diGraph.isComplete());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void isComplete2() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, a, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		diGraph.addEdge(new Edge(c, b, 1));
		diGraph.addEdge(new Edge(c, a, 3));
		diGraph.addEdge(new Edge(a, c, 1));
		assertTrue(diGraph.isComplete());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void shortestPath1() {
		Graph diGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		diGraph.addVertex(a);
		diGraph.addVertex(b);
		diGraph.addVertex(c);

		diGraph.addEdge(new Edge(a, b, 1));
		diGraph.addEdge(new Edge(b, c, 2));
		diGraph.addEdge(new Edge(c, a, 3));
		assertTrue(diGraph.getShortestPath(c, b).equals(Arrays.asList(c, a, b)));
	}

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

	/**
	 * Tanner
	 */
	@Test
	public void shortest_path_megsGraph() {

		Graph megaGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		IVertex e = new Vertex('E');
		IVertex f = new Vertex('F');
		IVertex g = new Vertex('G');
		IVertex h = new Vertex('H');
		IVertex i = new Vertex('I');
		IVertex j = new Vertex('J');
		IVertex k = new Vertex('K');
		IVertex l = new Vertex('L');
		IVertex m = new Vertex('M');
		IVertex n = new Vertex('N');
		IVertex o = new Vertex('O');
		IVertex p = new Vertex('P');
		IVertex q = new Vertex('Q');
		IVertex r = new Vertex('R');
		IVertex s = new Vertex('S');
		IVertex t = new Vertex('T');
		IVertex u = new Vertex('U');
		IVertex v = new Vertex('V');
		IVertex w = new Vertex('W');
		IVertex x = new Vertex('X');
		IVertex y = new Vertex('Y');
		IVertex z = new Vertex('Z');
		megaGraph.addVertex(a);
		megaGraph.addVertex(b);
		megaGraph.addVertex(c);
		megaGraph.addVertex(d);
		megaGraph.addVertex(e);
		megaGraph.addVertex(f);
		megaGraph.addVertex(g);
		megaGraph.addVertex(h);
		megaGraph.addVertex(i);
		megaGraph.addVertex(j);
		megaGraph.addVertex(k);
		megaGraph.addVertex(l);
		megaGraph.addVertex(m);
		megaGraph.addVertex(n);
		megaGraph.addVertex(o);
		megaGraph.addVertex(p);
		megaGraph.addVertex(q);
		megaGraph.addVertex(r);
		megaGraph.addVertex(s);
		megaGraph.addVertex(t);
		megaGraph.addVertex(u);
		megaGraph.addVertex(v);
		megaGraph.addVertex(w);
		megaGraph.addVertex(x);
		megaGraph.addVertex(y);
		megaGraph.addVertex(z);

		megaGraph.addEdge(new Edge(a, b, 2));
		megaGraph.addEdge(new Edge(a, c, 1));
		megaGraph.addEdge(new Edge(a, d, 6));
		megaGraph.addEdge(new Edge(a, e, 9));
		megaGraph.addEdge(new Edge(a, m, 4));
		megaGraph.addEdge(new Edge(a, p, 3));
		megaGraph.addEdge(new Edge(a, k, 5));
		megaGraph.addEdge(new Edge(b, g, 4));
		megaGraph.addEdge(new Edge(b, f, 2));
		megaGraph.addEdge(new Edge(c, h, 1));
		megaGraph.addEdge(new Edge(c, i, 1));
		megaGraph.addEdge(new Edge(c, j, 3));
		megaGraph.addEdge(new Edge(c, k, 6));
		megaGraph.addEdge(new Edge(d, l, 7));
		megaGraph.addEdge(new Edge(d, t, 3));
		megaGraph.addEdge(new Edge(e, m, 8));
		megaGraph.addEdge(new Edge(e, n, 3));
		megaGraph.addEdge(new Edge(e, o, 1));
		megaGraph.addEdge(new Edge(p, s, 9));
		megaGraph.addEdge(new Edge(g, f, 5));
		megaGraph.addEdge(new Edge(f, x, 9));
		megaGraph.addEdge(new Edge(f, r, 5));
		megaGraph.addEdge(new Edge(r, u, 2));
		megaGraph.addEdge(new Edge(n, o, 1));
		megaGraph.addEdge(new Edge(l, k, 7));
		megaGraph.addEdge(new Edge(l, q, 2));
		megaGraph.addEdge(new Edge(l, y, 1));
		megaGraph.addEdge(new Edge(q, v, 6));

		assertTrue(megaGraph.getShortestPath(a, n).equals(Arrays.asList(a, e, n)));
	}
	
	@Test
	public void getShortestPath_midGraphCS1() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 6));
		midGraph.addEdge(new Edge(a, b, 4));
		midGraph.addEdge(new Edge(a, b, 3));
		midGraph.addEdge(new Edge(a, c, 7));
		midGraph.addEdge(new Edge(b, c, 2));
		
		assertTrue(midGraph.getShortestPath(a, c).equals(Arrays.asList(a, b, c)));
	}
	
	@Test
	public void getShortestPath_midGraphCS2_Method1() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		IVertex e = new Vertex('E');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addVertex(d);
		midGraph.addVertex(e);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 1));
		midGraph.addEdge(new Edge(c, d, 1));
		midGraph.addEdge(new Edge(d, e, 1));
		midGraph.addEdge(new Edge(a, e, 5));
		
		assertTrue(midGraph.getShortestPath(a, e).equals(Arrays.asList(a, b, c, d, e)));
	}
	
	@Test
	public void getShortestPath_midGraphCS3_Method2() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 3));
		midGraph.addEdge(new Edge(c, b, 3));
		midGraph.addEdge(new Edge(a, c, 1));
		midGraph.addEdge(new Edge(c, a, 1));
		midGraph.addEdge(new Edge(b, a, 1));
		
		assertTrue(midGraph.getShortestPath(a, c).equals(Arrays.asList(a, c)));
	}
	
	@Test
	public void getShortestPath_midGraphCS3_Method3() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 3));
		midGraph.addEdge(new Edge(c, b, 3));
		midGraph.addEdge(new Edge(a, c, 1));
		midGraph.addEdge(new Edge(c, a, 1));
		midGraph.addEdge(new Edge(b, a, 1));
		
		assertTrue(midGraph.getShortestPath(b, a).equals(Arrays.asList(b, a)));
	}
	
	@Test
	public void getShortestPath_midGraphCS3_Method4() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 3));
		midGraph.addEdge(new Edge(c, b, 3));
		midGraph.addEdge(new Edge(a, c, 1));
		midGraph.addEdge(new Edge(c, a, 1));
		midGraph.addEdge(new Edge(b, a, 1));
		
		assertTrue(midGraph.getShortestPath(b, c).equals(Arrays.asList(b, a, c)));
	}
	
	@Test
	public void isComplete_midGraphCS3() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 3));
		midGraph.addEdge(new Edge(c, b, 3));
		midGraph.addEdge(new Edge(a, c, 1));
		midGraph.addEdge(new Edge(c, a, 1));
		midGraph.addEdge(new Edge(b, a, 1));
		
		assertTrue(midGraph.isComplete());
	}
	
	@Test
	public void isStronglyConected_midGraphCS3() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 3));
		midGraph.addEdge(new Edge(c, b, 3));
		midGraph.addEdge(new Edge(a, c, 1));
		midGraph.addEdge(new Edge(c, a, 1));
		midGraph.addEdge(new Edge(b, a, 1));
		
		assertTrue(midGraph.isStronglyConnected());
	}
	
	@Test
	public void isWeaklyConected_midGraphCS3() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 3));
		midGraph.addEdge(new Edge(c, b, 3));
		midGraph.addEdge(new Edge(a, c, 1));
		midGraph.addEdge(new Edge(c, a, 1));
		midGraph.addEdge(new Edge(b, a, 1));
		
		assertTrue(midGraph.isWeaklyConnected());
	}
	
	@Test
	public void isComplete_midGraphCS1() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 6));
		midGraph.addEdge(new Edge(a, b, 4));
		midGraph.addEdge(new Edge(a, b, 3));
		midGraph.addEdge(new Edge(a, c, 7));
		midGraph.addEdge(new Edge(b, c, 2));
		
		assertTrue(!midGraph.isComplete());
	}
	
	@Test
	public void isWeaklyConnected_midGraphCS1() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 6));
		midGraph.addEdge(new Edge(a, b, 4));
		midGraph.addEdge(new Edge(a, b, 3));
		midGraph.addEdge(new Edge(a, c, 7));
		midGraph.addEdge(new Edge(b, c, 2));
		
		assertTrue(midGraph.isWeaklyConnected());
	}
	
	@Test
	public void isStronglyConnected_midGraphCS1() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addEdge(new Edge(a, b, 6));
		midGraph.addEdge(new Edge(a, b, 4));
		midGraph.addEdge(new Edge(a, b, 3));
		midGraph.addEdge(new Edge(a, c, 7));
		midGraph.addEdge(new Edge(b, c, 2));
		
		assertTrue(!midGraph.isStronglyConnected());
	}
	
	@Test
	public void isComplete_midGraphCS2() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		IVertex e = new Vertex('E');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addVertex(d);
		midGraph.addVertex(e);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 1));
		midGraph.addEdge(new Edge(c, d, 0));
		midGraph.addEdge(new Edge(d, e, 1));
		midGraph.addEdge(new Edge(a, e, 4));
		
		assertTrue(!midGraph.isComplete());
	}
	
	@Test
	public void isWeaklyConnected_midGraphCS2() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		IVertex e = new Vertex('E');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addVertex(d);
		midGraph.addVertex(e);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 1));
		midGraph.addEdge(new Edge(c, d, 0));
		midGraph.addEdge(new Edge(d, e, 1));
		midGraph.addEdge(new Edge(a, e, 4));
		
		assertTrue(midGraph.isWeaklyConnected());
	}
	
	@Test
	public void isStronglyConnected_midGraphCS2() {
		Graph midGraph = new Graph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		IVertex e = new Vertex('E');
		midGraph.addVertex(a);
		midGraph.addVertex(b);
		midGraph.addVertex(c);
		midGraph.addVertex(d);
		midGraph.addVertex(e);
		midGraph.addEdge(new Edge(a, b, 1));
		midGraph.addEdge(new Edge(b, c, 1));
		midGraph.addEdge(new Edge(c, d, 0));
		midGraph.addEdge(new Edge(d, e, 1));
		midGraph.addEdge(new Edge(a, e, 4));
		
		assertTrue(!midGraph.isStronglyConnected());
	}
	
}