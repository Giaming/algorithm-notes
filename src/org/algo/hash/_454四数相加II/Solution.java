package org.algo.hash._454四数相加II;

import java.util.HashMap;

/**
 * @author: jml
 * @date: 2022/3/12
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // key表示和的数值，value表示出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        int res = 0;
        // 统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    // 如果已经存在，则次数加1
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        // 统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int k : nums3) {
            for (int l : nums4) {
                temp = k + l;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
