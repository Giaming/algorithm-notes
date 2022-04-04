package org.algo.树;

public class P654constructMaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums, 0, nums.length-1);
        }

        private TreeNode buildTree(int[] nums, int low, int high) {
            if (low > high) return null;
            // 寻找最大值的下标索引
            int index = -1;
            int max = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = buildTree(nums, low, index-1);
            root.right = buildTree(nums, index+1, high);
            return root;
        }
    }
}
