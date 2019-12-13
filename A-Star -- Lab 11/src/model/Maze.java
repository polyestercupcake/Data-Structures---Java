package model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Maze extends AbstractMaze {

	private Cell[][] maze;
	private int maxRowSize = 0;
	private int maxColumnSize = 0;
	List<Integer> pathToReturn = new ArrayList<>();

	// constructor : pretty much is an early-on setter...gotta have your clothes on
	// before you go outside
	public Maze(boolean[][] booleanMaze) {
		super(booleanMaze); // calls parent constructor (AbstractMaze)
		if (booleanMaze == null)
			return;
		else {
			maxRowSize = booleanMaze.length; // 20
			maxColumnSize = booleanMaze[0].length; // 25
			maze = new Cell[maxRowSize][maxColumnSize];
			createArrayOfCells(booleanMaze);
		}
	}

	public Cell[][] getMaze() {
		return maze;
	}

	public void createArrayOfCells(boolean[][] booleanMaze) {
		for (int row = 0; row < booleanMaze.length; row++) {
			for (int column = 0; column < booleanMaze[0].length; column++) {
				if (booleanMaze[row][column] == true) {
					maze[row][column] = new Cell(row, maxRowSize, column, maxColumnSize, true);
				} else {
					maze[row][column] = new Cell(row, maxRowSize, column, maxColumnSize, false);
				}
			}
		}
	}

	public String getCoordinates() {
		for (int row = 0; row < maze.length; row++) {
			for (int column = 0; column < maze.length; column++) {
				System.out.print("(" + maze[row][column].getRow() + "," + maze[row][column].getColumn() + ")" + " ");
			}
		}
		return "";
	}

	public String getIDs() {
		System.out.println("ID: ");
		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze.length; x++) {
				System.out.print(maze[y][x].getID() + ", ");
			}
		}
		return "";
	}

	@Override
	public List<Integer> getAStarPath() {

		PriorityQueue<Path> possiblePaths = new PriorityQueue<>();
		List<Cell> cellsVisited = new ArrayList<>();
		Path currentPath = new Path();
		Path newPath = new Path();
		if (maze == null) {
			return null;
		}
		if (maze.length == 1) {
			currentPath.getCells().add(maze[0][0]);
			return currentPath.getIDs();
		}

		cellsVisited.add(maze[0][0]);
		currentPath.getCells().add(maze[0][0]);
		possiblePaths.add(currentPath);
		
		while (possiblePaths.size() > 0) {
			currentPath = possiblePaths.poll();
			for (Cell cell : getAdjacentCells(currentPath.getLastCell())) {
				if (!cellsVisited.contains(cell)) {
					if (cell.isTraverseable()) {
						newPath = new Path();
						newPath.getCells().addAll(currentPath.getCells());
						newPath.getCells().add(cell);
						cellsVisited.add(cell);
						possiblePaths.add(newPath);
					}
				}
			}
//		System.out.println(currentPath.getfCost( ) + " = " + currentPath.getgCost() + " + " + currentPath.gethCost());
			if (currentPath.getLastCell().getID() == maze[maxRowSize-1][maxColumnSize-1].getID()) {
//				System.out.println(currentPath.getIDs());
//				System.out.println(currentPath.getIDs().size());
				pathToReturn = currentPath.getIDs();
				return currentPath.getIDs();
			}
		}
		return new ArrayList<>();
	}

	public List<Cell> getAdjacentCells(Cell currentCell) {
		List<Cell> TraversableCells = new ArrayList<>();

		if (currentCell != null) {
			if (currentCell.getColumn() != maxColumnSize - 1) {
				Cell rightOfCurrent = maze[currentCell.getRow()][currentCell.getColumn() + 1];
				if (rightOfCurrent.isTraverseable()) {
					TraversableCells.add(rightOfCurrent);
				}
			}
			if (currentCell.getRow() != maxRowSize - 1) {
				Cell bottomOfCurrent = maze[currentCell.getRow() + 1][currentCell.getColumn()];
				if (bottomOfCurrent.isTraverseable()) {
					TraversableCells.add(bottomOfCurrent);
				}
			}
			if (currentCell != maze[currentCell.getRow()][0]) {
				Cell leftOfCurrent = maze[currentCell.getRow()][currentCell.getColumn() - 1];
				if (leftOfCurrent.isTraverseable()) {
					TraversableCells.add(leftOfCurrent);
				}
			}
			if (currentCell != maze[0][currentCell.getColumn()]) {
				Cell topOfCurrent = maze[currentCell.getRow() - 1][currentCell.getColumn()];
				if (topOfCurrent.isTraverseable()) {
					TraversableCells.add(topOfCurrent);
				}
			}
		}
		return TraversableCells;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		if (maze == null) {
			return null;
		}
		for (int x = 0; x < maze.length; x++) {
			s.append("[ ");
			for (int y = 0; y < maze[0].length; y++) {
				
				if (pathToReturn.contains(maze[x][y].getID()))
					s.append(" * ");
				else if (maze[x][y].isTraverseable() == false)
					s.append(" X ");
				else
					s.append("   ");
				// s.append(" " + maze[x][y] + " "); // for cellID
			}
			s.append(" ]");
			s.append("\n");
		}

		return s.toString();
	}

}
