package org.algo.树;

import java.util.ArrayDeque;
import java.util.Deque;

public class P230kthSmallest {
    class Solution {
        int res = -1;
        int count = 0;
        public int kthSmallest(TreeNode root, int k) {
            traversal(root, k);
            return res;
        }

        private void traversal(TreeNode root, int k) {
            if (root == null) return;
            traversal(root.left, k);
            if (++count == k) {
                res = root.val;
                return;
            }
            traversal(root.right, k);
        }
    }

    class Solution2{
        public int kthSmallest(TreeNode root, int k) {
            int count = 0;
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while(!stack.isEmpty() || cur != null) {
                if(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (++count == k) return cur.val;
                    cur = cur.right;
                }
            }
            return -1;
        }
    }
}
