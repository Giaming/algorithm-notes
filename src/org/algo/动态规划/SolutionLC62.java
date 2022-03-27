package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC62 {
    /**
     * 1. 确定dp数组下标含义 dp[i][j]到每一个坐标可能的路径种类
     * 2. 递推公式 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. 初始化 dp[i][0] = 1, dp[0][j] = 1
     * 4. 遍历顺序
     * 5. 推导结果
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
