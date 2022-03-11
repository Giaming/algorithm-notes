package org.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/submissions/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC429 {
    public List<List<Integer>> levelOrder(Node root){
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> children = node.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
