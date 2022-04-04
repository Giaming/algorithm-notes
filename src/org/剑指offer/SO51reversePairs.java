package org.剑指offer;

import java.util.*;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SO51reversePairs {
    // 解决方案1：分治思想，借助归并排序统计逆序对
    class Solution {
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return 0;
            }

            int[] copy = new int[len];
            for (int i = 0; i < len; i++) {
                copy[i] = nums[i];
            }

            int[] temp = new int[len];
            return reversePairs(copy, 0, len - 1, temp);
        }

        /**
         * nums[left..right] 计算逆序对个数并且排序
         */
        private int reversePairs(int[] nums, int left, int right, int[] temp) {
            if (left == right) {
                return 0;
            }

            int mid = left + (right - left) / 2;
            int leftPairs = reversePairs(nums, left, mid, temp);
            int rightPairs = reversePairs(nums, mid + 1, right, temp);

            if (nums[mid] <= nums[mid + 1]) {
                return leftPairs + rightPairs;
            }

            int crossPairs = mergeAndCount(nums, left, mid, right, temp);
            return leftPairs + rightPairs + crossPairs;
        }

        /**
         * nums[left..mid] 有序，nums[mid + 1..right] 有序
         */
        private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
            for (int i = left; i <= right; i++) {
                temp[i] = nums[i];
            }

            int i = left;
            int j = mid + 1;

            int count = 0;
            for (int k = left; k <= right; k++) {

                if (i == mid + 1) {
                    nums[k] = temp[j];
                    j++;
                } else if (j == right + 1) {
                    nums[k] = temp[i];
                    i++;

                    count += (right - mid);
                } else if (temp[i] <= temp[j]) {
                    nums[k] = temp[i];
                    i++;

                    count += (j - mid - 1);
                } else {
                    nums[k] = temp[j];
                    j++;
                }
            }
            return count;
        }
    }


    // 树状数组
    class Solution2{
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return 0;
            }
            // 离散化：使得数字更紧凑，节约树状数组的空间
            // 1. 使用二分搜索树是为了去掉重复的元素 
            Set<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                treeSet.add(nums[i]);
            }
            
            // 2. 把排名存在哈希表里方便查询
            Map<Integer, Integer> rankMap = new HashMap<>();
            int rankIndex = 1;
            for (Integer num : treeSet) {
                rankMap.put(num, rankIndex);
                rankIndex++;
            }
            
            int count = 0;
            // 在树状数组内部完成前缀和的计算
            // 规则是：从后向前，先给对应的排名+1，再查询前缀和
            FenwickTree fenwickTree = new FenwickTree(rankMap.size());

            for (int i = len-1; i >= 0; i--) {
                int rank = rankMap.get(nums[i]);
                fenwickTree.update(rank, 1);
                count += fenwickTree.query(rank - 1);
            }
            return count;
        }
        
        private class FenwickTree {
            private int[] tree;
            private int len;

            public FenwickTree(int n) {
                this.len = n;
                tree = new int[n + 1];
            }

            // 单点更新：将index这个位置+delta
            public void update(int i, int delta) {
                // 从下到上，最多到size，可以等于size
                while (i <= this.len) {
                    tree[i] += delta;
                    i += lowbit(i);
                }
            }

            private int lowbit(int x) {
                return x & (-x);
            }

            // 区间查询：查询小于等于tree[index]的元素个数
            // 查询的语义是[前缀和]
            public int query(int i) {
                // 从右到左查询
                int sum = 0;
                while (i > 0) {
                    sum += tree[i];
                    i -= lowbit(i);
                }
                return sum;
            }
        }
    }


    // ⭐️⭐️⭐️
    class Solution3{
        int count = 0;
        int[] aux;  // 辅助数组
        public int reversePairs(int[] nums) {
            aux = new int[nums.length];
            sort(nums, 0, nums.length-1);
            return count;
        }

        private void sort(int[] nums, int lo, int hi) {
            if (lo >= hi) return;

            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid+1, hi);

            merge(nums, lo, mid, hi);
        }

        private void merge(int[] nums, int lo, int mid, int hi) {
            int i = lo, j = mid+1;
            for(int k = lo; k <= hi; k++) {
                // 用辅助数组先保存原先数组的值
                aux[k] = nums[k];
            }

            int index = lo;
            while (i <= mid || j <= hi) {
                if (i > mid) {
                    // 说明前半部分遍历完了,直接把后面的部分接上即可
                    nums[index++] = aux[j++];
                } else if (j > hi) {
                    // 说明后面的遍历完了，直接把前面的部分接上即可
                    nums[index++] = aux[i++];
                } else if (aux[i] <= aux[j]) {
                    nums[index++] = aux[i++];
                } else {
                    // 处理后半部分，只有后半部分小的时候才有可能出现逆序对的情况
                    nums[index++] = aux[j++];
                    // 前面的的逆序数个数刚好应该是mid-i+1
                    count += mid - i + 1;
                }
            }
        }
    }

}
