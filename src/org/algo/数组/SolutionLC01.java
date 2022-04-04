package org.algo.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author giaming
 * @date 2022/2/27
 */
public class SolutionLC01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)){
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
