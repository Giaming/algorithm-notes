package com.leetcode._016;

import java.util.Arrays;

/**
 * @author giaming
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sub = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (Math.abs(nums[i] + nums[low] + nums[high] - target) < sub){
                    res = nums[i] + nums[low] + nums[high];
                    sub = Math.abs(target - res);
                }
                if ((nums[i] + nums[low] + nums[high]) > target) {
                    high--;
                }else {
                    low++;
                }
            }
        }
        return res;
    }
}
