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
import model.OldGraph;
import model.IEdge;
import model.IGraph;
import model.IGraph2;
import model.IVertex;
import model.Vertex;

class TestGraph {
	
//	private IGraph2 megaGraph() {
//		Graph graph = new Graph();
//
//		for (int n = 97; n <= 122; n++) {
//			char letter = (char) n;
//			graph.addVertex(new Vertex(letter));
//		}
//		graph.addEdge('a', 'b');
//		graph.addEdge('a', 'c');
//		graph.addEdge('a', 'd');
//		graph.addEdge('a', 'e');
//		graph.addEdge('a', 'm');
//		graph.addEdge('a', 'p');
//		graph.addEdge('a', 'k');
//		graph.addEdge('b', 'g');
//		graph.addEdge('b', 'f');
//		graph.addEdge('c', 'h');
//		graph.addEdge('c', 'i');
//		graph.addEdge('c', 'j');
//		graph.addEdge('c', 'k');
//		graph.addEdge('d', 'l');
//		graph.addEdge('d', 't');
//		graph.addEdge('e', 'm');
//		graph.addEdge('e', 'n');
//		graph.addEdge('e', 'o');
//		graph.addEdge('p', 's');
//		graph.addEdge('g', 'f');
//		graph.addEdge('f', 'x');
//		graph.addEdge('f', 'r');
//		graph.addEdge('r', 'u');
//		graph.addEdge('n', 'o');
//		graph.addEdge('l', 'k');
//		graph.addEdge('l', 'q');
//		graph.addEdge('l', 'y');
//		graph.addEdge('q', 'v');
//		return graph;
//	}
//
//	/**
//	 * @author cberkstresser
//	 */
//	@Test
//	void testMegaGraphComplete() {
//		IGraph2 mega = megaGraph();
//
//		assertFalse(mega.isComplete());
//	}
//
//	/**
//	 * @author cberkstresser
//	 */
//	@Test
//	void testMegaGraphConnected() {
//		IGraph2 mega = megaGraph();
//
//		assertFalse(mega.isConnected());
//	}
//
//	/**
//	 * @author cberkstresser
//	 */
//	@Test
//	void testMegaNoEulerCycle() {
//		IGraph2 mega = megaGraph();
//
//		assertFalse(mega.hasStrongEulerCycle());
//	}
//
//	/**
//	 * @author cberkstresser
//	 */
//	@Test
//	void testMegaNoEulerCycleReturnsEmptyList() {
//		IGraph2 mega = megaGraph();
//
//		assertFalse(mega.getStrongEulerCycle(new Vertex('a')).equals(new ArrayList<>()));
//	}
//	
//	/**
//	 * @author cberkstresser
//	 */
//	@Test
//	void testMegaNoHamiltonianCycleReturnsEmptyList() {
//		IGraph2 mega = megaGraph();
//
//		assertFalse(mega.hamiltonianCycle(new Vertex('a')).equals(new ArrayList<>()));
//	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testHamiltonianCompleteQuad() {
		IGraph2 myGraph = new OldGraph();
		List<List<IVertex>> potentialCycles = new ArrayList<>();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		potentialCycles.add(Arrays.asList(a, b, d, c, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, a));
		potentialCycles.add(Arrays.asList(a, c, b, d, a));
		potentialCycles.add(Arrays.asList(a, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, d, b, c, a));
		potentialCycles.add(Arrays.asList(a, d, c, b, a));

		// add edges
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(b, d));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(c, d));
		myGraph.addEdge(new Edge(a, d));

		try {
			assertTrue(potentialCycles.contains(myGraph.hamiltonianCycle(a)));
		} catch (UnsupportedOperationException e) {
		}
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testBreadthFirstSearchFive() {
		IGraph2 myGraph = new OldGraph();
		List<List<IVertex>> potentialPaths = new ArrayList<>();
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

		potentialPaths.add(Arrays.asList(a, d, b, e, c));
		potentialPaths.add(Arrays.asList(c, b, a, d, e));
		potentialPaths.add(Arrays.asList(a, b, d, c, e));
		potentialPaths.add(Arrays.asList(b, a, c, d, e));
		potentialPaths.add(Arrays.asList(b, c, a, d, e));
		potentialPaths.add(Arrays.asList(d, a, e, b, c));
		potentialPaths.add(Arrays.asList(d, e, a, b, c));
		potentialPaths.add(Arrays.asList(e, d, a, b, c));

		// add edges
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(a, d));
		myGraph.addEdge(new Edge(d, e));

		assertTrue(potentialPaths.contains(myGraph.breadthFirstSearch()));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testDepthFirstSearchFive() {
		IGraph2 myGraph = new OldGraph();
		List<List<IVertex>> potentialPaths = new ArrayList<>();
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

		potentialPaths.add(Arrays.asList(d, a, b, c, e));
		potentialPaths.add(Arrays.asList(a, b, c, d, e));
		potentialPaths.add(Arrays.asList(b, a, d, e, c));
		potentialPaths.add(Arrays.asList(c, b, a, d, e));
		potentialPaths.add(Arrays.asList(b, c, a, d, e));
		potentialPaths.add(Arrays.asList(d, e, a, b, c));
		potentialPaths.add(Arrays.asList(e, d, a, b, c));
		potentialPaths.add(Arrays.asList(a, d, e, b, c));

		// add edges
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(a, d));
		myGraph.addEdge(new Edge(d, e));

		assertTrue(potentialPaths.contains(myGraph.depthFirstSearch()));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testEulerOnDoubleLoop() {
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		myGraph.addVertex(a);

		// add edges
		myGraph.addEdge(new Edge(a, a));
		myGraph.addEdge(new Edge(a, a));

		assertTrue(myGraph.getStrongEulerCycle(a).equals(Arrays.asList(a, a, a)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testEulerOnDoubleDouble() {
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		myGraph.addVertex(a);
		myGraph.addVertex(b);

		// add edges
		myGraph.addEdge(new Edge(b, a));
		myGraph.addEdge(new Edge(b, a));

		assertTrue(myGraph.getStrongEulerCycle(a).equals(Arrays.asList(a, b, a)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testEulerOnSuperCompleteQuad() {
		OldGraph myGraph = new OldGraph();
		List<List<IVertex>> potentialCycles = new ArrayList<>();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		// add edges
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(c, d));
		myGraph.addEdge(new Edge(c, d));
		myGraph.addEdge(new Edge(a, d));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(b, d));

		// get all potential answers
		potentialCycles.add(Arrays.asList(a, d, c, d, b, a, c, b, a));
		potentialCycles.add(Arrays.asList(a, d, c, a, b, d, c, b, a));
		potentialCycles.add(Arrays.asList(a, c, d, b, a, d, c, b, a));
		potentialCycles.add(Arrays.asList(a, b, a, d, c, b, d, c, a));
		potentialCycles.add(Arrays.asList(a, d, c, d, b, a, b, c, a));
		potentialCycles.add(Arrays.asList(a, c, b, a, b, d, c, d, a));
		potentialCycles.add(Arrays.asList(a, d, b, a, b, c, d, c, a));
		potentialCycles.add(Arrays.asList(a, d, b, a, c, d, c, b, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, b, a, c, d, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, a, b, d, c, a));
		potentialCycles.add(Arrays.asList(a, d, c, d, b, c, a, b, a));
		potentialCycles.add(Arrays.asList(a, b, c, a, b, d, c, d, a));
		potentialCycles.add(Arrays.asList(a, c, b, d, c, d, a, b, a));
		potentialCycles.add(Arrays.asList(a, b, a, c, d, b, c, d, a));
		potentialCycles.add(Arrays.asList(a, b, d, a, c, d, c, b, a));
		potentialCycles.add(Arrays.asList(a, b, a, d, b, c, d, c, a));
		potentialCycles.add(Arrays.asList(a, b, a, c, d, c, b, d, a));
		potentialCycles.add(Arrays.asList(a, b, a, d, c, d, b, c, a));
		potentialCycles.add(Arrays.asList(a, b, d, c, d, a, c, b, a));
		potentialCycles.add(Arrays.asList(a, d, b, c, d, c, a, b, a));
		potentialCycles.add(Arrays.asList(a, c, d, a, b, d, c, b, a));
		potentialCycles.add(Arrays.asList(a, b, a, c, b, d, c, d, a));
		potentialCycles.add(Arrays.asList(a, c, d, b, c, d, a, b, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, a, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, b, a, d, c, a));
		potentialCycles.add(Arrays.asList(a, c, d, c, b, d, a, b, a));
		potentialCycles.add(Arrays.asList(a, b, d, c, a, b, c, d, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, c, a, b, d, a));
		potentialCycles.add(Arrays.asList(a, b, d, a, b, c, d, c, a));
		potentialCycles.add(Arrays.asList(a, d, c, b, a, b, d, c, a));
		potentialCycles.add(Arrays.asList(a, c, d, b, a, b, c, d, a));
		potentialCycles.add(Arrays.asList(a, c, b, a, d, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, d, c, a, b, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, b, d, c, b, a, c, d, a));
		potentialCycles.add(Arrays.asList(a, b, d, c, d, a, b, c, a));
		potentialCycles.add(Arrays.asList(a, d, c, b, d, c, a, b, a));
		potentialCycles.add(Arrays.asList(a, b, c, a, d, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, c, d, c, b, a, d, b, a));
		potentialCycles.add(Arrays.asList(a, d, c, b, a, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, b, c, d, c, a, d, b, a));
		potentialCycles.add(Arrays.asList(a, c, d, c, b, a, b, d, a));
		potentialCycles.add(Arrays.asList(a, b, d, c, a, d, c, b, a));
		potentialCycles.add(Arrays.asList(a, c, d, a, b, c, d, b, a));
		potentialCycles.add(Arrays.asList(a, b, d, c, b, a, d, c, a));

		assertTrue(potentialCycles.contains(myGraph.getStrongEulerCycle(a)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testNullGraphIsConnected() {
		IGraph myGraph = new OldGraph();
		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testSingletonGraphIsConnected() {
		IGraph myGraph = new OldGraph();
		myGraph.addVertex(new Vertex('A'));
		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testNullGraphIsComplete() {
		IGraph myGraph = new OldGraph();
		assertTrue(myGraph.isComplete());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testSingletonGraphIsComplete() {
		IGraph myGraph = new OldGraph();
		myGraph.addVertex(new Vertex('A'));
		assertTrue(myGraph.isComplete());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testComplete() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(c, b));

		assertTrue(myGraph.isComplete());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testConnected() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(c, b));

		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testGetStrongEulerCycle() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(c, b));

		assertTrue(myGraph.getStrongEulerCycle(a).equals(Arrays.asList(a, b, c, a))
				|| myGraph.getStrongEulerCycle(a).equals(Arrays.asList(a, c, b, a)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testHasStrongEulerCycle() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(c, b));

		assertTrue(myGraph.hasStrongEulerCycle());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testAdjacentVertices() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(c, b));

		assertTrue(myGraph.getAdjacentVertices(a).equals(new HashSet<IVertex>(Arrays.asList(b, c))));
	}

	/*
	 * @author ashton r collins
	 */
	@Test
	void testRemoveEdgeisAdjacent() {
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex r = new Vertex('R');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(r);
		myGraph.addVertex(c);

		// add edges
		Edge x = new Edge(a, r);
		myGraph.addEdge(x);
		Edge y = new Edge(a, c);
		myGraph.addEdge(y);
		Edge z = new Edge(c, r);
		myGraph.addEdge(z);

		// remove edge
		myGraph.removeEdge(1);

		assertFalse(myGraph.isAdjacent(a, c));

	}

	/*
	 * @author ashton r collins
	 */
	@Test
	void testRemoveEdgeCheckOilCycle() {
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex r = new Vertex('R');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(r);
		myGraph.addVertex(c);

		// add edges
		Edge x = new Edge(a, r);
		myGraph.addEdge(x);
		Edge y = new Edge(a, c);
		myGraph.addEdge(y);
		Edge z = new Edge(c, r);
		myGraph.addEdge(z);

		// remove edge
		myGraph.removeEdge(0);

		assertFalse(myGraph.hasStrongEulerCycle());

	}

	/*
	 * @author ashton r collins
	 */
	@Test
	void testRemoveEdgeCountEdges() {
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex r = new Vertex('R');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(r);
		myGraph.addVertex(c);

		// add edges
		Edge x = new Edge(a, r);
		myGraph.addEdge(x);
		Edge y = new Edge(a, c);
		myGraph.addEdge(y);
		Edge z = new Edge(c, r);
		myGraph.addEdge(z);

		// remove edge
		myGraph.removeEdge(0);

		assertTrue(myGraph.getEdges().size() == 2);

	}

	/*
	 * @author ashton r collins
	 */
	@Test
	void testRemoveEdgeIsConnected() {
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex r = new Vertex('R');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(r);
		myGraph.addVertex(c);

		// add edges
		Edge x = new Edge(a, r);
		myGraph.addEdge(x);
		Edge y = new Edge(a, c);
		myGraph.addEdge(y);
		Edge z = new Edge(c, r);
		myGraph.addEdge(z);

		// remove edge
		myGraph.removeEdge(1);
		myGraph.removeEdge(1);

		assertFalse(myGraph.isConnected());

	}

	/*
	 * @author ashton r collins
	 */
	@Test
	void testBadOilerCycle() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();

		// add vertices
		IVertex a = new Vertex('A');
		IVertex r = new Vertex('R');
		IVertex c = new Vertex('C');
		IVertex q = new Vertex('Q');
		IVertex z = new Vertex('Z');
		myGraph.addVertex(a);
		myGraph.addVertex(r);
		myGraph.addVertex(c);
		myGraph.addVertex(q);
		myGraph.addVertex(z);

		// add edges to those vertices (excluding one)
		// myGraph.addEdge(new Edge(a, r)); (Commented out the missing edge)
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(a, q));
		myGraph.addEdge(new Edge(a, z));
		myGraph.addEdge(new Edge(r, c));
		myGraph.addEdge(new Edge(r, q));
		myGraph.addEdge(new Edge(r, z));
		myGraph.addEdge(new Edge(c, q));
		myGraph.addEdge(new Edge(c, z));
		myGraph.addEdge(new Edge(q, z));

		assertFalse(myGraph.hasStrongEulerCycle());

	}

	/**
	 * @author Dakota Johnson
	 **/
	@Test
	void testRemoveEdgeFromEdglessGraph() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		myGraph.removeEdge(0);
	}

	/**
	 * @author Dakota Johnson
	 **/
	@Test
	void testAddDuplicateEdgesThenDeleteAndCheckForConnected() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(b, d));
		myGraph.addEdge(new Edge(c, d));

		myGraph.removeEdge(0);
		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author Dakota Johnson
	 **/
	@Test
	void testOneVertexConnectedWithNoEdge() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');

		myGraph.addVertex(a);

		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author Dakota Johnson
	 **/
	@Test
	void testRemoveVertexAlsoRemovesTheirEdges() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(b, d));
		myGraph.addEdge(new Edge(c, d));

		myGraph.removeVertex(0);
		assertTrue(myGraph.getEdges().size() == 2);
	}

	/**
	 * @author Dakota Johnson
	 **/
	@Test
	void testGetSizeOfEdgesWhenNotConnectedAndMultipleOfSameEdges() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');

		myGraph.addVertex(a);
		myGraph.addVertex(b);

		myGraph.addEdge(new Edge(a, a));
		myGraph.addEdge(new Edge(a, a));
		myGraph.addEdge(new Edge(b, b));
		myGraph.addEdge(new Edge(b, b));

		assertTrue(myGraph.getEdges().size() == 4);
	}

	/**
	 * @author Josiah Falukos My first unit test
	 */
	@Test
	public void testIsAdjacent() {
		IGraph myGraph = new OldGraph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addEdge(new Edge(a, b));

		assertTrue(myGraph.isAdjacent(a, b) == true);
	}

	/**
	 * @author Josiah Falukos My second unit test
	 */
	@Test
	public void areIsolatedVerticesDisconnected() {
		IGraph myGraph = new OldGraph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		myGraph.addVertex(a);
		myGraph.addVertex(b);

		assertTrue(myGraph.isAdjacent(a, b) == false);
	}

	/**
	 * @author Josiah Falukos My third unit test
	 */
	@Test
	public void removeTooManyEdges() {
		try {
			IGraph myGraph = new OldGraph();
			IVertex a = new Vertex('A');
			IVertex b = new Vertex('B');
			myGraph.addVertex(a);
			myGraph.addVertex(b);
			myGraph.addEdge(new Edge(a, b));
			myGraph.removeEdge(0);
			myGraph.removeEdge(1);
		} catch (Exception e) {
			Assert.fail("Catch removing too many edges");
		}
	}

	/**
	 * @author Josiah Falukos My fourth unit test
	 */
	@Test
	public void removeVertexFromEmptyGraphDoesNotCrash() {
		try {
			IGraph myGraph = new OldGraph();
			myGraph.removeVertex(0);
		} catch (Exception e) {
			Assert.fail("Remove vertex from empty graph went wrong");
		}
	}

	/**
	 * @author Josiah Falukos My fifth unit test
	 */
	@Test
	public void addEdgeWithoutConnectingToVertices() {
		try {
			IGraph myGraph = new OldGraph();
			IVertex a = new Vertex('A');
			IVertex b = new Vertex('B');
			myGraph.addEdge(new Edge(a, b));
		} catch (Exception e) {
			Assert.fail("Catch adding an edge without connecting it to vertices");
		}
	}

	/**
	 * @author Tanner Maasen My second test case
	 */
	@Test
	void test_LoopHasEulerCycle_SpecialCase() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// added a loop
		IVertex a = new Vertex('A');
		myGraph.addVertex(a);
		myGraph.addEdge(new Edge(a, a));

		assertTrue(myGraph.hasStrongEulerCycle() == true);
	}

	/**
	 * @author Tanner Maasen My third test case
	 */
	@Test
	void test_TwoLoops_HaveEulerCycle() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// added a loop
		IVertex a = new Vertex('A');
		myGraph.addVertex(a);
		myGraph.addEdge(new Edge(a, a));
		// added a second loop, but they aren't adjacent
		IVertex b = new Vertex('B');
		myGraph.addVertex(b);
		myGraph.addEdge(new Edge(b, b));

		assertTrue(!myGraph.hasStrongEulerCycle());
	}

	/**
	 * @author Tanner Maasen My fourth test case Edited by Ian Berkstresser
	 *         "XVNexus": fixed not adding the vertices to the graph
	 */
	@Test
	void test_AdjacencyVerticies_IsCorrect() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(a, d));

		assertTrue(myGraph.getAdjacentVertices(a).size() == 3);
	}

	/**
	 * @author Tanner Maasen My fifth test case
	 */
	@Test
	void test_GetVertex_Id() {
		IVertex a = new Vertex('A');
		IVertex A = new Vertex('a');

		assertTrue(a.getId() == 'A');
	}

//	/**
//	 * @author Caleb Stucky First Test Case
//	 */
//	@Test
//	public void setID_GraphWithVertexOfSameID_SilentlyRefuse() {
//		IGraph g = new Graph();
//		IVertex a = new Vertex('a');
//		IVertex b = new Vertex('b');
//
//		try {
//			b.setId('a');
//		} catch (UnsupportedOperationException e) {
//
//		}
//
//		assertTrue(b.getId() == 'b');
//	}

	/**
	 * @author Caleb Stucky Second Test Case
	 */
	@Test
	public void newEdge_nullVertex_silentlyRefuse() {
		IGraph g = new OldGraph();
		IVertex a = new Vertex('a');
		IEdge e = new Edge(a, null);

		g.addVertex(a);
		g.addEdge(e);

		assertTrue(g.getEdges().size() == 0);
	}

	/**
	 * @author Caleb Stucky Third Test Case
	 */
	@Test
	public void addVertex_nullVertex_silentlyRefuse() {
		IGraph g = new OldGraph();

		g.addVertex(null);

		assertTrue(g.getVertices().size() == 0);
	}

	/**
	 * @author Caleb Stucky Fourth Test Case
	 */
	@Test
	public void addEdge_edgeThatHasVerticesNotInGraph_silendlyRefuseOrAddVertices() {
		IGraph g = new OldGraph();
		IVertex a = new Vertex('a');
		IVertex b = new Vertex('b');
		IEdge e = new Edge(a, b);

		g.addEdge(e);

		assertTrue(g.getEdges().size() == 0 || g.getVertices().size() == 2);

	}

	/**
	 * @author Caleb Stucky Fifth Unit Test
	 */
	@Test
	public void removeVertice_edgeThatDependsOnRemovedVertice_silentlyRefuseOrRemoveEdge() {
		IGraph g = new OldGraph();
		IVertex a = new Vertex('a');
		IEdge e = new Edge(a, a);

		g.addVertex(a);
		g.addEdge(e);

		g.removeVertex(0);

		assertTrue(g.getVertices().size() == 1 || g.getEdges().size() == 0);
	}

	/**
	 * @author Nolan Perez 1st Test
	 */
	@Test
	void testIfGraphIsNotConnected() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		myGraph.addEdge(new Edge(a, b));

		assertTrue(myGraph.isConnected() == false);
	}

	/**
	 * @author Nolan Perez 2nd Test
	 */
	@Test
	void testIfGraphIsNotComplete() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(a, d));
		myGraph.addEdge(new Edge(b, d));
		myGraph.addEdge(new Edge(c, d));

		assertTrue(myGraph.isComplete() == false);
	}

	/**
	 * @author Nolan Perez 3rd Test
	 */
	@Test
	void testRemoveNonexistentVertexSilentlyRefuses() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		myGraph.addVertex(a);
		myGraph.addVertex(b);

		myGraph.removeVertex(2);

		assertTrue(myGraph.getVertices().size() == 2);
	}

	/**
	 * @author Nolan Perez 4th Test
	 */
	@Test
	void testRemoveNonexistentEdgeSilentlyRefuses() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		myGraph.addVertex(a);
		myGraph.addVertex(b);

		myGraph.addEdge(new Edge(a, b));

		myGraph.removeEdge(1);

		assertTrue(myGraph.getEdges().size() == 1);
	}

	/**
	 * @author Nolan Perez 5th Test, (Apologies for the wall of text.) This is
	 *         designed to test if the program silently refuses vertices after
	 *         adding a 26th. Please leave assertTrue on 26.
	 */
	@Test
	void testVerticeLimit() {
		IGraph myGraph = new OldGraph();

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
		IVertex aa = new Vertex('!');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);
		myGraph.addVertex(e);
		myGraph.addVertex(f);
		myGraph.addVertex(g);
		myGraph.addVertex(h);
		myGraph.addVertex(i);
		myGraph.addVertex(j);
		myGraph.addVertex(k);
		myGraph.addVertex(l);
		myGraph.addVertex(m);
		myGraph.addVertex(n);
		myGraph.addVertex(o);
		myGraph.addVertex(p);
		myGraph.addVertex(q);
		myGraph.addVertex(r);
		myGraph.addVertex(s);
		myGraph.addVertex(t);
		myGraph.addVertex(u);
		myGraph.addVertex(v);
		myGraph.addVertex(w);
		myGraph.addVertex(x);
		myGraph.addVertex(y);
		myGraph.addVertex(z);
		myGraph.addVertex(aa);

		assertTrue(myGraph.getVertices().size() == 27); // edited by Seokwoo. The size must be 27, not 26.
	}

	/**
	 * @author Kaleb Johnson My first test ensures that addEdge works.
	 */
	@Test
	public void testAddEdgeWorks() {
		// instantiate the graph
		IGraph myGraph = new OldGraph();

		// create new vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');

		// add vertices to the graph
		myGraph.addVertex(a);
		myGraph.addVertex(b);

		// create edge connecting the vertices
		myGraph.addEdge(new Edge(a, b));

		assertTrue(myGraph.getEdges().size() == 1);

	}

	/**
	 * @author Kaleb Johnson My second test ensures that addVertex works.
	 */
	@Test
	public void testAddVertexWorks() {
		// instantiate a new graph
		IGraph myGraph = new OldGraph();

		// create a vertex
		IVertex a = new Vertex('A');

		// add vertex to graph
		myGraph.addVertex(a);

		assertTrue(myGraph.getVertices().size() == 1);

	}

	/**
	 * @author Kaleb Johnson My third test ensures that setEdges works.
	 */
	@Test
	public void testSetEdgesWorks() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		List<IEdge> edgeList = new ArrayList<>();
		IEdge firstEdge = new Edge(a, b);
		IEdge secondEdge = new Edge(a, c);
		IEdge thirdEdge = new Edge(b, c);
		edgeList.add(firstEdge);
		edgeList.add(secondEdge);
		edgeList.add(thirdEdge);

		myGraph.setEdges(edgeList);
		assertTrue(myGraph.getEdges().size() == 3);

	}

	/**
	 * @author Kaleb Johnson My fourth test ensures that setVertices works.
	 */
	@Test
	public void testSetVerticesWorks() {
		IGraph myGraph = new OldGraph();

		List<IVertex> vertexList = new ArrayList<>();
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		vertexList.add(a);
		vertexList.add(b);
		vertexList.add(c);

		myGraph.setVertices(vertexList);
		assertTrue(myGraph.getVertices().size() == 3);

	}

	/**
	 * @author Kaleb Johnson My fifth test ensures that removeVertex works for
	 *         existing vertex on a graph.
	 */
	@Test
	public void testRemoveVertexWorks() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');

		myGraph.addVertex(a);
		myGraph.removeVertex(0);

		assertTrue(myGraph.getVertices().size() == 0);
	}

	/**
	 * @author Kaleb Johnson This test ensures that both vertices of an edge are in
	 *         the graph itself. If one or both are not, silently refuse.
	 */
	@Test
	public void addEdgeWithOneorTwoVerticesNotInGraph_SilentlyRefuse() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');

		myGraph.addVertex(a);

		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));

		assertTrue(myGraph.getEdges().size() == 0);
	}

	/**
	 * @author Kaleb Johnson This test ensures that a connected graph with all
	 *         vertices of even degree has a strong Euler cycle even if it has a
	 *         loop.
	 */
	@Test
	public void testHasStrongEulerCycleWithLoops() {
		IGraph myGraph = new OldGraph();

		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(c, d));
		myGraph.addEdge(new Edge(d, a));
		myGraph.addEdge(new Edge(a, a));

		assertTrue(myGraph.hasStrongEulerCycle() == true);
	}

	// Five following tests edited by Ian Berkstresser: Changing == to .equals()
	// when comparing lists.
	/**
	 * @author Bradley Stout
	 */
	@Test
	void testPathExists() {
		IGraph myGraph = new OldGraph();
		IVertex a = new Vertex('A');
		IVertex c = new Vertex('C');

		// edited again by Seokwoo. Changed the data type to Set<IVertex>,
		// since the data type of the method 'getAdjacentVertices' is Set<IVertex>.
		Set<IVertex> connect = new HashSet<>(); // edited by Tanner...was never intialized

		connect.add(a);
		connect.add(c);
		IVertex b = new Vertex('B');

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		assertTrue(myGraph.getAdjacentVertices(b).equals(connect));
	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testAddVertexWorks2() {
		IGraph myGraph = new OldGraph();
		IVertex a = new Vertex('A'); // edit by Tanner: changed from String "" to char ''
		myGraph.addVertex(a);
		List<IVertex> added = new ArrayList<>(); // edited by Tanner...was never intialized
		added.add(a);
		assertTrue(myGraph.getVertices().equals(added));
	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testVerticesStartEmpty() {
		IGraph myGraph = new OldGraph();
		List<IVertex> empty = new ArrayList<>();
		assertTrue(myGraph.getVertices().equals(empty)); // should be empty
	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testEdgesStartEmpty() {
		IGraph myGraph = new OldGraph();
		List<IEdge> empty = new ArrayList<>();
		assertTrue(myGraph.getEdges().equals(empty)); // like with vertices, should be empty
	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testAddEdgesWorks() {
		IGraph myGraph = new OldGraph();
		IVertex a = new Vertex('A'); // edit by Tanner: changed from String "" to char ''
		IVertex b = new Vertex('B'); // edit by Tanner: changed from String "" to char ''
		List<IEdge> edges = new ArrayList<>(); // edited by Tanner...was never intialized
		IEdge e = new Edge(a, b);
		edges.add(e);

		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addEdge(e);

		assertTrue(myGraph.getEdges().equals(edges));
	}

	/**
	 * @author Seokwoo Ha
	 */
	@Test
	void testConnectedWithOneVertex() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');

		myGraph.addVertex(a);

		myGraph.addEdge(new Edge(a, a));

		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author Seokwoo Ha
	 */
	@Test
	void testConnected2() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(c, d));

		assertTrue(myGraph.isConnected());
	}

	/**
	 * @author Seokwoo Ha
	 */
	@Test
	void testComplete2() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		IVertex d = new Vertex('D');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);
		myGraph.addVertex(d);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(a, c));
		myGraph.addEdge(new Edge(a, d));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(b, d));
		myGraph.addEdge(new Edge(c, d));

		assertTrue(myGraph.isComplete());
	}

	/**
	 * @author Seokwoo Ha
	 */
	@Test
	void testCompleteWithMultipleEdges() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		myGraph.addVertex(a);
		myGraph.addVertex(b);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, a));
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, a));

		assertTrue(myGraph.isComplete());
	}

	/**
	 * @author Seokwoo Ha
	 */
	@Test
	void testConnectedWithDupsPaths() {
		// instantiate a graph
		IGraph myGraph = new OldGraph();
		// add vertices
		IVertex a = new Vertex('A');
		IVertex b = new Vertex('B');
		IVertex c = new Vertex('C');
		myGraph.addVertex(a);
		myGraph.addVertex(b);
		myGraph.addVertex(c);

		// add edges to those vertices
		myGraph.addEdge(new Edge(a, b));
		myGraph.addEdge(new Edge(b, c));
		myGraph.addEdge(new Edge(c, a));
		myGraph.addEdge(new Edge(c, b));
		myGraph.addEdge(new Edge(a, b));

		assertTrue(myGraph.isConnected());
	}

	// My unit test naming format is xvt_<method to test>_<params>_<vars in use
	// inside method>
	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_valid_emptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('H');
		IVertex v2 = new Vertex('E');
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_firstNull_emptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = new Vertex('L');
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_secondNull_emptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('L');
		IVertex v2 = null;
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_bothNull_emptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = null;
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_valid_notEmptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('O');
		IVertex v2 = new Vertex('T');
		g.addVertex(v1);
		g.addVertex(v2);
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_firstNull_notEmptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = new Vertex('H');
		g.addVertex(v1);
		g.addVertex(v2);
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_secondNull_notEmptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('E');
		IVertex v2 = null;
		g.addVertex(v1);
		g.addVertex(v2);
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_bothNull_notEmptyVertexListAndEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = null;
		g.addVertex(v1);
		g.addVertex(v2);
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_valid_emptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('R');
		IVertex v2 = new Vertex('E');
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_firstNull_emptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = new Vertex('H');
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_secondNull_emptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('U');
		IVertex v2 = null;
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_bothNull_emptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = null;
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_valid_notEmptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('M');
		IVertex v2 = new Vertex('A');
		g.addVertex(v1);
		g.addVertex(v2);
		g.addEdge(new Edge(v1, v2));
		try {
			assertTrue(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_firstNull_notEmptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = new Vertex('N');
		g.addVertex(v1);
		g.addVertex(v2);
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_secondNull_notEmptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = new Vertex('S');
		IVertex v2 = null;
		g.addVertex(v1);
		g.addVertex(v2);
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "XVNexus"
	 */
	@Test
	public void xvt_isAdjacent_bothNull_notEmptyVertexListAndNotEmptyEdgeList() {
		IGraph g = new OldGraph();
		IVertex v1 = null;
		IVertex v2 = null;
		g.addVertex(v1);
		g.addVertex(v2);
		g.addEdge(new Edge(v1, v2));
		try {
			assertFalse(g.isAdjacent(v1, v2));
		} catch (Exception e) {
			Assert.fail("isAdjacent() is throwing an exception: " + e.getMessage());
		}
	}
}