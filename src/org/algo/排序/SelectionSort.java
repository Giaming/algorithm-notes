package org.algo.排序;

import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 交换
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        selectionSort(arr);
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
    }
}
