package org.algo.dp;

/**
 * @author giaming
 */
public class SolutionLC494 {
    /**
     * 目标和：给数组里的每个数字添加正负号得到target
     * 数组和sum，目标和s，正数和x，负数和y，则x+y=sum，x-y=s，那么x=(s+sum)/2=target
     * 1、最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i], dp[i-num]+nums);
     * 2、存在问题(bool)：dp[i]=dp[i]||dp[i-num];
     * 3、组合问题：dp[i]+=dp[i-num];
     */
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 这里sum的绝对值必须要大于或等于s的绝对值
        if ((sum + s) % 2 != 0 || Math.abs(sum) < Math.abs(s)) {
            return 0;
        }
        int target = (sum + s) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                // 组合问题
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
class SolutionLC494_2 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int size = (target + sum) / 2;
        size = size < 0 ? -size : size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = size; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[size];
    }
}
