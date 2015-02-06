package com.nyankosama.algorithm.sort;

/**
 * @created: 2015/2/6
 * @author: nyankosama
 * @description: 原地归并排序：http://www.cnblogs.com/daniagger/archive/2012/07/25/2608373.html
 */
public class MergeSortInPlace implements Sortable{

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable a[], int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid + 1, hi);
        }
    }

    private void merge(Comparable a[], int lo, int mid, int hi) {
        int i = lo, j = mid, k = hi;
        while (i < j && j <= k) {
            int step = 0;
            while (i < j && less(a[i], a[j])) i++;
            while (j <= k && less(a[j], a[i])) {
                j++;
                step++;
            }
            moveLeft(a, i, j - i, j - i - step);
            i = i + step;
        }
    }

    public static void main(String args[]) {
        Integer a[] = {5, 2, 1, 3, 4};
        Sortable s = new MergeSortInPlace();
        s.sort(a);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
