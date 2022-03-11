package org.algo.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author giaming
 */
public class SolutionLC1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 从前向后遍历，遇到负数将其变为正数，同时k--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果k还大于0，那么反复转变数值最小的元素，将k用完
        if (k % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1) {
            return k % 2 == 0 ? nums[0] : -nums[0];
        }
        Arrays.sort(nums);
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[idx] < 0) {
                nums[idx] = -nums[idx];
                if (nums[idx] >= Math.abs(nums[idx + 1])) {
                    idx++;
                }
                continue;  // 跳出本次循环
            }
            nums[idx] = -nums[idx];
        }
        return Arrays.stream(nums).sum();
    }
}