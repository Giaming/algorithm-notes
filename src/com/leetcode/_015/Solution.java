package com.leetcode._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author giaming
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // 首先对数组进行排序
        for (int i = 0; i < nums.length; i++) {
           if (i > 0 && nums[i] == nums[i - 1]) {  // 去重
               continue;
           }
           int left = i + 1;
           int right = nums.length - 1;
           while (left < right) {
               int sum = nums[i] + nums[left] + nums[right];
               if (sum > target) {
                   right--;
               }else if (sum < target) {
                   left++;
               }else {
                   res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   while (right > left && nums[right] == nums[right - 1]) {
                       right--;
                   }
                   while (right > left && nums[left] == nums[left + 1]) {
                       left++;
                   }
                   right--;
                   left++;
               }
           }
        }
        return res;
    }
}
