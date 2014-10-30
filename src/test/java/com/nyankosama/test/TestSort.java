package com.nyankosama.test;

import com.nyankosama.algorithm.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public class TestSort {
    private static final int ARRAY_NUM = 100;
    private Comparable<Integer> num[];

    @Before
    public void setUp() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ARRAY_NUM; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        num = new Integer[ARRAY_NUM];
        num = list.toArray(num);
    }

    @Test
    public void testSelectionSort() {
        Sortable sort = new SelectionSort();
        sort.sort(num);
        assert sort.isSorted(num);
    }

    @Test
    public void testInsertSort() {
        Sortable sort1 = new InsertSort();
        Sortable sort2 = new InsertSortImpoved();
        Sortable sort3 = new InsertSortBinary();
        sort1.sort(num);
        assert sort1.isSorted(num);
        setUp();
        sort2.sort(num);
        assert sort2.isSorted(num);
        setUp();
        sort3.sort(num);
        assert sort3.isSorted(num);
    }

    @Test
    public void testShellSort() {
        Sortable sort = new ShellSort();
        sort.sort(num);
        assert sort.isSorted(num);
    }
}
