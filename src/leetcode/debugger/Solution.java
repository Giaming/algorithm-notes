package leetcode.debugger;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid =  (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid-1;
            } else if (nums[mid] < target){
                lo = mid + 1;
            }
            System.out.println(lo);
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr  = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(arr, 5));
    }
}
