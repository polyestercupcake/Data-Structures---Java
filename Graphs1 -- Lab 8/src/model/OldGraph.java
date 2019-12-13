package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class OldGraph implements IGraph2 {

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

//		if (vertices.size() > 0) {
//			for (IVertex vertex : vertices)
//				if (vertex.getId() == pVertex.getId())
//					return;
//				else
//					vertices.add(pVertex);
//		}
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
	public List<IEdge> getEdges() {
		return edges;
	}

	/**
	 * Utility method to find paths for Euler Cycle.
	 * 
	 * @param currentPath
	 * @param pVertex
	 */
	public List<IVertex> getEulerPath(List<IVertex> currentPath, IVertex pVertex) {

		for (IVertex vertex : getAdjacentVertices(pVertex)) {
			if (!currentPath.contains(vertex)) {
				currentPath.add(vertex);
				if (currentPath == getEulerPath(currentPath, vertex))
					break;
				else
					getEulerPath(currentPath, vertex);
			}
			if (vertex.getId() == currentPath.get(0).getId()) {
				if (vertices.size() == currentPath.size()) {
					currentPath.add(vertex);
					break;
				}
			}
		}
		return currentPath;
	}

	@Override
	public List<IVertex> getStrongEulerCycle(IVertex pVertex) {
		// Definition: A path through a graph which starts and ends at the same vertex
		// and includes every edge exactly once.
		List<IVertex> currentPath = new ArrayList<>();
		// PriorityQueue<List<IVertex>> allPossiblePaths = new PriorityQueue<>(new
		// ShortestPathComparator());

		if (hasStrongEulerCycle() == false)
			return currentPath;
		else {
			// get all possible paths starting at pIndex
			currentPath.add(pVertex);
			currentPath = getEulerPath(currentPath, pVertex);
		}
		return currentPath;
	}

	@Override
	public List<IVertex> getVertices() {
		return vertices;
	}

	@Override
	public boolean hasStrongEulerCycle() {
		// A connected graph has an Euler cycle if and only if every vertex has even
		// degree.
		if (isConnected() == false) {
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
	public boolean isAdjacent(IVertex pVertex1, IVertex pVertex2) {
		if (pVertex1 == null || pVertex2 == null)
			return false;

		for (IEdge e : edges) {
			if ((e.getVertex1() == pVertex1 && e.getVertex2() == pVertex2)
					|| (e.getVertex1() == pVertex2 && e.getVertex2() == pVertex1))
				return true;
		}
		return false;
	}

	@Override
	public boolean isComplete() {
		// if (isConnected() == false) return false;
		for (IVertex v1 : vertices) {
			for (IVertex v2 : vertices) {
				if (v1 != v2)
					if (isAdjacent(v1, v2) == false || isAdjacent(v2, v1) == false) {
						return false;
					}
			}
		}
		return true;
	}

	/**
	 * Weakly Connected.
	 */
	@Override
	public boolean isConnected() {
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
	public void removeEdge(int pIndex) {
		if (pIndex <= edges.size() - 1) {
			edges.remove(pIndex);
		}
	}

	@Override
	public void removeVertex(int pIndex) {

		if (pIndex < 0)
			return;

		if (pIndex == 0) {
			vertices.remove(pIndex);
		}

		if (pIndex < vertices.size()) {
			if (pIndex < vertices.size() || pIndex == vertices.size()) {
				IVertex vertexToRemove = vertices.get(pIndex);
				List<IEdge> toRemove = new ArrayList<>();
				for (IEdge edge : edges) {
					if (edge.getVertex1() == vertexToRemove || edge.getVertex2() == vertexToRemove) {
						toRemove.add(edge);
					}
				}
				for (IEdge edgesToRemove : toRemove) {
					edges.remove(edgesToRemove);
				}
			}
		} else {
			return;
		}
	}

	@Override
	public void setEdges(List<IEdge> pEdges) {
		edges = new ArrayList<>(pEdges);
	}

	@Override
	public void setVertices(List<IVertex> pVertices) {
		vertices = new ArrayList<>(pVertices);
	}

	@Override
	public List<IVertex> depthFirstSearch() {
		Stack<IVertex> stack = new Stack<>();
		List<IVertex> copyOfVertices = new ArrayList<>();

		IVertex temp;
		stack.add(vertices.get(0));

		while (stack.size() > 0) {
			temp = stack.pop();
			if (!copyOfVertices.contains(temp))
				copyOfVertices.add(temp);
			for (IVertex vertex : getAdjacentVertices(temp)) {
				if (!copyOfVertices.contains(vertex)) {
					stack.push(vertex);
				}
			}
		}
		return copyOfVertices;
	}

	@Override
	public List<IVertex> breadthFirstSearch() {
		Queue<IVertex> queue = new LinkedList<>();
		List<IVertex> copyOfVertices = new ArrayList<>();

		copyOfVertices.add(vertices.get(0));
		queue.add(vertices.get(0));

		while (queue.size() > 0) {
			for (IVertex vertex : getAdjacentVertices(queue.poll())) {
				if (!copyOfVertices.contains(vertex)) {
					copyOfVertices.add(vertex);
					queue.add(vertex);
				}
			}
		}
		return copyOfVertices;
	}

	public List<IVertex> getAllPaths(IVertex start, IVertex end, List<IVertex> currentPath,
			PriorityQueue<List<IVertex>> returnValues) {

		if (!getAdjacentVertices(start).isEmpty()) {
			for (IVertex vertex : getAdjacentVertices(start)) {
				if (currentPath.contains(end))
					break;
				if (!currentPath.contains(vertex)) {
					currentPath.add(vertex);
					getAllPaths(vertex, end, currentPath, returnValues);
				}
			}
		}
		return currentPath;
	}

	@Override
	public List<IVertex> getShortestPath(IVertex start, IVertex end) {

		PriorityQueue<List<IVertex>> allPossiblePaths = new PriorityQueue<>(new ShortestPathComparator());
		List<IVertex> currentPath = new ArrayList<>();

		if (start == end) {
			currentPath.add(start);
			return currentPath;
		}

		for (IVertex vertex : getAdjacentVertices(start)) {
			currentPath = new ArrayList<>();
			currentPath.add(start);
			currentPath.add(vertex);
			getAllPaths(vertex, end, currentPath, allPossiblePaths);
			if (currentPath.get(currentPath.size() - 1) == end)
				allPossiblePaths.add(currentPath);
		}

		if (allPossiblePaths.size() == 0) {
			return new ArrayList<>();
		} else {
			return allPossiblePaths.poll();
		}
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
