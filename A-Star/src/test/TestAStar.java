package test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import model.AbstractMaze;
import model.Maze;

class TestAStar {
	/**
	 * @author cberkstresser
	 */
	@Test
	void testMegaMaze() {
		/*
		 * This takes just over 3 minutes on my machine...
		 */
		boolean[][] maze = readImage("src/test/fractal.gif");

		AbstractMaze m = new Maze(maze);
		assertTrue(m.getAStarPath().size() == 2109);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testMidMaze() {
		/*
		 * This takes just over 30 seconds on my machine...
		 */
		boolean[][] maze = readImage("src/test/fractal2.gif");

		AbstractMaze m = new Maze(maze);
		assertTrue(m.getAStarPath().size() == 1628);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testSmallMaze() {
		boolean[][] maze = getSmallMaze();
		AbstractMaze m = new Maze(maze);

		assertTrue(m.getAStarPath().size() == 78);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testNullReturnsNull() {
		boolean[][] maze = null;
		AbstractMaze m = new Maze(maze);

		assertNull(m.getAStarPath());
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void testSingletonReturnsSingleton() {
		boolean[][] maze = new boolean[][] { { true } };
		AbstractMaze m = new Maze(maze);

		assertTrue(m.getAStarPath().equals(Arrays.asList(0)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void test2x3WithNoBlocks() {
		boolean[][] maze = new boolean[][] { { true, true, true }, { true, true, true } };
		AbstractMaze m = new Maze(maze);

		assertTrue(
				m.getAStarPath().equals(Arrays.asList(0, 1, 2, 5)) || m.getAStarPath().equals(Arrays.asList(0, 3, 4, 5))
						|| m.getAStarPath().equals(Arrays.asList(0, 1, 4, 5)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void test3x3WithMiddleBlock() {
		boolean[][] maze = new boolean[][] { { true, true, true }, { true, false, true }, { true, true, true } };
		AbstractMaze m = new Maze(maze);

		assertTrue(m.getAStarPath().equals(Arrays.asList(0, 1, 2, 5, 8))
				|| m.getAStarPath().equals(Arrays.asList(0, 3, 6, 7, 8)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void test3x3WithMiddleAndSideBlock() {
		boolean[][] maze = new boolean[][] { { true, true, true }, { true, false, false }, { true, true, true } };
		AbstractMaze m = new Maze(maze);

		assertTrue(m.getAStarPath().equals(Arrays.asList(0, 3, 6, 7, 8)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void test3x3TotalBlock() {
		boolean[][] maze = new boolean[][] { { true, true, true }, { false, false, false }, { true, true, true } };
		AbstractMaze m = new Maze(maze);

		assertTrue(m.getAStarPath().size() == 0);
	}

	private boolean[][] getSmallMaze() {
		return new boolean[][] {
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
	}

	private boolean[][] readImage(String fileName) {
		boolean[][] maze = null;
		try {
			BufferedImage image = ImageIO.read(new File(fileName));
			maze = new boolean[image.getHeight()][image.getWidth()];
			for (int row = 0; row < image.getHeight(); ++row) {
				for (int column = 0; column < image.getWidth(); ++column) {
					maze[row][column] = new Color(image.getRGB(column, row)).getRed() > 128 ? true : false;
				}
			}
			image = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maze;
	}
	
    /**
     * Writes an image to disk.
     * 
     * @param aStarPath     The aStarPath to plot on the image
     * @param inputFileMaze The path/file of the input image on which we found a
     *                      path.
     * @param outputFile    A new file taking the input image and adding the path.
     */
    private static void writeImage(List<Integer> aStarPath, String inputFileMaze, String outputFile) {
        BufferedImage input;
        try {
            input = ImageIO.read(new File(inputFileMaze));
            for (int row = 0; row < input.getHeight(); ++row) {
                for (int column = 0; column < input.getWidth(); ++column) {
                    if (aStarPath.contains(row * input.getWidth() + column)) {
                        // draw path in red.
                        input.setRGB(column, row, Color.RED.getRGB());
                    }
                }
            }
            ImageIO.write(input, "gif", new File(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
