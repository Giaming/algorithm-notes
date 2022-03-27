package org.algo.单调栈;

import java.util.*;

public class P739DailyTemperatures {
//    public int[] dailyTemperatures(int[] temperatures) {
//        // 递增栈
//        Deque<Integer> stack = new ArrayDeque<>();
//        int[] res = new int[temperatures.length];
//        Arrays.fill(res, 0);
//        stack.push(0);
//        for (int i = 1; i < temperatures.length; i++) {
//            if (temperatures[i] < temperatures[stack.peek()]) {   // 情况1
//                stack.push(i);
//            } else if (temperatures[i] == temperatures[stack.peek()]) {  // 情况2
//                stack.push(i);
//            } else {  // 情况3
//                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                    res[stack.peek()] = i - stack.peek();
//                    stack.pop();
//                }
//                stack.push(i);
//            }
//        }
//        return res;
//    }

    /**
     * 简化版
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
