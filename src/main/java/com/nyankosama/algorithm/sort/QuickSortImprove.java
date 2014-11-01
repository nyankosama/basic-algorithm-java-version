package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class QuickSortImprove implements Sortable {
    //NOTE
    //1. 小数组使用插入排序
    //2. 选取pivot的时候使用三取样切分
    //3. 利用哨兵去掉内循环中的边界检查

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
        int mid = partition(a, low, high);
        sort(a, low, mid - 1);
        sort(a, mid + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        //NOTE 三取样切分，选取中位数作为pivot
        int pivot = findMedium(a, low, (high - low) / 2, high);
        Comparable v = a[pivot];
        exch(a, low, pivot);
        int i = low;
        int j = high;//使用哨兵，每次腾出high位置的元素赋值为v
        Comparable last = a[high];
        a[high] = v;
        while (true) {
            while (less(a[++i], v));
            while (less(v, a[--j]));
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        //判断最后的元素
        if (less(last, v)) {
            exch(a, j + 1, high);
            exch(a, j, j + 1);
        }
        return j;
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
        else if (greter(a[k], a[max]))
            max = k;
        return i + j + k - min - max;
    }

    private void insertSort(Comparable[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            Comparable v = a[i];
            int j = 0;
            for (j = i; j > 0 && less(v, a[j - 1]); j--) {
                a[j] = a[j-1];
            }
            a[j] = v;
        }
    }
}
