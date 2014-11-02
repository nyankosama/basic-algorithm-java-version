package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class QuickSortFast3Way implements Sortable {
    //NOTE 使用bentley-mcilroy 3-way partitioning 解决重复元素的问题，这比直接3-way要好一点，减少了元素的交换次数
    //link: http://www.sorting-algorithms.com/static/QuicksortIsOptimal.pdf

    private static final int INSERT_SORT_THRESHOLD = 15;

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high - low + 1 <= INSERT_SORT_THRESHOLD) {
            //NOTE 小数组使用插入排序
            insertSort(a, low, high);
            return;
        }
        int i = low - 1, j = high, p = low - 1, q = high;
        int pivot = findMedium(a, low, (high - low) / 2, high);
        Comparable v = a[pivot];
        exch(a, high, pivot);
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
            if (a[i] == v) { p++; exch(a, p, i); }
            if (v == a[j]) { q--; exch(a, j, q); }
        }
        exch(a, i, high); j = i-1; i = i+1;
        for (int k = low; k < p; k++, j--) exch(a, k, j);
        for (int k = high - 1; k > q; k--, i++) exch(a, i, k);

        sort(a, low, j);
        sort(a, i, high);
    }

    private int findMedium(Comparable[] a, int i, int j, int k) {
        int min = i;
        int max = i;
        if (less(a[j], a[min]))
            min = j;
        else
            max = j;
        if (less(a[k], a[min]))
            min = k;
        else if (greater(a[k], a[max]))
            max = k;
        return i + j + k - min - max;
    }

    private void insertSort(Comparable[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            Comparable v = a[i];
            int j;
            for (j = i; j > 0 && less(v, a[j - 1]); j--) {
                a[j] = a[j-1];
            }
            a[j] = v;
        }
    }
}
