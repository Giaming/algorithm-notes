package org.algo.greedy;

/**
 * @author giaming
 */
public class SolutionLC376 {
    /**
     * 使用贪心算法
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 当前差值
        int curDiff = 0;
        // 上一个差值
        int preDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // 得到当前差值
            curDiff = nums[i+1] - nums[i];
            // 如果当前差值和上一个差值一正一负，等于0的情况表示初始化时的preDiff
            if ((curDiff > 0 && preDiff <= 0) ||(curDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/wiggle-subsequence/solution/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i作为波谷的最大长度
        int dp[][] = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 0; i < nums.length; i++) {
            // i 自己可以称为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    // i是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
                }
                if (nums[j] < nums[i]){
                    // i是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
                }
            }
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
