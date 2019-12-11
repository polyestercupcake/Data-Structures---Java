package ui;


import model.Maze;

public class Main {

	public static void main(String[] args) {
//		boolean[][] maze = new boolean[][] { 
//			{ true, true, true }, 
//			{ true, false, true }, 
//			{ true, true, true } };
//			// 25 x 20 = 500 cells
			boolean[][] maze = new boolean[][] {
				{ true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true,
						true, true, true, true, false, true, true, true },
				{ false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true,
						true, true, true, true, false, true, true, true },
				{ false, true, true, false, false, false, false, false, false, false, false, false, false, false, false,
						false, false, false, false, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, false, true, true, true, true, true, false, true, true, false,
						false, false, false, false, false, false, true, true, true },
				{ false, true, true, false, true, true, false, true, true, true, true, true, false, true, true, false,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, false, false, false, false, false, false, false, true, true,
						false, true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, true, true, true, false, true, true, false,
						false, false, false, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, true, true, true, false, true, true, true,
						true, true, false, true, true, false, true, true, true },
				{ false, true, true, false, false, false, false, true, true, false, true, true, false, true, true, true,
						true, true, false, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, false, true, true, false, false, false, false,
						true, true, false, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, false, false, false, false, false, false, false, false, false,
						false, false, false, false, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true,
						true, true, true, true, true, false, true, true, true },
				{ false, true, true, false, true, true, false, false, false, false, false, false, false, false, false,
						false, false, false, false, false, false, false, false, false, false },
				{ false, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true,
						true, true, true, true, true, true, true, true, true },
				{ false, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true,
						true, true, true, true, true, true, true, true, true } };
		
		
		Maze m = new Maze(maze);
		System.out.println(m.toString());
		System.out.println(m.getMaze()[24][3]); // works...I'm keeping it r x c
		//System.out.println(m.getAStarPath());
		//System.out.println(m.getIDs());
		//System.out.println(m.getCoordinates());
	}

}
