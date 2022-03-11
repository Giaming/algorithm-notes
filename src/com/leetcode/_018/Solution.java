package com.leetcode._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author giaming
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 0; j < nums.length - 3; j++) {
            if (j == 0 || (j > 0 && nums[j] != nums[j - 1])) {
                for (int i = j + 1; i < nums.length - 2; i++) {
                    if (i == j + 1 || nums[i] != nums[i - 1]) {
                        int low = i + 1, high = nums.length - 1, sum = target - nums[j] - nums[i];
                        while (low < high) {
                            if (nums[low] + nums[high] == sum) {
                                res.add(Arrays.asList(nums[j], nums[i], nums[low], nums[high]));

                                while (low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }

                                while (low < high && nums[high] == nums[high - 1]){
                                    high--;
                                }
                                low++;
                                high--;
                            }else if (nums[low] + nums[high] < sum) {
                                low++;
                            }else {
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
