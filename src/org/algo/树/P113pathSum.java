package org.algo.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P113pathSum {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return res;
        }
        private void dfs(TreeNode root, int target) {
            // 递归出口
            if (root == null) return;
            path.addLast(root.val);
            if(root.val == target && root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
            }
            // 回溯
            dfs(root.left, target - root.val);
            dfs(root.right, target - root.val);
            path.removeLast();
        }
    }
}
