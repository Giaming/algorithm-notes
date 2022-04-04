package org.algo.树;


public class P108sortedArrayToBST {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length-1);
        }

        private TreeNode buildTree(int[] nums, int low, int high) {
            if (low > high) return null; // 递归出口
            int mid = low + (high - low) >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, low, mid-1);
            root.right = buildTree(nums, mid+1, high);
            return root;
        }
    }
}
