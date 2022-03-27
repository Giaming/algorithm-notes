package org.algo.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/submissions/
 * @author giaming
 * @date 2022/2/25
 */
public class SolutionLC116 {
    /**
     * 基于层次遍历实现
     * @param root
     * @return
     */
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

    /**
     * 基于next指针
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
     * @param root
     * @return
     */
    public NewNode connect2(NewNode root) {
        if (root == null) {
            return null;
        }
        NewNode leftmost = root;
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新next指针
            NewNode head = leftmost;
            while (head != null) {
                // Connection 1
                head.left.next = head.right;
                // Connection 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }

}
