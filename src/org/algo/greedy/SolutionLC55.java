package org.algo.greedy;

/**
 * 跳跃游戏
 * @author giaming
 */
public class SolutionLC55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 覆盖范围，初始覆盖范围是0
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
