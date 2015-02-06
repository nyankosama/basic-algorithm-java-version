package com.nyankosama.test;

import com.nyankosama.algorithm.sort.Sortable;
import org.junit.Test;

/**
 * Created by i@nyankosama.com on 2014/12/6.
 */
public class TestCommon implements Sortable{

    @Test
    public void testCommon() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            findMedium(2, 1, 3);
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - begin) + "ms");
        begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            findMedium2(2, 1, 3);
        }
        end = System.currentTimeMillis();
        System.out.println("cost:" + (end - begin) + "ms");
    }

    private int findMedium2(int a, int b, int c) {
        return Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
    }

    private int findMedium(int a, int b, int c) {
        int min = a;
        int max = a;
        if (less(b, min))
            min = b;
        else
            max = b;
        if (less(c, min))
            min = c;
        else if (greater(c, max))
            max = c;
        return a + b + c - min - max;
    }

    @Override
    public void sort(Comparable[] a) {

    }
}
