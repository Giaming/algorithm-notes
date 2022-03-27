package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC70 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 这道题目还可以继续深化，就是一步一个台阶，两个台阶，三个台阶，直到 m个台阶，有多少种方法爬到n阶楼顶。
     * 其实是一个完全背包问题
     * @param m: 表示可以跳的台阶数量
     */
    public int climbStairs2(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i - j >= 0) {
                    dp[i] = dp[i] + dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
