package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class MergeSortTopDown implements Sortable {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        int N = a.length;
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        //COPY
        int N = a.length;
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
        for (int i = low; i <= high; i++) {
            if (left > mid) a[i] = aux[right++];
            else if(right > high) a[i] = aux[left++];
            else if (less(aux[left], aux[right])) a[i] = aux[left++];
            else a[i] = aux[right++];
        }
    }
}
