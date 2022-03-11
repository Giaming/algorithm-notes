package org.algo.dp;

/**
 * @author giaming
 */
public class SolutionLC518 {
    /**
     * 完全背包不考虑顺序的组合问题：外循环coins，内循环target正序，dp[i]+=dp[i-num];
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i){
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
