package org.algo.树;

import java.util.HashMap;
import java.util.Map;

public class P106buildTree {
    class Solution1{
        Map<Integer, Integer> indexMap = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 用hashmap来存储中序遍历的索引
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return createTree(postorder, 0, postorder.length-1, 0, inorder.length-1);
        }

        private TreeNode createTree(int[] postorder, int postStartIndex, int postEndIndex, int inStartIndex, int inEndIndex) {
            // 递归出口
            if (postStartIndex > postEndIndex || inStartIndex > inEndIndex) return null;
            // 后序遍历的最后一个位置是根节点的值
            int val = postorder[postEndIndex];
            // 获取中序遍历中的根节点的索引
            int inIndex = indexMap.get(val);
            // 中序遍历中根节点索引左边的节点个数，即左子树上的节点个数
            int leftNumber = inIndex - inStartIndex;
            TreeNode root = new TreeNode(val);
            // 递归
            root.left = createTree(postorder, postStartIndex, postStartIndex+leftNumber-1, inStartIndex, inIndex-1);
            root.right = createTree(postorder, postStartIndex+leftNumber, postEndIndex-1, inIndex+1, inEndIndex);
            return root;
        }
    }
}
