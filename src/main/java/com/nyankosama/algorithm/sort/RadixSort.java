package com.nyankosama.algorithm.sort;

import java.util.Arrays;

/**
 * @created: 2015/2/6
 * @author: nyankosama
 * @description: 基数排序 http://zh.wikipedia.org/wiki/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F
 */
public class RadixSort {

    public void sort(int[] a) {
        int d = maxbit(a);
        int aux[] = new int[a.length];
        int count[] = new int[10];
        int radix = 1;
        for (int i = 1; i <= d; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < a.length; j++) {
                int k = (a[j] / radix) % 10;
                count[k]++;
            }
            for (int j = 1; j < 10; j++) {
                count[j] = count[j - 1] + count[j];
            }
            for (int j = a.length - 1; j >= 0; j--) {
                int k = (a[j] / radix) % 10;
                aux[count[k] - 1] = a[j];
                count[k]--;
            }
            System.arraycopy(aux, 0, a, 0, a.length);
            radix *= 10;
        }
    }

    private int maxbit(int[] a) {
        int d = 1;
        int p = 10;
        for (Integer i : a) {
            while (i >= p) {
                p *= 10;
                ++d;
            }
        }
        return d;
    }

    public static void main(String args[]) {
        int a[] = {5, 2, 1, 3, 4};
        RadixSort s = new RadixSort();
        s.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
