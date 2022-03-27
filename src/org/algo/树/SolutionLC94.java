package org.algo.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * @author giaming
 * @date 2022/2/24
 */
public class SolutionLC94 {
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null) {
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right!=null) {
                cur = temp.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
