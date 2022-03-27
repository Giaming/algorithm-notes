package org.algo.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 递归前序遍历
 * @author giaming
 * @date 2022/2/24
 */
public class SolutionLC144 {
    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }


    public List<Integer> preorderTraversal2(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur!=null) {
            while (cur!=null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                cur = temp.right;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal3(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
