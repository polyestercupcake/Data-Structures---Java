package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Path implements Comparable<Path> {

	private List<Cell> cells = new ArrayList<>(); // cells I've traveled through...VISITED

	// methods
	public List<Cell> getCells() {
		return cells;
	}

	public Cell getLastCell() {
		if (cells.size() > 0) {
			return cells.get(cells.size() - 1);
		}
		return null;
	}

//	public void setCells(List<Cell> cells) {
//		this.cells = cells;
//	}

	public int gethCost() {
		return getLastCell().getHCost();
	}

	public int getgCost() {
		return cells.size() - 1;
	}

	public int getfCost() {
		return gethCost() + getgCost();
	}

	public List<Integer> getIDs() {
		return cells.stream().map(cell -> cell.getID()).collect(Collectors.toList());
	}

	@Override
	public int compareTo(Path o) {
		// we are comparing the fCost of paths...may have to possibly compare hCosts too
		return this.getfCost() - o.getfCost();
	}

}
