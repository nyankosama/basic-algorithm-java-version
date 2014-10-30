package com.nyankosama.algorithm;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public interface Sortable {
    public void sort(Comparable[] a);

    public default boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0)
            return true;
        else
            return false;
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
