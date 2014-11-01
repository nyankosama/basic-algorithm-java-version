package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public class InsertSort implements Sortable{

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
