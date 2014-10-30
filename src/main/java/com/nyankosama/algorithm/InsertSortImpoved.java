package com.nyankosama.algorithm;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public class InsertSortImpoved implements Sortable{

    //NOTE 把元素交换的操作换成元素移动
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable v = a[i];
            int j = 0;
            for (j = i; j > 0 && less(v, a[j - 1]); j--) {
                a[j] = a[j-1];
            }
            a[j] = v;
        }
    }
}
