package com.nyankosama.algorithm.sort;

/**
 * @created: 2015/2/6
 * @author: nyankosama
 * @description: 标准未优化的bubble sort
 */
public class BubbleSort implements Sortable{

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (less(a[j + 1], a[j])) exch(a, j + 1, j);
            }
        }
    }

    public static void main(String args[]) {
        Integer a[] = {4, 2, 1, 3};
        Sortable s = new BubbleSort();
        s.sort(a);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
