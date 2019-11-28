package model;

public class Edge implements IEdge {

	public IVertex Vertex1;
	public IVertex Vertex2;
	public int weight;

	// constructor
	public Edge(IVertex a, IVertex b, int c) {
		if (a == null || b == null) {
			return;
		} else {
			this.Vertex1 = a;
			this.Vertex2 = b;
			this.weight = c;
		}
	}

	@Override
	public IVertex getVertex1() {
		return Vertex1;
	}

	@Override
	public IVertex getVertex2() {
		return Vertex2;
	}

	@Override
	public void setVertex1(IVertex pVertex1) {
		this.Vertex1 = pVertex1;
	}

	@Override
	public void setVertex2(IVertex pVertex2) {
		this.Vertex2 = pVertex2;
	}

	@Override
	public void setVertices(IVertex pVertex1, IVertex pVertex2) {
		this.Vertex1 = pVertex1;
		this.Vertex2 = pVertex2;
	}
	
	@Override
	public int getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(int pWeight) {
		this.weight = pWeight;
	}

	@Override
	public String toString() {
		return "["+ Vertex1 + " -> " + weight + " -> " + Vertex2 + "]" ;
	}

}
