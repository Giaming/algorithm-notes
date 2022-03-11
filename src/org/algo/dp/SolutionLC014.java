package org.algo.dp;

/**
 * @author giaming
 */
public class SolutionLC014 {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }else if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j =1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

}
