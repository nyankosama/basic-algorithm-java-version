package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/2.
 */
public class HeapSort implements Sortable {
    //NOTE
    //这里使用0-based index，父节点为k，两个子节点分别为2*(k+1)-1和2*(k+1)
    //子节点为k的话，父节点为(k-1)/2向下取整
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int k = (N - 1) / 2; k >= 0; k--) {
            sink(a, k, N - 1);
        }
        while (N > 0) {
            exch(a, 0, --N);
            sink(a, 0, N - 1);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (2 * (k + 1) - 1 <= N) {
            int j = 2 * (k + 1) - 1;
            if (j < N && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }
}
