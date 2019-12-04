package model;

import java.util.ArrayList;
import java.util.List;

public class Path implements Comparable<Path> {

	private int weight;
	private List<IVertex> vertices = new ArrayList<>();

	// constructors
	public Path(Path oldPath) {
		vertices = new ArrayList<>(oldPath.getVertices());
		weight = oldPath.getWeight();
	}
	
	public Path(List<IVertex> vertices, int weight) {
		this.vertices = new ArrayList<>(vertices);
		this.weight = weight;
	}

	public Path(int weight) {
		this.vertices = new ArrayList<>();
		this.weight = weight;
	}

	public Path() {
		this.vertices = new ArrayList<>();
		this.weight = 0;
	}

	public int getWeight() {
		return weight;
	}

	public IVertex getLastVertex() {
		if (vertices.size() > 0) {
			return vertices.get(vertices.size() - 1);
		}
		return null;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<IVertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<IVertex> vertices) {
		this.vertices = vertices;
	}

	@Override
	public int compareTo(Path o) {
		// compares whatever path weight I'm on to the path weight of the parameter
		// priority queue calls this method itself once something is enqueued or dequeued...auto-sorts
		return this.weight - o.weight;
	}
}
