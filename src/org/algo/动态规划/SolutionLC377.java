package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC377 {
    /**
     * 考虑顺序的组合问题：外循环target，内循环nums
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
