package model;

public class Edge implements IEdge {

	public IVertex Vertex1;
	public IVertex Vertex2;

	// constructor
	public Edge(IVertex a, IVertex b) {
		if (a == null || b == null) {
			return;
		} else {
			this.Vertex1 = a;
			this.Vertex2 = b;
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
	public void setVertices(IVertex Vertex1, IVertex pVertex2) {
		this.Vertex1 = Vertex1;
		this.Vertex2 = pVertex2;
	}

	@Override
	public String toString() {
		return Vertex1 + "" + Vertex2 + "";
	}

}
