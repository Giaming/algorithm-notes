package org.algo.位运算;

/**
 * @author: jml
 * @date: 2022/3/22
 */
public class P190ReverseBits {
    // you need treat n as an unsigned value

    public int reverseBits(int n) {
        // 方法1：对输入的n做诸位检查
        // 如果某一位是1的话，则将答案对应的对称位置修改为1
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            if (t == 1) {
                ans |= (1 << (31 - i));
            }
        }
        return ans;
    }

    // 每次都使用n的最低一位，使用n的最低一位去更新答案的最低一位，使用完将n进行右移一位，将答案左移一位。
    public int reverseBits1(int n) {
        int ans = 0;
        int cnt = 32;
        while (cnt-- > 0) {
            ans = ans << 1;
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}