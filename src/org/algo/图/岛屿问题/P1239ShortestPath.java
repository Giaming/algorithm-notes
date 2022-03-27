package org.algo.图.岛屿问题;

import java.util.Arrays;
import java.util.LinkedList;

// 使用BFS+队列的方法解决
public class P1239ShortestPath {
    /**
     * 由于玩家在最短路中显然不会经过同一个位置超过一次，因此最多消除k个障碍物
     * 等价于最多经过k个障碍物。
     *
     * 我们可以使用三元组(x,y,rest)表示一个搜索状态，其中(x,y)表示玩家的位置，
     * rest表示玩家还可以经过的rest个障碍物，它的值必须为非负整数。对于当前的状态
     * (x,y,rest)，它可以向最多四个新状态进行搜索，即将玩家(x,y)向四个方向移动一格。
     * (x,y)->(mx+dx,my+dy)。
     */
    // 四个搜寻方向
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int level = 0;
        LinkedList<int[]> que = new LinkedList<>();
        if (grid[0][0] == 0) {
            que.add(new int[]{0,0,0});
            visited[0][0] = 0;
        }else {
            if (k < 1) {
                return -1;
            }
            que.add(new int[]{0,0,0});
            visited[0][0] = 1;
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return level;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    int step = grid[x][y] + cur[2];
                    if (step > k || visited[x][y] <= step) {
                        continue;
                    }
                    que.add(new int[]{x,y,step});
                    visited[x][y] = step;
                }
            }
            level++;
        }
        return -1;
    }
}
