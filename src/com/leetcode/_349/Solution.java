package com.leetcode._349;

import java.util.HashSet;

/**
 * @author giaming
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0){
            return new int[0];
        }
        // 使用set可以实现去重
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                set2.add(i);
            }
        }
        int[] resArr = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
