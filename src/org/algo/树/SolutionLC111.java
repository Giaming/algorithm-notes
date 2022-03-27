package org.algo.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC111 {
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
