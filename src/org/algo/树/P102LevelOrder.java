package org.algo.树;

import java.util.*;

/**
 * 二叉树的层序遍历
 * @author giaming
 * @date 2022/2/25
 */
public class P102LevelOrder {
    /**
     * BFS：迭代方式，借助队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * DFS：通过递归实现
     */
    public List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder2(TreeNode root) {
        checkFun(root, 0);
        return resList;
    }
    private void checkFun(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            // 当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            ArrayList<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        checkFun(node.left, deep);
        checkFun(node.right, deep);
    }
}
