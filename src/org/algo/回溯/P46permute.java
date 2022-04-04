package org.algo.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46permute {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) return res;
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
                if (used[i]) continue;
                used[i] = true;
                path.add(nums[i]);
                backtracing(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
