package org.algo.图.岛屿问题;


public class P1905CountSubIslands {
    /**
     *  当岛屿B中所有陆地在岛屿A中也是陆地的时候，岛屿B也是岛屿A的子岛。
     *  反过来说，如果岛屿B中存在一片陆地，在岛屿A中的对应位置是海水，那么岛屿B就不是岛屿A的子岛。
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    pollute(grid2, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    pollute(grid2, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void pollute(int[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == 1) {
                // 做一个标记
                grid[i][j] = 0;
                pollute(grid, i+1, j);
                pollute(grid, i-1, j);
                pollute(grid, i, j+1);
                pollute(grid, i, j-1);
            }
        }
    }
}
