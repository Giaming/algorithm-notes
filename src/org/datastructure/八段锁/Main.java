package org.datastructure.八段锁;

import java.util.Scanner;

/**
 * 题目描述：
 * 时间限制： 1000MS
 * 内存限制： 65536KB
 * 题目描述：
 * 陆伯言来到山顶观察此八卦阵，记从左往右第i堆石堆的高度为A[i]，发现任何两堆较矮的石堆都能和它们之间的一座较高的石堆形成"八卦锁"，将其中之人牢牢锁住，无从逃脱。
 *
 * 根据石堆的情况，陆伯言大致计算了“八卦锁”的数量，陆伯言大致计算了“八卦锁”的数量（即 A[i] < A[j] > A[k] 且I < j < k的组合数），不禁心中一惊,对孔明惊为天人，遂放弃追击，收兵回吴。
 *
 * “有劳岳父了。” “为何将其放走？” “...一表人才，何必浪费于此。”
 *
 *
 *
 * 输入描述
 * 第一行一个整数n，表示石堆堆数。
 *
 * 接下来一行，n个整数，第i个数表示从左到右第i堆石堆的高度A[i]。
 *
 * 1<=N<=5*10^4,1<=A[i]<=32768
 *
 * 输出描述
 * 输出仅一行，表示答案
 *
 *
 * 样例输入
 * 5
 * 1 2 3 4 1
 * 样例输出
 * 6
 */

public class Main {
//    public static void main(String[] args) {
//        int maxn = Integer.MIN_VALUE;
//        long ans = 0;
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//            maxn = Math.max(arr[i], maxn);
//        }
//        build(1,1,maxn);
//        for (int i = n; i >= 1; i--) {
//            update(1, arr[i]);
//            ans += l[i] * query_sum(1,1,arr[i]-1);
//        }
//        System.out.println(ans);
//    }
//
//    private static void build(int id, int l, int r) {
//
//    }


}
