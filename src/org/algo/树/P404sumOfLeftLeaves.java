package org.algo.树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 那么判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子。
 *
 * 如果该节点的左节点不为空，该节点的左节点的左节点为空，该节点的左节点的右节点为空，则找到了一个左叶子
 */
public class P404sumOfLeftLeaves {
    // 递归方法
    private class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;
            int leafVal = 0;
            if(root.left != null && root.left.left == null && root.left.right == null) {
                leafVal = root.left.val;
            }
            return leafVal + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    // 迭代法实现
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp.left != null && temp.left.left ==  null && temp.left.right == null) {
                res += temp.left.val;
            }
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        return res;
    }
}
