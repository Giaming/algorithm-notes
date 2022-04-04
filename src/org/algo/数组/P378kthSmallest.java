package org.algo.数组;

import java.util.PriorityQueue;

public class P378kthSmallest {
    // 寻找二维矩阵的第k小的数

    /**
     *Solution 1 : Heap
     * Here is the step of my solution:
     *
     * 1. Build a minHeap of elements from the first row.
     * 2. Do the following operations k-1 times :
     *  Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of that element(so we can create a tuple class here), replace that root with the next element from the same column.
     * After you finish this problem, thinks more :
     * For this question, you can also build a min Heap from the first column, and do the similar operations as above.(Replace the root with the next element from the same row)
     * What is more, this problem is exact the same with Leetcode373 Find K Pairs with Smallest Sums, I use the same code which beats 96.42%, after you solve this problem, you can check with this link:
     * https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42
     */
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
            for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
            for(int i = 0; i < k - 1; i++) { // 小根堆，去掉 k - 1 个堆顶元素，此时堆顶元素就是第 k 的数
                Tuple t = pq.poll();
                if(t.x == m - 1) continue;
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
            return pq.poll().val;
        }

        class Tuple implements Comparable<Tuple> {
            int x, y, val;
            public Tuple(int x, int y, int val) {
                this.x = x; this.y = y; this.val = val;
            }

            @Override
            public int compareTo(Tuple that) {
                return this.val - that.val;
            }
        }
    }

    // https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/ci-ti-er-fen-cha-zhao-guo-cheng-de-dong-tu-yan-shi/
    // 使用二分查找
    class Solution2{
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int cnt = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                        cnt++;
                    }
                }
                if (cnt < k) lo = mid + 1;
                else hi = mid - 1;
            }
            return lo;
        }
    }
}
