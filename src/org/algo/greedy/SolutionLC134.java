package org.algo.greedy;

/**
 * @author giaming
 */
public class SolutionLC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 相当于图像中的坐标点和最低点
        int sum = 0, minSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                // 经过第i个站点后，使sum到达最低
                // 所以站点i+1就是最低点
                start = i + 1;
                minSum = sum;
            }
        }
        if (sum < 0) {
            // 总油量小于总的消耗，无解
            return -1;
        }
        // 环形数组特性
        return start == gas.length ? 0 : start;
    }
}

class Solution2{
    /**
     * 贪心算法：如果选择站点i作为起点恰好无法走到站点j，那么i和j中间的任意站点k都不能作为起点
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            // 总油量小于总的消耗，无解
            return -1;
        }
        // 记录油箱中的油量
        int tank = 0;
        // 记录起点
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // 无法从start走到i
                // 所以站点i+1应该是起点
                tank = 0;
                start = i + 1;
            }
        }
        return start == n ? 0 : start;
    }
}