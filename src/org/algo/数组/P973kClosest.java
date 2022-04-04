package org.algo.数组;

import java.util.PriorityQueue;

public class P973kClosest {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            int[][] res = new int[k][2];
            // corner case
            if(points == null || points.length == 0 || points[0].length == 0) return res;

            // pq: 1. create pq, size = k; rewrite sort method, 2. put points to pq
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
            for(int[] p : points) {
                pq.offer(p);
                if(pq.size() > k) {
                    pq.poll();
                }
            }

            // 放k个点到res中
            while(!pq.isEmpty()) {
                res[k-1] = pq.poll();
                k--;
            }
            return res;
        }
    }
}
