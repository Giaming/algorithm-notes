package org.algo.backtracing;

import java.util.*;

/**
 * @author giaming
 * @date 2022/2/26
 */
public class SolutionLC216 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,0,1);
        return result;
    }

    private void backTracking(int targetSum, int k, int sum, int startIndex) {
        if (sum > targetSum) {
            return;
        }
        if (k == path.size()) {
            if (targetSum == sum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.addLast(i);
            sum += i;
            backTracking(targetSum, k, sum, i+1);
            sum -= i;
            path.removeLast();
        }
    }
}
