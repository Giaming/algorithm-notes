package org.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC117 {
    public NewNode connect(NewNode root) {
        if (root == null) {
            return null;
        }
        Queue<NewNode> queue = new LinkedList<>();
        queue.offer(root);
        // 外层的while循环迭代的是层数
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NewNode node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
