package org.algo.图.岛屿问题;

/**
 * https://leetcode-cn.com/problems/making-a-large-island/submissions/
 * :TODO 未完成, 需要用并查集来做
 */
public class P827largestIsland {
    //我们不能在方格中标记岛屿的面积，而应该标记岛屿的索引（下标），另外用一个数组记录每个岛屿的面积
    //这道题实际上是对网格做了两遍 DFS：第一遍 DFS 遍历陆地格子，计算每个岛屿的面积并标记岛屿；
    // 第二遍 DFS 遍历海洋格子，观察每个海洋格子相邻的陆地格子
    public int largestIsland(int[][] grid) {
        int max = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    int a = dfs1(grid, i, j);
                    max = Math.max(max, a);
                    dfs2(grid, i, j);
                    grid[i][j] = 0;
                }
            }
        }
        if (max == 0) {
            return dfs1(grid, 0, 0);
        }
        return max;
    }

    private int dfs1(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) return 0;
        if (grid[i][j] != 1) return 0;
        // 标记
        grid[i][j] = 2;
        return 1+ dfs1(grid, i+1, j) +
                dfs1(grid, i-1, j) +
                dfs1(grid, i, j+1) +
                dfs1(grid, i, j-1);
    }

    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    private void dfs2(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) return;
        if (grid[i][j] != 2) return;
        grid[i][j] = 1;
        // 恢复
        dfs2(grid, i+1, j);
        dfs2(grid, i-1, j);
        dfs2(grid, i, j+1);
        dfs2(grid, i, j-1);
    }
}
