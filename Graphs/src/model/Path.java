package model;

import java.util.ArrayList;
import java.util.List;

public class Path implements Comparable<Path> {

	public int weight;
	public List<IVertex> vertices = new ArrayList<>();
	
	 //constructors
    public Path(List<IVertex> vertices, int weight) {
        this.vertices = vertices;
        this.weight = weight;
    }
	
	public int getWeight() {
		return weight;
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
		//compares whatever path I'm on to the path weight of the parameter
		return this.weight - o.weight;
	}
}
