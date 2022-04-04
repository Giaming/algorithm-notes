package org.algo.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P491findSubsequences {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            backtracing(nums, 0);
            return res;
        }

        private void backtracing(int[] nums, int start) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            int[] used = new int[201];  // -100 <= nums[i] <= 100标记重复值
            for (int i = start; i < nums.length; i++) {
                if (!path.isEmpty() && nums[i] < path.getLast()  // 排除掉不是递增的值
                    || (used[nums[i]+100] == 1)) {  // 排除掉重复值
                    continue;
                }
                used[nums[i]+100] = 1;
                path.add(nums[i]);
                backtracing(nums, i+1);
                path.removeLast();
            }
        }
    }
}
