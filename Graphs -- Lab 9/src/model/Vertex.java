package model;

public class Vertex implements IVertex {

	public char vertexId;

	public Vertex(char c) {
// the char represents the "value" inside the vertex, or the id
		this.vertexId = c;
	}

	@Override
	public char getId() {
		return vertexId;
	}

	@Override
	public void setId(char pId) {
		this.vertexId = pId;
	}

	@Override
	public String toString() {
		return vertexId + "";
	}

}
