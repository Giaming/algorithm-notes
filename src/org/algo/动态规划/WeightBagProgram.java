package org.algo.动态规划;

/**
 * @author giaming
 */
public class WeightBagProgram {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagsize = 4;
//        testweightbagproble(weight, value, bagsize);
        testWeightBagProblem(weight, value, bagsize);
    }

    public static void testweightbagproble(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length, value0 = 0;
        // 定义dp数组，dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        // 初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        // 遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        // 定义dp数组，dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        // 遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        // 打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");
        }
    }
}
