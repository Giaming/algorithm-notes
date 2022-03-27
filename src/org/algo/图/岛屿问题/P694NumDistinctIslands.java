package org.algo.图.岛屿问题;

import java.util.HashSet;

public class P694NumDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        // 记录所有岛屿的序列化结果
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 污染，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    pollute(grid, i, j, sb, 0);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }
    private void pollute(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == 1) {
                // 做一个标记
                grid[i][j] = 2;
                // 前序遍历位置：进入(i,j)
                sb.append(dir);  // dir表示一个方向
                pollute(grid, i+1, j, sb, 1);
                pollute(grid, i-1, j, sb, 2);
                pollute(grid, i, j+1, sb, 3);
                pollute(grid, i, j-1, sb, 4);
                // 后序遍历位置：离开(i,j)
                sb.append(-dir);
            }
        }
    }
}
