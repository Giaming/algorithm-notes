package org.algo.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P90subsetsWithDup {
    // 使用used数组
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0) {
                result.add(path);
                return result;
            }
            Arrays.sort(nums);
            used = new boolean[nums.length];
            subsetsWithDup(nums, 0);
            return result;
        }

        private void subsetsWithDup(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));
            if (startIndex >= nums.length) {
                return;  // 可不写
            }
            for (int i = startIndex; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                subsetsWithDup(nums, i + 1);
                path.removeLast();
                used[i] = false;
            }
        }
    }


    // 不使用used数组
    class Solution2 {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            subsetsWithHelper(nums, 0);
            return result;
        }

        private void subsetsWithHelper(int[] nums, int start) {
            result.add(new ArrayList<>(path));
            for (int i = start; i < nums.length; i++) {
                // 跳过当前树层使用过的相同的元素
                if (i > start && nums[i - 1] == nums[i]) {
                    continue;
                }
                path.add(nums[i]);
                subsetsWithHelper(nums, i+1);
                path.removeLast();
            }
        }
    }
}
