package org.algo.树;

import java.util.*;

public class P257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;  // 递归出口
        }
        if (root.left != null) {
            traversal(root.left, path, res);
            // 回溯
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            traversal(root.right, path, res);
            path.remove(path.size()-1);
        }
    }



    // 迭代法
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Object> stack = new ArrayDeque<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时入栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path+"->"+node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path+"->"+node.left.val);
            }
        }
        return result;
    }
}
