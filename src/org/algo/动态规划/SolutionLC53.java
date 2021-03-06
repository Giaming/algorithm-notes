package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
