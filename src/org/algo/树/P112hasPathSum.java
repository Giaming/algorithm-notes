package org.algo.树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1.确定递归函数的参数和返回类型
 * 2.确定终止条件
 * 3.确定单层递归的逻辑
 * 路径总和的四种解法：DFS、回溯、BFS、栈:https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-de-si-chong-jie-fa-dfs-hui-su-bfs-/
 */
public class P112hasPathSum {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return traversal(root, targetSum - root.val);
        }

        private boolean traversal(TreeNode root, int targetSum) {
            if (root.left == null && root.right == null && targetSum == 0) return true;
            if (root.left == null && root.right == null) return false;

            if (root.left != null) {
                targetSum -= root.left.val;
                if (traversal(root.left, targetSum) == true) return true;
                targetSum += root.left.val;
            }
            if (root.right != null) {
                targetSum -= root.right.val;
                if (traversal(root.right, targetSum) == true) return true;
                targetSum += root.right.val;
            }
            return false;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum == 0) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    // 迭代方法
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack1.push(root); stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();
                // 如果该节点是叶子节点，同时该节点的路径数值等于sum，那么返回true
                if (node.left == null && root.right == null && sum == targetSum) return true;
                // 右节点
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(node.left.val+sum);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(node.right.val+sum);
                }
            }
        }
        return false;
    }
}
