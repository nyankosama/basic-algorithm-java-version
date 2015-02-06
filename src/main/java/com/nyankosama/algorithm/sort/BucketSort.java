package com.nyankosama.algorithm.sort;

/**
 * @created: 2015/2/6
 * @author: nyankosama
 * @description: 桶排序实现 http://zh.wikipedia.org/wiki/%E6%A1%B6%E6%8E%92%E5%BA%8F
 * 非比较型排序算法,用空间来换取时间，是所有排序方法中最快的方法，拥有线性的复杂度，但是同时也会消耗大量的空间。只适合范围不大的整数数组
 */
public class BucketSort {

    public void sort(int[] a) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (Integer i : a) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int[] buckets = new int[max - min + 1];
        for (Integer i : a) {
            buckets[i]++;
        }
        int pos = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                a[pos++] = i;
            }
        }
    }

}
