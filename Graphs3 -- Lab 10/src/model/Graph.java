package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Graph implements DiGraphable {

	private List<IVertex> vertices = new ArrayList<>();
	private List<IEdge> edges = new ArrayList<>();

	@Override
	public void addEdge(IEdge pEdge) {
		// Should reject the edge if the vertices don't exist in the graph.
		if (vertices.size() < 2)
			return; // checks if there are any vertices to add
		if (pEdge.getVertex1() == null || pEdge.getVertex2() == null)
			return;
		else
			edges.add(pEdge);
	}

	@Override
	public void addVertex(IVertex pVertex) {
		if (pVertex == null)
			return;
		else
			vertices.add(pVertex);
	}

	@Override
	public List<IEdge> getEdges() {
		return edges;
	}

	@Override
	public List<IVertex> getVertices() {
		return vertices;
	}

	@Override
	public Set<IVertex> getAdjacentVertices(IVertex pVertex) {

		Set<IVertex> adjacentVertices = new HashSet<>();

		for (IEdge edge : edges) {
			if (edge.getVertex1() == pVertex) {
				adjacentVertices.add(edge.getVertex2());
			} // else if (edge.getVertex2() == pVertex) {
				// adjacentVertices.add(edge.getVertex1());
				// }
		}
		return adjacentVertices;
	}

	/**
	 * Utility method to get all adjacent edges of a given vertex.
	 * 
	 * @param pVertex
	 * @return
	 */
	public Set<IEdge> getAdjacentEdges(IVertex pVertex) {

		Set<IEdge> adjacentEdges = new HashSet<>();

		for (IEdge edge : edges) {
			if (edge.getVertex1() == pVertex) {
				adjacentEdges.add(edge);
			} // else if (edge.getVertex2() == pVertex) {
				// adjacentVertices.add(edge.getVertex1());
				// }
		}
		return adjacentEdges;
	}

	/**
	 * Utility method to get all adjacent vertices from a given vertex without
	 * respecting direction.
	 * 
	 * @param pVertex
	 * @return
	 */
	public Set<IVertex> getAdjacentUndirectedVertices(IVertex pVertex) {

		Set<IVertex> adjacentVertices = new HashSet<>();

		for (IEdge edge : edges) {
			if (edge.getVertex1() == pVertex) {
				adjacentVertices.add(edge.getVertex2());
			} else if (edge.getVertex2() == pVertex) {
				adjacentVertices.add(edge.getVertex1());
			}
		}
		return adjacentVertices;
	}

	@Override
	public List<IVertex> getStrongEulerCycle(IVertex pVertex) {
		// TODO: BONUS +5 POINTS
		return null;
	}

	@Override
	public boolean hasStrongEulerCycle() {
		// BONUS +5 POINTS
		// A connected graph has an Euler cycle if and only if every vertex has even
		// degree.
		if (isStronglyConnected() == false) {
			return false;
		}
		for (IVertex vertex : vertices) {
			if (getAdjacentVertices(vertex).size() % 2 != 0) {
				if (!isAdjacent(vertex, vertex)) // checking for vertex loops
					return false;
			}
		}
		return true;
	}

	public void getAllPaths(IVertex end, Path currentPath, PriorityQueue<Path> possiblePaths) {
		// recursion
		// terminating case
		if (end.equals(currentPath.getLastVertex())) {
			possiblePaths.add(currentPath);
		} else { // recursive case
			for (IEdge edge : getAdjacentEdges(currentPath.getLastVertex())) { // this will kill the path if no where to go
				if (!currentPath.getVertices().contains(edge.getVertex2())) {
					// passing by object reference and by value reference...study
					// don't mess with currentPath because that would mess it up for everyone else
					// make a copy and mess with it.
					Path newPath = new Path(currentPath);
					newPath.getVertices().add(edge.getVertex2());
					newPath.setWeight(newPath.getWeight() + edge.getWeight());
					getAllPaths(end, newPath, possiblePaths);
				}
			}
		}

	}

	@Override
	public List<IVertex> getShortestPath(IVertex start, IVertex end) {

		PriorityQueue<Path> possiblePaths = new PriorityQueue<>();

		if (start == end) {
			return Arrays.asList(start);
		}

		for (IEdge edge : getAdjacentEdges(start)) {
			Path currentPath = new Path(Arrays.asList(start, edge.getVertex2()), edge.getWeight());
			getAllPaths(end, currentPath, possiblePaths);
		}
//		System.out.println("All paths");
//		possiblePaths.forEach(x -> System.out.println(x.getVertices() + ": " + x.getWeight()));
//		System.out.println("---------------");		
		return possiblePaths
				.stream()
				.findFirst()
				.orElse(new Path())
				.getVertices();
	}

	@Override
	public boolean isWeaklyConnected() {
		// base case
		if (vertices.size() == 1 || vertices.size() == 0)
			return true;
		if (vertices.size() - 1 > edges.size())
			return false;

		Queue<IVertex> queue = new LinkedList<>();
		Set<IVertex> copyOfVertices = new HashSet<>();
		queue.add(vertices.get(0));
		//copyOfVertices.add(vertices.get(0));

		while (queue.size() > 0) {
			IVertex temp = queue.poll();
			for (IVertex vertex : getAdjacentUndirectedVertices(temp)) {
				if (!copyOfVertices.contains(vertex)) {
					copyOfVertices.add(vertex);
					queue.add(vertex);
				}
			}
		}
		if (copyOfVertices.size() == vertices.size())
			return true;
		else
			return false;
	}

	@Override
	public boolean isStronglyConnected() {

		List<IVertex> returnValues = new ArrayList<>();

		if (vertices.size() == 1 || vertices.size() == 0)
			return true;
		if (isWeaklyConnected() == false)
			return false;

		for (IVertex vertex : vertices) {
			returnValues.clear();
			returnValues = breadthFirstSearch(vertex);
			if (returnValues.size() != vertices.size())
				return false;
		}
		return true;
	}

	@Override
	public boolean isComplete() {
		// every pair of distinct vertices is connected by a pair of
		// unique edges (one in each direction).
		for (IVertex v1 : vertices) {
			for (IVertex v2 : vertices) {
				if (v1 != v2)
					if (isAdjacent(v1, v2) == false || isAdjacent(v2, v1) == false)
						return false;
			}
		}
		return true;
	}

	@Override
	public boolean isAdjacent(IVertex pVertex1, IVertex pVertex2) {
		if (pVertex1 == null || pVertex2 == null)
			return false;

		for (IEdge e : edges) {
			if ((e.getVertex1() == pVertex1 && e.getVertex2() == pVertex2))
				return true;
		}
		return false;
	}

	@Override
	public boolean isConnected() {
		throw new UnsupportedOperationException("See isWeaklyConnected");
	}

	@Override
	public void removeEdge(int pIndex) {
		throw new UnsupportedOperationException("Not using removeEdge on Graphs3");
	}

	@Override
	public void removeVertex(int pIndex) {
		throw new UnsupportedOperationException("Not using removeVertex on Graphs3");
	}

	@Override
	public void setEdges(List<IEdge> pEdges) {
		throw new UnsupportedOperationException("Not using setEdges on Graphs3");
	}

	@Override
	public void setVertices(List<IVertex> pVertices) {
		throw new UnsupportedOperationException("Not using setVertices on Graphs3");
	}

	@Override
	public List<IVertex> depthFirstSearch() {
		throw new UnsupportedOperationException("Not using depthFirstSearch on Graphs3");
	}

	@Override
	public List<IVertex> breadthFirstSearch(IVertex vertex) {
		Queue<IVertex> queue = new LinkedList<>();
		List<IVertex> copyOfVertices = new ArrayList<>();

		copyOfVertices.add(vertex);
		queue.add(vertex);

		while (queue.size() > 0) {
			for (IVertex v : getAdjacentVertices(queue.poll())) {
				if (!copyOfVertices.contains(v)) {
					copyOfVertices.add(v);
					queue.add(v);
				}
			}
		}
		return copyOfVertices;
	}

	@Override
	public String toString() {
		StringBuilder stringToReturn = new StringBuilder();
		for (int n = 0; n < vertices.size(); n++) {
			stringToReturn.append(vertices.get(n));
		}
		for (int n = 0; n < edges.size(); n++) {
			stringToReturn.append(edges.get(n));
		}
		return stringToReturn.toString();
	}

}
