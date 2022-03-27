package org.algo.图.岛屿问题;

public class P1254ClosedIsland {
    public int closedIsland(int[][] grid) {
        int res = 0;
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        // 污染边界
        for (int i = 0; i < m; i++) {
            int j = 0;
            if (grid[i][j] == 0) pollute(grid, i, j);
            j = n - 1;
            if (grid[i][j] == 0) pollute(grid, i, j);
        }
        for (int j = 0; j < n; j++) {
            int i = 0;
            if (grid[i][j] == 0) pollute(grid, i, j);
            i = m - 1;
            if (grid[i][j] == 0) pollute(grid, i, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    pollute(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void pollute(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == 0) {
                grid[i][j] = 2;  // 污染
                pollute(grid, i+1, j);
                pollute(grid, i-1, j);
                pollute(grid, i, j+1);
                pollute(grid, i, j-1);
            }
        }
    }
}
