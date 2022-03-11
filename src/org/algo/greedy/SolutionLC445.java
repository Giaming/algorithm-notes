package org.algo.greedy;


import java.util.Arrays;

/**
 * 贪心算法，分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 * @author giaming
 */
public class SolutionLC445 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int indexG = 0;
        int indexS = 0;
        int satisfied = 0;

        while (indexG < g.length && indexS < s.length) {
            if (g[indexG] <= s[indexS]) {
                satisfied++;
                indexG++;
                indexS++;
            }else {
                indexS++;
            }
        }
        return satisfied;
    }


    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int indexG = g.length-1;
        int indexS = s.length-1;
        int satisfied = 0;

        while (indexG >= 0 && indexS >= 0) {
            if (g[indexG] <= s[indexS]) {
                satisfied++;
                indexG--;
                indexS--;
            }else {
                indexG--;
            }
        }
        return satisfied;
    }

    public static void main(String[] args) {
        int[] array_g = new int[]{1,2};
        int[] array_s = new int[]{1,2,3};
        SolutionLC445 solution = new SolutionLC445();
        System.out.println(solution.findContentChildren(array_g, array_s));
    }
}
