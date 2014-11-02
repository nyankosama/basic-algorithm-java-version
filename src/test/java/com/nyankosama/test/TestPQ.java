package com.nyankosama.test;

import com.nyankosama.algorithm.datastructure.MaxPQ;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by i@nyankosama.com on 2014/11/2.
 */

public class TestPQ {
    private MaxPQ<Integer> pq;

    @Before
    public void setUp() {
        pq = new MaxPQ<>(100);
    }

    @Test
    public void testMaxPQ() {
        assert pq.isEmpty();
        pq.insert(4);
        pq.insert(2);
        pq.insert(3);
        pq.insert(1);
        assert !pq.isEmpty();
        assert pq.size() == 4;
        assert pq.delMax() == 4;
        assert pq.delMax() == 3;
        assert pq.delMax() == 2;
        assert pq.delMax() == 1;
        assert pq.size() == 0;
    }
}
