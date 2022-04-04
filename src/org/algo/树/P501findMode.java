package org.algo.树;

import java.util.ArrayList;
import java.util.List;

public class P501findMode {
    class Solution {
        int preVal = 0, curTimes = 0, maxTimes = 0;
        List<Integer> list = new ArrayList<>();
        public int[] findMode(TreeNode root) {
            traversal(root);
            int size = list.size();
            int[] ans = new int[size];
            for (int i = 0; i < size; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        // 二叉树的中序遍历
        private void traversal(TreeNode root) {
            if (root == null) return;
            traversal(root.left);
            // 判断当前值域上一个值的关系，更新curTimes和preVal
            if (preVal == root.val) {
                curTimes++;
            }else {
                preVal = root.val;
                curTimes = 1;
            }
            // 判断当前数量与最大数量的关系，更新list和maxTimes
            if (curTimes == maxTimes) {
                list.add(root.val);
            } else if (curTimes > maxTimes) {
                list.clear();  // 这里是关键
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }
}
