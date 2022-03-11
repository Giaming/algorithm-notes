package org.algo.dp;

/**
 * 1. 确定dp数组以及下标的含义
 * 2. 确定递推公式：dp[i] = max(dp[i], max((i-j)*j,dp[i-j]*j))
 * 3. dp的初始化
 * 4. 确定遍历顺序
 * @author giaming
 */
public class SolutionLC343 {
    public int integerBreak(int n) {
        // dp[i]为正整数i拆分结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // j * (i - j)代表把i拆分为j和i-j两个数相乘
                // j * dp[i-j]代表把i拆分成j和继续把(i-j)这个整数拆分，去(i-j)拆分结果中的最大乘积与j相乘
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int result = 1;
        while (n > 4) {
           result *= 3;
           n -= 3;
        }
        result *= n;
        return result;
    }
}
