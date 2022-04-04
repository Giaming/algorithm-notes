package org.algo.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P78subsets {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) {
                res.add(new ArrayList<>());
                return res;
            }
            subsetHelper(nums, 0);
            return res;
        }

        private void subsetHelper(int[] nums, int startIndex) {
            // 「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」
            res.add(new ArrayList<>(path));
            // 终止条件可加可不加
            if (startIndex >= nums.length) {
                return;
            }
            for (int i = startIndex; i < nums.length; i++) {
                path.addLast(nums[i]);
                subsetHelper(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
