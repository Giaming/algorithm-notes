package org.algo.dp;

/**
 * @author giaming
 */
public class SolutionLC55 {
    /**
     * 动态规划实现
     */
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j =0 ; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}

class Solution2 {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
