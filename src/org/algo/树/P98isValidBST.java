package org.algo.树;

import java.util.Deque;
import java.util.LinkedList;

public class P98isValidBST {

    class Solution3{
        // 如果该二叉树的左子树不为空，则左子树上的所有节点的值均小于它的根节点的值，若它的右子树不为空，则右子树上所有节点的值均大于它的根节点的值
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }
    }


    // 中序遍历
    // 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
    class Solution{
        TreeNode max;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            // 左
            boolean left = isValidBST(root.left);
            if (!left) return false;
            // 中
            if (max != null && root.val <= max.val) return false;
            max = root;
            // 右
            boolean right = isValidBST(root.right);
            return right;
        }
    }

    // 迭代法, 中序遍历
    class Solution2{
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                if (pre != null && pop.val <= pre.val) {
                    return false;
                }
                pre = pop;
                root = pop.right;
            }
            return true;
        }
    }
}
