package com.hhlzr.contest10;

public class _463_islandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(grid));
	}

	static public int islandPerimeter(int[][] grid) {
		int p = 0;
		int width = grid[0].length;
		int height = grid.length;
		System.out.println("width:" + width + "\theight:" + height);
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++) {
				if (grid[i][j] == 1){
					p += 4;
					if (j != 0 && grid[i][j-1] == 1)
						p -= 1;
					if (i != 0 && grid[i-1][j] == 1)
						p -= 1;
					if (j != width - 1 && grid[i][j + 1] == 1)
						p -= 1;
					if (i != height - 1 && grid[i + 1][j] == 1)
						p -= 1;
				}
			}
		return p;
	}
}
