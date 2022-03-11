package org.algo.sliding_window;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/javade-jie-fa-ji-bai-liao-9985de-yong-hu-by-sdwwld/
 * @author giaming
 */
public class SolutionLC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int start = 0, end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                subLength = end - start + 1;
                result = result < subLength ? result : subLength;
                sum -= nums[start++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
