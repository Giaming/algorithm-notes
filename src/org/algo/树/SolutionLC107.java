package org.algo.树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* 二叉树的层序遍历II
* @author giaming
* @date 2022/2/25
*/
public class SolutionLC107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
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
            result.addFirst(list);
        }
        return result;
    }
}
