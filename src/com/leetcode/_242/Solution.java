package com.leetcode._242;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * @author giaming
 */
class Solution {

    /**
     * 利用字符串排序
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        Arrays.sort(arr_s);
        Arrays.sort(arr_t);
        return Arrays.equals(arr_s, arr_t);
    }
}

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(alpha).noneMatch(x -> x == 0);
    }
}
