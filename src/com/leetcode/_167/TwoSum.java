package com.leetcode._167;

import java.util.HashMap;

/**
 * @author giaming
 */
public class TwoSum {

    // 使用HashMap解决
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{-1,-1};
        }
        int[] res = new int[]{-1,-1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i+1;
            }
            map.put(numbers[i], i+1);
        }
        return res;
    }
}

class Solution2 {
    /**
     * 双指针法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
