package org.algo.greedy;

/**
 * 最大子数组和
 * @author giaming
 */
public class SolutionLC53 {
    /**
     * 贪心方法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }

    /**
     * DP方法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int result =  Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
