package org.algo.树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC101 {
    /**
     * 递归实现版本
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left == null && right == null) {  // 这个条件必须判断，否则出现空指针异常
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        return outSide && inSide;
    }

    /**
     * 基于双端队列：相当于使用两个栈
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }else if (leftNode == null || rightNode == null) {
                return false;
            }else if (leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }


}
