package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class QuickSort implements Sortable {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int mid = partition(a, low, high);
        sort(a, low, mid - 1);
        sort(a, mid + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }
}
