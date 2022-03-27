package org.algo.位运算;

/**
 * @author: jml
 * @date: 2022/3/22
 */
public class P231IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n&(n-1)) == 0;  // n&(n-1)表示去掉二进制位中的最后一个1
    }
}
