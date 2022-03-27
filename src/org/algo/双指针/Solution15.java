package org.algo.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author giaming
 */
public class Solution15 {
    public List<List<Integer>> twoSumTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0, high = nums.length-1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target) {
                while (low < high && nums[low] == left) {
                    low++;
                }
            }else if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            }else {
               result.add(Arrays.asList(left, right));
               while (low < high && nums[low] == left) {
                   low++;
               }
               while (low < high && nums[low] == right) {
                   high--;
               }
            }
        }
        return result;
    }
}
