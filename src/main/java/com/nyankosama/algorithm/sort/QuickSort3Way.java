package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class QuickSort3Way implements Sortable {
    //NOTE
    //1. 小数组使用插入排序
    //2. 选取pivot的时候使用三取样切分
    //3. 使用三路快速排序

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
        int lt = low, i = low + 1, gt = high;
        int pivot = findMedium(a, low, (high - low) / 2, high);
        Comparable v = a[pivot];
        exch(a, low, pivot);
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
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
