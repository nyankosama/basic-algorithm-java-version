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

    public default boolean greater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    public default boolean greaterEQ(Comparable a, Comparable b){
        return a.compareTo(b) >= 0;
    }

    public default Comparable max(Comparable a, Comparable b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public default Comparable min(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    public default void reverse(Comparable a[], int begin, int length) {
        int i = begin, j = begin + length - 1;
        while (i < j) {
            exch(a, i, j);
            i++;
            j--;
        }
    }

    public default void moveLeft(Comparable a[], int begin, int length, int step) {
        reverse(a, begin, step);
        reverse(a, begin + step, length - step);
        reverse(a, begin, length);
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
