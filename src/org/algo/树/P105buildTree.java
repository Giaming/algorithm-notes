package org.algo.树;

import java.util.HashMap;
import java.util.Map;

public class P105buildTree {
    class Solution {
        Map<Integer, Integer> indexMap = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return createTree(preorder, 0, preorder.length-1, 0, inorder.length-1);
        }

        private TreeNode createTree(int[] preorder, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
            // 递归出口
            if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) return null;
            // 根节点值
            int val = preorder[preStartIndex];
            int inIndex = indexMap.get(val);
            int leftNumber = inIndex - inStartIndex;
            // 创建根节点
            TreeNode root = new TreeNode(val);
            root.left = createTree(preorder, preStartIndex+1, preStartIndex+leftNumber, inStartIndex, inIndex-1);
            root.right = createTree(preorder, preStartIndex+leftNumber+1, preEndIndex, inIndex+1, inEndIndex);
            return root;
        }
    }
}
