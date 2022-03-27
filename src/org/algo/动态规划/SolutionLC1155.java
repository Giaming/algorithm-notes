package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC1155 {
    /**
     * 分组0-1背包问题：dp[i][j]表示投掷骰子点数和为j的方法数；三层循环，最外层为背包d，然后先遍历target后遍历点数f
     * @param n  n个骰子
     * @param k  k个面
     * @param target  目标和
     * @return 多少种方法
     */
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k && j >= l; l++) {
                    dp[i][j] += dp[i - 1][j - l];
                    // 答案可能很大，你需要对 109 + 7 取模 。
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[n][target];
    }
}
