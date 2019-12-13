package model;

import java.util.List;
import java.util.Set;

public class Graph implements DiGraphable {

	@Override
	public List<IVertex> depthFirstSearch() {
		// TODO Auto-generated method stub
		return null;
		//throw new unsupported operation exception
	}

	@Override
	public List<IVertex> breadthFirstSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEdge(IEdge pEdge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVertex(IVertex pVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<IVertex> getAdjacentVertices(IVertex pVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEdge> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IVertex> getStrongEulerCycle(IVertex pVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IVertex> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStrongEulerCycle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdjacent(IVertex pVertex1, IVertex pVertex2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeEdge(int pIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeVertex(int pIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEdges(List<IEdge> pEdges) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVertices(List<IVertex> pVertices) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IVertex> getShortestPath(IVertex start, IVertex end) {
		// TODO Auto-generated method stub
		//graded
		return null;
	}

	@Override
	public boolean isWeaklyConnected() {
		// TODO Auto-generated method stub
		//graded
		return false;
	}

	@Override
	public boolean isStronglyConnected() {
		// TODO Auto-generated method stub
		//graded
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		//graded
		return false;
	}

}
