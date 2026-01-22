package com.werun.solution.graph;

/**
 * <p>给你一个由 {@code '1'}（陆地）和 {@code '0'}（水）组成的的二维网格，请你计算网格中岛屿的数量。</p>
 * <p>岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。</p>
 * <p>此外，你可以假设该网格的四条边均被水包围。</p>
 */
public class SolutionNumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //发现大陆
                if (grid[i][j] == '1') {
                    //递归搜索
                    findNext(i,j,grid);
                    res ++;
                }
            }
        }
        return res;
    }

    private void findNext(int i, int j, char[][] grid) {
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        if (j + 1 < grid[0].length) findNext(i, j + 1, grid);
        if (j - 1 >= 0) findNext(i, j - 1, grid);
        if (i - 1 >= 0) findNext(i - 1, j, grid);
        if (i + 1 < grid.length) findNext(i + 1, j, grid);
    }
}
