package org.algo.数组;

public class P668findKthNumber {
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int l = 1;
            int r = m * n + 1;
            while(l < r) {
                int x = l + (r - l) / 2;
                if(LEX(m, n, x) >= k)
                    r = x;
                else
                    l = x + 1;
            }
            return l;
        }

        // returns # of elements in the m * n table that are <= x
        private int LEX(int m, int n, int x) {
            int count = 0;
            for(int i = 1; i <= m; ++i) {
                count += Math.min(n, x / i);
            }
            return count;
        }
    }
}
