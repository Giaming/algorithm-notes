package org.algo.并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。
 */
// 并查集
public class P323CountComponents {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        // 将每个节点进行连通
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        // 返回连通分量的个数
        return uf.count();
    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储每个节点的父节点
        private int[] parent;

        // n为图中节点的个数
        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 将节点p和节点q连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootQ] = rootP;
            // 两个连通分量合并成一个连通分量
            count--;
        }

        // 返回节点x的连通分量根节点
        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }
}

class Solution323 {
    // 方法二： 深度优先搜索
    public static boolean[] isVisited; // 判断该节点是否背访问过
    public static int countComponents(int n, int[][] edges) {
        isVisited = new boolean[n];
        List<List<Integer>> edgeList = new ArrayList();
        // 先建图
        for(int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<Integer>());
        }
        for (int[] e : edges) {
            edgeList.get(e[0]).add(e[1]);
            edgeList.get(e[1]).add(e[0]);
        }

        int count = 0; // 连通的数量
        for(int i = 0; i < n; i++) {
            if (!isVisited[i]) { // 如果没有访问过，说明有另外一组连通分量
                count++;
                dfs(edgeList, i);
            }
        }
        return count;
    }

    /**
     * @param edgeList 连通分量的无向图
     * @param start
     */
    private static void dfs(List<List<Integer>> edgeList, int start) {
        isVisited[start] = true;
        for (int element : edgeList.get(start)) {
            if (!isVisited[element]) {
                dfs(edgeList, element);
            }
        }
    }
}
