package org.algo.树;

import java.util.*;

/**
 * 二叉树后序遍历
 * @author giaming
 * @date 2022/2/24
 */
public class SolutionLC145 {
    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;  // 递归出口
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;

        while (!stack.isEmpty() || root!=null) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev){
                result.add(root.val);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
