package org.algo.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和III
 * @author giaming
 * @date 2022/2/26
 */
public class Solution2LC216 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(n, 1, k);
        return result;
    }

    private void backTracing(int target, int startIndex, int k) {
        if (target < 0) {
            return;
        }
        if (target == 0 && path.size() == k){
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.push(i);
            backTracing(target - i, i + 1, k);
            path.pop();
        }
    }
}
