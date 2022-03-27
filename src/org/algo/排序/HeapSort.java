package org.algo.排序;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        // 创建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // one by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // to heapify a subtree rooted with node i whih is an index in arr[]. n is size of heap
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
