package org.algo.回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P131partition {
    class Solution {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        public List<List<String>> partition(String s) {
            dfs(s, 0);
            return res;
        }

        private void dfs(String s, int startIdx) {
            // 退出条件,如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
            if (startIdx >= s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIdx; i < s.length(); i++) {
                // 如果是回文串，则记录
                if (isPalindrome(s, startIdx, i)) {
                    String str = s.substring(startIdx, i + 1);
                    path.addLast(str);
                }else {
                    continue;
                }
                dfs(s, i + 1);
                path.removeLast();
            }
        }

        // 判断回文串
        private boolean isPalindrome(String str, int i, int j) {
            while (i < j) {
                if (str.charAt(i++) != str.charAt(j--)){
                    return false;
                }
            }
            return true;
        }
    }
}
