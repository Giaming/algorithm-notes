package org.algo.hash._136;

import java.util.HashMap;

public class Solution {
    /**
     * 使用hashmap实现
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            count = count == null ? 1 : count++;
            map.put(num, count);
        }
        // 从哈希表中取出进行判断
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                // 说明是只出现一次的数据
                return key;
            }
        }
        return -1;
    }


    /**
     * 使用位运算实现，a = a ^ b ^ b
     * b ^ b = 0
     * a ^ 0 = a
     * 若成对，则异或的结果就是0
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
