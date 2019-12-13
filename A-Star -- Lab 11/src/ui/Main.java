package ui;


import model.Maze;

public class Main {

	public static void main(String[] args) {
		boolean[][] maze1 = new boolean[][] { 
			{ true, false, true , true, true}, 
			{ true, true, true , false, true}, 
			{ true, false, false, true , true } };
			// 25 x 20 = 500 cells
			boolean[][] maze2 = new boolean[][] {
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
					true, true, true, true, true, true, true, true, true }
					};
		
		
		Maze m = new Maze(maze2);
		
		System.out.println("A* Path: \n" + m.getAStarPath());
		System.out.println();
		System.out.println(m.toString());
		
		//System.out.println(m.toString());
		//System.out.println(m.getMaze()[3][22]); // works...I'm keeping it r x c
		//System.out.println(m.getIDs());
		//System.out.println(m.getCoordinates());
	}

}
