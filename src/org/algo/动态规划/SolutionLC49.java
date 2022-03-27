package org.algo.动态规划;

/**
 * @author giaming
 */
public class SolutionLC49 {
    /**
     * 问题转化为：把一堆石头分成两堆，求两堆石头重量差最小值
     * 进一步分析：要让差值小，两堆石头的重量都要接近sum/2，我们假设两堆分别为A，B，A<sum/2，B>sum/2，若A更接近sum/2，B也相应更接近sum/2
     * 进一步转化：将一堆stone放进最大容量为sum/2的背包，求放进去的石头的最大重量MaxWeight，最终答案即为sum-2*maxweight;
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
//        for (int i = 0; i < stones.length; i++) {
//            // 采用倒序
//            for (int j = target; j >= stones[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
//            }
//        }
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone]+stone);
            }
        }
        return sum - 2 * dp[target];
    }
}
