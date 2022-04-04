package org.algo.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 在每个树行中寻找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @author giaming
 * @date 2022/2/25
 */
public class P515largestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                maxNum = maxNum < node.val ? node.val : maxNum;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(maxNum);
        }
        return result;
    }
}
