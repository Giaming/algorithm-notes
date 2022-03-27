package org.algo.图.岛屿问题;

public class P695MaxAreaOfIsland {
    private int cnt = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 将cnt清零
                cnt = 0;
                if (grid[i][j] == 1) {
                    pollute(grid, i, j);
                }
                // 更新结果，找出岛屿最大的数量
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
    private void pollute(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == 1) {
                // 污染
                grid[i][j] = 2;
                cnt++;
                pollute(grid, i+1, j);
                pollute(grid, i-1, j);
                pollute(grid, i, j+1);
                pollute(grid, i, j-1);
            }
        }
    }
}
