package org.algo.排序;


public class QuickSort {
    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            // 左半部分递归
            quickSort(arr, left, partitionIndex-1);
            // 右半部分递归
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4, 2,1, 5};
        int[] res = quickSort(arr);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
