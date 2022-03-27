package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC322 {
    /**
     * @param A : 表示存储硬币金额
     * @param M : 代表商品价值
     * @return  : 最少硬币数量
     */
    public static int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        f[0] = 0;

        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                // 第一个条件是防止数组越界，第二个条件时防止Max_Value+1越界
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - A[j]] + 1);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }
        return f[M];
    }
}

class SolutionLC322_2{
    /**
     * 给定amount，求用任意数量不同面值的零钱换到amount所用的最少数量
     * 完全背包最值问题：外循环coins，内循环amount正序，应用状态方程1
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                // 第一个条件是防止数组越界，第二个条件是防止MAX_VALUE+1越界
                if (coin <= i && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
