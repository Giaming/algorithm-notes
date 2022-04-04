package org.algo.数组;

import sun.text.normalizer.CharacterIteratorWrapper;

import java.util.*;

public class P373kSmallestPairs {
    /**
     * use min_heap to keep track on minimum pair sum, and only need to maintain K possible candidates in the data structure
     */
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // create min heap, sorted by sum
            PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] + o[1])));
            int len1 = nums1.length, len2 = nums2.length;
            // no pairs to form, just return an empty res list
            if (len1 == 0 || len2 == 0 || k == 0) return null;
            List<List<Integer>> res = new ArrayList<>();
            // offer initial pairs {num1, num2, index_of_num2}
            for (int i = 0; i < Math.min(len1, k); i++) {
                que.offer(new int[]{nums1[i], nums2[0], 0});
            }
            // get 1st k element into result, each time, offer potential better pairs into que
            // if there r not enough pairs, just return all pairs
            for (int i = 0; i < Math.min(len1*len2, k); i++) {
                // get the best pair and put into result
                int[] cur = que.poll();
                List<Integer> pair = new ArrayList<>();
                pair.add(cur[0]);
                pair.add(cur[1]);
                res.add(pair);
                // next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
                // for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
                // for B, it might be a better choice, so we offer it into queue
                if (cur[2] < len2 - 1) {  // still
                    int idx = cur[2] + 1;
                    que.offer(new int[]{cur[0], nums2[idx], idx});
                }
            }
            return res;
        }
    }

    class Solution2{
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // return res
            List<List<Integer>> res = new ArrayList<>();
            // priority queue : 最小堆
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
            // corner case
            if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

            // offer nums1 into pq, nums2 index=0的element
            for (int i = 0; i < nums1.length && i < k; i++) {
                pq.offer(new int[]{nums1[i], nums2[0], 0}); // 最后一个0代表的是nums2中的元素的下标
            }
            // poll ：pq最小和，offer新的pairs
            while (!pq.isEmpty() && k-- > 0) {
                int[] cur = pq.poll();
                // 放到结果中
                res.add(Arrays.asList(cur[0], cur[1]));
                // offer新pair，拿出nums2里面的下一个index对应的element
                if (cur[2] < nums2.length - 1) {
                    pq.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
                }
            }
            return res;
        }
    }
}
