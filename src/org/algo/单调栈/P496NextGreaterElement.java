package org.algo.单调栈;

import java.util.*;

public class P496NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (map.containsKey(nums2[stack.peek()])) {
                        // 根据map找到nums2[st.top()] 在 nums1中的下标
                        int index = map.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while (!d.isEmpty() && d.peek() < i) {
                map.put(d.peek(), i);
                d.pop();
            }
            d.push(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        P496NextGreaterElement solution = new P496NextGreaterElement();
        int[] res = solution.nextGreaterElement(nums1, nums2);
        Arrays.stream(res)
                .forEach(System.out::println);
    }
}
