package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public interface Sortable {
    public void sort(Comparable[] a);

    public default boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public default boolean lessEq(Comparable a, Comparable b){
        return a.compareTo(b) <= 0;
    }

    public default boolean equals(Comparable a, Comparable b){
        return a.compareTo(b) == 0;
    }

    public default boolean greter(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    public default boolean greterEq(Comparable a, Comparable b){
        return a.compareTo(b) >= 0;
    }

    public default void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public default void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public default boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}
