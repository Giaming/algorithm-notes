package org.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的平均值：
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/submissions/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double levelSum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                levelSum += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(levelSum/size);
        }
        return result;
    }
}
