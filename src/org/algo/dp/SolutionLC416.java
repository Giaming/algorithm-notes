package org.algo.dp;

import jdk.jfr.internal.tool.PrettyWriter;

/**
 * @author giaming
 */
public class SolutionLC416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                // 物品i的重量是nums[i]，其价值也是nums[i]
//                dp[j] = Math.max(dp[j], dp[j - nums[i]]+nums[i]);
//            }
//        }
        for (int num : nums) {
            for (int i = target; i >= num ; i--) {
                dp[i] = Math.max(dp[i], dp[i - num]+num);
            }
        }
        // 集合中的元素正好凑成总和target
        if (dp[target] == target) {
            return true;
        }
        return false;
    }
}
class SolutionLC146_2{

    // 二维数组方式实现
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        // dp[i][j]代表可装物品为0-i,背包容量为j的情况下，背包内容量的最大价值
        int[][] dp = new int[nums.length][target + 1];
        // 初始化
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }
        // 遍历物品，遍历背包
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                // 背包容量可以容纳nums[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target] == target;
    }
}