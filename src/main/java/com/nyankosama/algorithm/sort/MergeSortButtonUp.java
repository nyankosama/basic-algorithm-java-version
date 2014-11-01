package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class MergeSortButtonUp implements Sortable{
    //NOTE
    //1. 自底向上的mergeSort
    //2. 如果有序则跳过merge

    private Comparable[] aux;

    private static final int INSERT_SORT_THREASHOLD= 15;

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int stepSize = 1; stepSize < N; stepSize = stepSize + stepSize) {
            for (int low = 0; low < N - stepSize; low += stepSize + stepSize) {
                int mid = low + stepSize - 1;
                if (!less(a[mid], a[mid + 1]))
                    merge(a, low, mid, Math.min(low + stepSize + stepSize - 1, N -1));
            }
        }
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
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
