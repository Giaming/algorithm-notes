package org.algo.图.岛屿问题;

public class P200NumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null) return res;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    pollute(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void pollute(char[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == '1') {
                // 做一个标记
                grid[i][j] = 'X';
                pollute(grid, i+1, j);
                pollute(grid, i-1, j);
                pollute(grid, i, j+1);
                pollute(grid, i, j-1);
            }
        }
    }
}
