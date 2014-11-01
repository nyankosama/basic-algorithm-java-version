package com.nyankosama.test;

import com.nyankosama.algorithm.sort.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public class TestSort {
    private static final int ARRAY_NUM = 10;
    private Comparable<Integer> num[];
    private Sortable sortUtils = a -> {};
    private Set<Sortable> toValidate = new HashSet<>();

    private void validate(Sortable sortable) {
        toValidate.add(sortable);
    }

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

    @After
    public void after() {
        for (Sortable sortable : toValidate) {
            sortable.sort(num);
            assert  sortUtils.isSorted(num);
            setUp();
        }
        toValidate.clear();
    }

    @Test
    public void testSelectionSort() {
        validate(new SelectionSort());
    }

    @Test
    public void testInsertSort() {
        validate(new InsertSort());
        validate(new InsertSortImpoved());
        validate(new InsertSortBinary());
    }

    @Test
    public void testShellSort() {
        validate(new ShellSort());
    }

    @Test
    public void testTopDownMergeSort() {
        validate(new MergeSortTopDown());
        validate(new MergeSortTopDownImprove());
        validate(new MergeSortButtonUp());
        validate(new MergeSortNature());
    }

}
