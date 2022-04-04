package org.algo.树;

import java.util.ArrayDeque;
import java.util.Deque;

public class P513findBottomLeftValue {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) return 0;
            int res = 0;
            Deque<TreeNode> que = new ArrayDeque<>();
            que.offer(root);
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = que.poll();
                    // 记录第一个
                    if (i == 0) res = temp.val;
                    if (temp.left != null) que.offer(temp.left);
                    if (temp.right != null) que.offer(temp.right);
                }
            }
            return res;
        }
    }
    class Solution2{
        private int Deep = -1;
        private int value = 0;
        public int findBottomLeftValue(TreeNode root) {
            traversal(root, 0);
            return value;
        }

        private void traversal(TreeNode root, int deep) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                if (deep > Deep) {
                    value = root.val;
                    Deep = deep;
                }
            }
            if (root.left != null) traversal(root.left, deep+1);
            if (root.right != null) traversal(root.right, deep+1);
        }
    }
}
