package model;

public class Cell {

	private boolean traverseable = true;
	private int maxRowSize = 0;
	private int maxColumnSize = 0;
	private int row = 0;
	private int column = 0;

	public Cell(int row, int maxRowSize, int column, int maxColumnSize, boolean traverseable) {
		this.row = row;
		this.column = column;
		this.maxRowSize = maxRowSize;
		this.maxColumnSize = maxColumnSize;
		this.traverseable = traverseable;
	}

	public boolean isTraverseable() {
		return traverseable;
	}

	public int getHCost() {
		// difference between x and max x + difference between y and max y
		return (row - (maxRowSize-1)) + (column - (maxColumnSize-1));
	}

	public int getID() {
		return (maxColumnSize * row) + column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getID());
	}

}
