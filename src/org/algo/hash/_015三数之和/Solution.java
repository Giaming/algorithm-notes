package org.algo.hash._015三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jml
 * @date: 2022/3/12
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 因为返回结果中的三元组不允许重复，所以先要进行排序，然后再使用双指针
        Arrays.sort(nums);
        int left, right, sum;
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    // 值大于target的情况下右指针左移
                    right--;
                } else if (sum < target) {
                    // 值小于target的情况下左指针右移
                    left++;
                } else {
                    // 相等
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 移动指针，去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
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
