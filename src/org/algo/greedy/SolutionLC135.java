package org.algo.greedy;

import java.util.Arrays;

/**
 * @author giaming
 */
public class SolutionLC135 {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        // 从前往后使用贪心策略
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyVec[i] = candyVec[i - 1] + 1;
            } else {
                candyVec[i] = 1;
            }
        }
        // 从后往前使用贪心策略
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i],candyVec[i + 1] + 1);
            }
        }
        return Arrays.stream(candyVec).sum();
    }
}
