package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
	
	@Override
	public List<IVertex> getShortestPath(IVertex start, IVertex end) {
		// TODO Auto-generated method stub
		// graded
		return null;
	}

	@Override
	public boolean isWeaklyConnected() {
		// base case
		if (vertices.size() == 1 || vertices.size() == 0)
			return true;
		// won't be enough edges
		if (vertices.size() - 1 > edges.size())
			return false;

		Queue<IVertex> queue = new LinkedList<>();
		Set<IVertex> copyOfVertices = new HashSet<>();
		queue.add(vertices.get(0));

		while (queue.size() > 0) {
			IVertex temp = queue.poll();
			for (IVertex vertex : getAdjacentVertices(temp)) {
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
		// TODO Auto-generated method stub
		// graded
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		// graded
		return false;
	}

	@Override
	public boolean isAdjacent(IVertex pVertex1, IVertex pVertex2) {
		throw new UnsupportedOperationException("Not using isAdjacent on Graphs3");
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
	public List<IVertex> breadthFirstSearch() {
		throw new UnsupportedOperationException("Not using breadthFirstSearch on Graphs3");
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
