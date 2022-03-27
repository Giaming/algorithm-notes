package org.algo.hash._383赎金信;

import java.util.HashMap;

/**
 * @author: jml
 * @date: 2022/3/12
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 添加元素进入map
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            }else {
                map.put(magazine.charAt(i), 1);
            }
        }
        // 判断
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                // 如果存在，判断
                int count = map.get(ransomNote.charAt(i)) - 1;
                if (count < 0) {
                    // 说明magazine中的此类字符不足
                    return false;
                }else {
                    map.put(ransomNote.charAt(i), count);
                }
            } else {
                // 如果map中不存在，返回false
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] record = new int[26];
        char v;
        for (int i = 0; i < magazine.length(); i++) {
            v = magazine.charAt(i);
            record[v - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            v = ransomNote.charAt(i);
            record[v - 'a']--;
            if (record[v - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}
