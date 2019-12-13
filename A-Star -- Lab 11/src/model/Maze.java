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

	public void getAllPaths(Path currentPath, PriorityQueue<Path> possiblePaths) {
		// recursion
		// terminating case
		if (maze[maxRowSize - 1][maxColumnSize - 1].equals(currentPath.getLastCell())) {
			possiblePaths.add(currentPath);
		} else { // recursive case
			for (Cell cell : getAdjacentCells(currentPath.getLastCell())) { // this will kill the path if no where to go
				if (!currentPath.getIDs().contains(cell.getID())) {
					// passing by object reference and by value reference...study
					// don't mess with currentPath because that would mess it up for everyone else
					// make a copy and mess with it.

					// evaluate new h cost (figure out how to calculate)
					// add each new path to possiblePaths
					if (currentPath.getLastCell().getHCost() > cell.getHCost()) {
						Path newPath = new Path();
						newPath.getCells().addAll(currentPath.getCells());
						newPath.getCells().add(cell);
						// possiblePaths.add(newPath);
						getAllPaths(newPath, possiblePaths);
					}
				}
			}
		}
	}

	@Override
	public List<Integer> getAStarPath() {

		PriorityQueue<Path> possiblePaths = new PriorityQueue<>();
		List<Cell> cellsVisited = new ArrayList<>();
<<<<<<< refs/remotes/origin/master
		// List<Cell> notVisited = new ArrayList<>();
		if (maze == null) {
			return null;
		}
		// for (Cell cell : getAdjacentCells(maze[0][0])) {
		Path path = new Path();
		// add first value at 0,0
		path.getCells().add(maze[0][0]);
		// cellsVisited.add(maze[0][0]);
		// path.getCells().add(cell);
		// cellsVisited.add(cell);
		// possiblePaths.add(path);
		getAllPaths(path, possiblePaths);
		// }

		// get it's cells to the right and below if neither is false
		// (sometimes will have to check cell to currentCell's left)
		// create getAdjacentCells(currentCell)
		// evaluate new f cost, g cost (figure out how to calculate)
		// add each new path to possiblePaths
		// go until all paths are found
		// as soon as you find one that contains your ending value, kill it and return
		// that path if it's == to the F cost and has the smallest h cost

//			System.out.println("All paths");
=======
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
//					if (currentPath.getLastCell().getHCost() > cell.getHCost()
					if (cell.isTraverseable()) {
						newPath = new Path();
						newPath.getCells().addAll(currentPath.getCells());
						newPath.getCells().add(cell);
						cellsVisited.add(cell);
						possiblePaths.add(newPath);
					}
				}
			}
		System.out.println(currentPath.getfCost( ) + " = " + currentPath.getgCost() + " + " + currentPath.gethCost());
			if (currentPath.getLastCell().getID() == maze[maxRowSize-1][maxColumnSize-1].getID()) {
//				System.out.println(currentPath.getIDs());
//				System.out.println(currentPath.getIDs().size());
				pathToReturn = currentPath.getIDs();
				return currentPath.getIDs();
			}
		}

//			System.out.println("All paths: " + possiblePaths.size());
>>>>>>> A* Finished
//			possiblePaths.forEach(x -> System.out.println(x.getIDs()));
//			System.out.println("---------------");
			
//		 return possiblePaths // auto hits compareTo when a new path is added
//		 .stream().findFirst().orElse(new Path()).getIDs();
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
		// spaces where it's open
		// *'s where the path goes
		// x's where there are blocks
		// [] for bounds
		StringBuilder s = new StringBuilder();
		if (maze == null) {
			return null;
		}
		for (int x = 0; x < maze.length; x++) {
			s.append("[ ");
			for (int y = 0; y < maze[0].length; y++) {
<<<<<<< refs/remotes/origin/master
				if (maze[x][y].isTraverseable() == false)
					s.append(" X ");
				else
					s.append(" O ");
=======
				
				if (pathToReturn.contains(maze[x][y].getID()))
					s.append(" * ");
				else if (maze[x][y].isTraverseable() == false)
					s.append(" X ");
				else
					s.append("   ");
>>>>>>> A* Finished
				// s.append(" " + maze[x][y] + " "); // for cellID
			}
			s.append(" ]");
			s.append("\n");
		}

		return s.toString();
	}

	/*
	 * int counter = 0; // start cell on 0 // in my list ArrayList...add to the
	 * arrayList a number that will correspond to // each boolean value in the maze
	 * for (int m = 0; m < maze.length; m++) { for (int x = 0; x < maze.length; x++)
	 * { list.add(counter++); } } System.out.println("List of values: " + list);
	 */

}
