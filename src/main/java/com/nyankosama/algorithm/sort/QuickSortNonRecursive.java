package com.nyankosama.algorithm.sort;

import java.util.Stack;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class QuickSortNonRecursive implements Sortable {
    private Stack<Integer> s = new Stack<>();

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        s.push(low);
        s.push(high);
        while (!s.empty()) {
            high = s.pop();
            low = s.pop();
            if (low >= high) continue;
            int mid = partition(a, low, high);
            s.push(low);
            s.push(mid - 1);
            s.push(mid + 1);
            s.push(high);
        }
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
