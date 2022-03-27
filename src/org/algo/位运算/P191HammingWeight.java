package org.algo.位运算;

/**
 * @author: jml
 * @date: 2022/3/22
 */
public class P191HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 二进制位运算，n&(n-1)可以消除二进制位中的最后一个1
        int res = 0;
        while (n != 0) {
            n = n & (n-1);
            res++;
        }
        return res;
    }
}
