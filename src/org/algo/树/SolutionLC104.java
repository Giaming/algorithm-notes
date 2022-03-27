package org.algo.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC104 {
    /**
     * 基于递归实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return left + 1;
        }else {
            return right + 1;
        }
    }

    /**
     * 基于层序遍历实现
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
