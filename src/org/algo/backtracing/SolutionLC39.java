package org.algo.backtracing;

import java.util.*;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 * @author giaming
 */
public class SolutionLC39 {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target,int sum, int startIdx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // sum + candidates[i] <= target  属于剪枝操作
        for (int i = startIdx; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.push(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.pop();
        }
    }

}
