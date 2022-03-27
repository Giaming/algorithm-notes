package org.algo.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.Consumer;

public class P503NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i%len] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        P503NextGreaterElements solution = new P503NextGreaterElements();
        int[] res = solution.nextGreaterElements(arr);
        Arrays.stream(res).forEach(s -> System.out.print(s+" "));
    }
}
