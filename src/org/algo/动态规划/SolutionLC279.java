package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC279 {
    /**
     * 完全背包的最值问题：完全平方数最小为1，最大为sqrt(n)，故题目转换为在nums=[1,2,...,sqrt(n)]中任意数平方和为target=n
     * 外循环nums，内循环target正序
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int num = 1; num <= Math.sqrt(n); num++) {
            for (int i = 0; i <= n; i++) {
                if (i >= num*num) {
                    // 最值问题
                    dp[i] = Math.min(dp[i], dp[i-num*num]+1);
                }
            }
        }
        return dp[n];
    }
}
