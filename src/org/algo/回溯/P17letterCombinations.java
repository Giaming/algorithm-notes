package org.algo.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/
 * @author giaming
 * @date 2022/2/26
 */
public class P17letterCombinations {

    class Solution {
        List<String> result = new ArrayList<>();
        //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
        StringBuilder temp = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return result;
            }
            // 初始化所有数字
            String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            // 迭代处理
            backTracing(digits, numString, 0);
            return result;
        }

        private void backTracing(String digits, String[] numString, int num) {
            // 遍历全部一次记录一次得到的字符串
            if (num == digits.length()) {
                result.add(temp.toString());
                return;
            }
            // str 表示当前num对应的字符串
            String str = numString[digits.charAt(num) - '0'];
            for (int i = 0; i < str.length(); i++) {
                temp.append(str.charAt(i));
                backTracing(digits, numString, num+1);
                // 剔除末尾的继续尝试
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

}
