package org.algo.greedy;

/**
 * @author giaming
 */
public class SolutionLC860 {
    /**
     * 情况一：账单是5，直接收下。
     * 情况二：账单是10，消耗一个5，增加一个10
     * 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }else if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            }else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    twenty++; // 这一行没用
                }else if (five >= 3) {
                    five -= 3;
                    twenty++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
