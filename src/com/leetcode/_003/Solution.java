package com.leetcode._003;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author giaming
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
       int n = s.length();
       if (n <= 1) {
           return n;
       }
       int maxLen = 1;

       int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n) {
            Integer rightCharIndex = map.getOrDefault(s.charAt(right), 0);
            left = Math.max(left, rightCharIndex);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String str = "abcdabcbb";
        System.out.println(str.indexOf(str.charAt(5), 0));
    }
}
