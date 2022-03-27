package org.algo.排序;

import java.util.Arrays;

public class BucketSort {
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }
        // 桶的数量
        int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
        int[][] buckets = new int[bucketCount][0];
        // 映射
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length < 0) {
                continue;
            }
            Arrays.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
    }

    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
