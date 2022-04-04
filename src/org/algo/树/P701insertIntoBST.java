package org.algo.树;

public class P701insertIntoBST {
    /**
     * 递归函数三部曲：
     * 1. 确定递归函数参数及返回值
     * 2. 确定终止条件
     * 3. 确定单层递归的逻辑
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                TreeNode node = new TreeNode(val);
                return node;
            }
            if (val < root.val) root.left = insertIntoBST(root.left, val);
            if (val > root.val) root.right = insertIntoBST(root.right, val);
            return root;
        }
    }

    // 迭代法遍历的过程中，需要记录以下当前遍历的节点的父节点，这样才能插入节点的操作
    class Solution2{
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                TreeNode node = new TreeNode(val);
                return node;
            }
            TreeNode cur = root;
            TreeNode parent = root;  // 记录上一个结点
            while (cur != null) {
                parent = cur;
                if (val < cur.val) cur = cur.left;
                else cur = cur.right;
            }
            TreeNode node = new TreeNode(val);
            if (val < parent.val) parent.left = node;  // 此时用parent节点进行赋值
            else parent.right = node;
            return root;
        }
    }
}
