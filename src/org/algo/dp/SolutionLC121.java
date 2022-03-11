package org.algo.dp;

/**
 * @author giaming
 */
public class SolutionLC121 {
    public int maxProfit(int[] prices) {
        // 贪心算法
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }

    public int maxProfitV1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[dp.length - 1][1];
    }
}
