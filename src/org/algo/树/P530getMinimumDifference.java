package org.algo.树;

import java.util.ArrayList;

public class P530getMinimumDifference {
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            int result = Integer.MAX_VALUE;
            ArrayList<Integer> res = new ArrayList<>();
            traversal(root, res);
            for (int i = 0; i < res.size()-1; i++) {
                result = Math.min(result, res.get(i+1) - res.get(i));
            }
            return result;
        }

        private void traversal(TreeNode root, ArrayList<Integer> res) {
            if (root == null) return;
            traversal(root.left, res);
            res.add(root.val);
            traversal(root.right, res);
        }
    }

    class Solution2{
        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            traversal(root);
            return result;
        }

        private void traversal(TreeNode cur) {
            if (cur == null) return;
            traversal(cur.left);
            if (pre != null) {
                result = Math.min(result, cur.val - pre.val);
            }
            pre = cur;  // 记录前一个节点
            traversal(cur.right);
        }
    }
}
