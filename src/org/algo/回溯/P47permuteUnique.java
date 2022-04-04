package org.algo.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P47permuteUnique {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0) return res;
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtracing(nums);
            return res;
        }

        private void backtracing(int[] nums) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
                // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
                // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                // 如果同一树枝nums[i]没使用过开始处理
                if (used[i] == false) {
                    used[i] = true;  // 标记同一树枝nums[i]使用过，防止同一树枝重复使用
                    path.add(nums[i]);
                    backtracing(nums);
                    path.removeLast();
                    used[i] = false;// 回溯
                }
            }
        }
    }
}
