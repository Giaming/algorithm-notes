package org.algo.排序;

import java.util.Scanner;

public class BubbleSort {
    public static void sort(int[] arr) {
        int i,j,temp;
        boolean flag = false;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
                if (flag == false) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] str = sc.nextLine().split(" ");
//        int[] arr = new int[str.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(str[i]);
//        }
        int[] arr = new int[]{3 ,2 , 5 , 0 , 1 , 4};
        BubbleSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
