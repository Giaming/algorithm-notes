package org.algo.tree;

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.ret;
import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * 反转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC226 {
    /**
     * 前序和后序遍历都可以
     * 中序遍历不行，因为先左孩子交换孩子，再根交换孩子(做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 基于前序遍历的非递归版本
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root){
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * BFS
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
