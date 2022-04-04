package org.algo.回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和III
 * @author giaming
 * @date 2022/2/26
 */
public class P216combinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(n, k, 1);
        return result;
    }

    private void backTracing(int target, int k, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0 && path.size() == k){
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.push(i);
            backTracing(target - i, k, i+1);
            path.pop();
        }
    }
}
