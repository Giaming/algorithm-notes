package org.algo.树;

public class P538convertBST {
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            traversal(root);
            return root;
        }

        // 记录累加和
        int sum = 0;
        private void traversal(TreeNode root) {
            if (root == null) return;
            // 先遍历右子树
            traversal(root.right);
            sum += root.val;
            // 将BST转化成累加树
            root.val = sum;
            traversal(root.left);
        }
    }
}
