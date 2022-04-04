package org.algo.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author giaming
 */
public class P40combinationSum2 {
    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backTracing(candidates, target, 0, 0);
            return result;
        }

        private void backTracing(int[] candidates, int target, int sum, int startIdx) {
            if (target < sum) {
                return;
            }
            if (sum == target) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIdx; i < candidates.length && sum + candidates[i] <= target; i++) {
                // used[i-1] == true, 说明同一树枝candidates[i-1]使用过
                // used[i-1] == false, 说明同一树层candidates[i-1]使用过
//            if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) {
//                continue;
//            }
                if (i > startIdx && candidates[i] == candidates[i-1]) {
                    continue;
                }
                path.push(candidates[i]);
                sum += candidates[i];
//            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i])+" sum = " + sum);
                backTracing(candidates, target, sum, i+1);
                sum -= candidates[i];
                path.pop();
//            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i])+" sum = " + sum);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        P40combinationSum2.Solution solution = new P40combinationSum2.Solution();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
}
