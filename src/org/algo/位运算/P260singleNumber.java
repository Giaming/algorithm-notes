package org.algo.位运算;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jml
 * @date: 2022/3/22
 */
public class P260singleNumber {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[2];
        int idx = 0;
        for (int i : nums) {
            if(map.get(i) == 1) {
                ans[idx++] = i;
            }
        }
        return ans;
    }


    // 使用位运算

    /**
     * 利用除答案以外的元素均出现两次，我们可以先对 $nums$ 中的所有元素执行异或操作，得到 $sum$，$sum$ 为两答案的异或值（$sum$ 必然不为 $0$）。
     *
     * 然后取 $sum$ 二进制表示中为 $1$ 的任意一位 $k$，$sum$ 中的第 $k$ 位为 $1$ 意味着两答案的第 $k$ 位二进制表示不同。
     *
     * 对 $nums$ 进行遍历，对第 $k$ 位分别为 $0$ 和 $1$ 的元素分别求异或和（两答案必然会被分到不同的组），即为答案。
     */
    public int[] singleNumber2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum ^ num;
        }
        // 找到为1的第k位
        int k = -1;
        for (int i = 31; i >= 0 && k == -1; i--)  {
            if (((sum >> i) & 1) == 1) k = i;
        }
        int[] ans = new int[2];
        for(int i : nums) {
            if (((i >> k) & 1) == 1) ans [1] ^= i;
            else ans[0] ^= i;
        }
        return ans;
    }
}
