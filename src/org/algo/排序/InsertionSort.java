package org.algo.排序;

import java.util.Scanner;

public class InsertionSort {
    /**
     * 直接插入排序
     * @param arr
     * @return
     */
    public static void insertSort1(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int i, j;
        for (i = 1; i < arr.length; i++) {
            // 用来暂存要比较的元素
            int temp = arr[i];
            for (j= i-1; j >= 0 && arr[j] > temp; j--) {
                // 向后移动
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }


    /**
     * 折半插入排序
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int i,j,low,mid,high;
        for (i = 1; i < arr.length; i++) {
            int temp = arr[i];
            low = 0;
            high = i-1;
            while (low < high) {
                mid = (low + high) / 2;
                if (arr[mid] < temp) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            // j >= high+1
            for (j = i - 1; j >= high+1; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // do a gapped intersection sort for this gap size
            for (int i = gap; i < n; i++) {
                // save a[i] in temp and make a hole at position i
                int temp = arr[i];
                int j;
                // the first way
//                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
//                    arr[j + gap] = arr[j];
//                }
//                arr[j+gap] = temp;

                // the second way
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
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
        int[] arr = new int[]{3, 2, 1, 5, 8 ,0 ,9};
//        insertSort1(arr);
//        insertSort2(arr);
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
