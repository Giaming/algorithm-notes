package org.algo.回溯;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 * @author giaming
 * @date 2022/2/26
 */
public class P77combine {
    class Solution{
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        public List<List<Integer>> combine(int n, int k) {
            if (k <= 0 || n < k) {
                return result;
            }
            backTracing(n,k,1);  // DFS
            return result;
        }

        private void backTracing(int n, int k, int startIndex) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.addLast(i);
                backTracing(n,k,i+1);
                path.removeLast();
            }
        }
    }
}
