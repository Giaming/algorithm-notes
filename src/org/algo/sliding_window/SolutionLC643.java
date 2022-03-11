package org.algo.sliding_window;

/**
 * @author giaming
 */
public class SolutionLC643 {
    /**
     * k固定，使用滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        SolutionLC643 solution = new SolutionLC643();
        System.out.println(solution.findMaxAverage(nums, 4));
    }
}
