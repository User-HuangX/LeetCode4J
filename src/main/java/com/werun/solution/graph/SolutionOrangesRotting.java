package com.werun.solution.graph;

import java.util.ArrayDeque;

/**
 * <p>在给定的{@code m x n }网格{@code grid }中，每个单元格可以有以下三个值之一：</p>
 * <p>值 {@code 0 }代表空单元格；</p>
 * <p>值 {@code 1 }代表新鲜橘子；</p>
 * <p>值 {@code 2 }代表腐烂的橘子。</p>
 * <p>每分钟，腐烂的橘子<b> 周围 4 个方向上相邻 </b>的新鲜橘子都会腐烂。</p>
 * <p>返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回{@code -1 }。</p>
 */
public class SolutionOrangesRotting {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        int ans = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.pollFirst();
                int i = pos[0];
                int j = pos[1];
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    fresh--;
                    grid[i][j + 1] = 2;
                    queue.offer(new int[]{i, j + 1});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    fresh--;
                    grid[i][j - 1] = 2;
                    queue.offer(new int[]{i, j - 1});
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    fresh--;
                    grid[i - 1][j] = 2;
                    queue.offer(new int[]{i - 1, j});
                }
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    fresh--;
                    grid[i + 1][j] = 2;
                    queue.offer(new int[]{i + 1, j});
                }
            }
            ans++;
        }
        return fresh == 0 ? ans:-1;
    }
}
