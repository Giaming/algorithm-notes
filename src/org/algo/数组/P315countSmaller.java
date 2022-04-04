package org.algo.数组;

import java.util.*;

/**
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P315countSmaller {
    class Solution {
        private int lowbit(int x) {
            return x & (-x);
        }

        class FenwickTree{
            private int[] sums;

            public FenwickTree(int n) {
                sums = new int[n + 1];
            }

            public void update(int i, int delta) {
                while (i < sums.length) {
                    sums[i] += delta;
                    i += lowbit(i);
                }
            }

            public int querySum(int i) {
                int sum = 0;
                while (i > 0) {
                    sum += sums[i];
                    i -= lowbit(i);
                }
                return sum;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            Map<Integer, Integer> ranks = new HashMap<>();
            int rank = 0;
            for (int i = 0; i < sorted.length; i++) {
                if (i == 0 || sorted[i] != sorted[i - 1]) {
                    ranks.put(sorted[i], ++rank);
                }
            }
            FenwickTree tree = new FenwickTree(ranks.size());
            List<Integer> res = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int sum = tree.querySum(ranks.get(nums[i])-1);
                res.add(tree.querySum(ranks.get(nums[i])-1));
                tree.update(ranks.get(nums[i]), 1);
            }
            Collections.reverse(res);
            return res;
        }
    }
}
