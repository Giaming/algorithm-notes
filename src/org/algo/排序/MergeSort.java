package org.algo.排序;


public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        // left
        mergeSort(arr, left, mid);
        // right
        mergeSort(arr, mid+1, right);
        // merge
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left+j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,1,5,0,19};
        mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
