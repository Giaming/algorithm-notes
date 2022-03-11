package org.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC199 {

    ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node,int depth) {
        if (node == null) {
            return;
        }
        // 先访问当前节点，再递归访问右子树和左子树
        if (depth == result.size()) {
            // 如果当前节点所在深度还没有出现在res中，说明该深度下当前节点是第一个被访问的节点，
            // 因此将当前节点加入result中
            result.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }


    public List<Integer> rightSideView2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                if (i == size - 1) {
                    // 将当前层的最后一个节点放入结果列表
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}
