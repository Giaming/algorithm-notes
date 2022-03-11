package org.algo.greedy;

/**
 * @author giaming
 */
public class SolutionLC45 {

    /**
     * 版本二
     * 移动下标只要遇到当前覆盖最远距离的下标，直接步数加一，不考虑是不是终点的问题
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int result = 0;
        // 当前覆盖的最远距离下标
        int end = 0;
        // 下一步覆盖的最远距离下标
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; i++) {
            temp = Math.max(temp, i + nums[i]);
            // 可达位置的改变次数就是跳跃次数
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }

    /**
     * 版本一
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 记录跳跃的次数
        int count = 0;
        // 当前覆盖最大区域
        int curDistance = 0;
        // 最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            // 在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            // 说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length-1) {
                count++;
                break;
            }
            // 走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
