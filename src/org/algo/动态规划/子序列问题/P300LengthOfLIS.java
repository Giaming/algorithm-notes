package org.algo.动态规划.子序列问题;

import java.util.Arrays;

/**
 * @author: jml
 * @date: 2022/3/22
 */
public class P300LengthOfLIS {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // step1:dp[i]定义
        int[] dp = new int[nums.length];
        // step3:dp[i]初始化
        Arrays.fill(dp, 1);
        // 遍历
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 二分法

    /**
     * 相当于维护一个结果数组，如果当前元素比结果数组的值都大的的话，就追加在结果数组后面（相当于递增序列长度加了1）；否则的话用当前元素覆盖掉第一个比它大的元素（这样做的话后续递增序列才有可能更长，即使并没有更长，这个覆盖操作也并没有副作用哈，当然这个覆盖操作可能会让最终的结果数组值并不是最终的递增序列值，这无所谓）
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0 ? -idx - 1 : idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
