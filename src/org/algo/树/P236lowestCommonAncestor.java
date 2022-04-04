package org.algo.树;

public class P236lowestCommonAncestor {
    // 还是一个后续遍历的问题
    class Solution {
        /**
         * 情况 1，如果 p 和 q 都在以 root 为根的树中，函数返回的即使 p 和 q 的最近公共祖先节点。
         * 情况 2，那如果 p 和 q 都不在以 root 为根的树中怎么办呢？函数理所当然地返回 null 呗。
         * 情况 3，那如果 p 和 q 只有一个存在于 root 为根的树中呢？函数就会返回那个节点。
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // case 1
            if (left != null && right != null) return root;
            // case 2
            if (left == null && right == null) return null;
            // case 3
            return left == null ? right : left;
        }
    }
}
