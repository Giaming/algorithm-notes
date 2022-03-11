package com.leetcode._001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author giaming
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{i, map.get(sub)};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1, -1};
    }
}
