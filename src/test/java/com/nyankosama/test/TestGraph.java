package com.nyankosama.test;

import com.nyankosama.algorithm.datastructure.graph.undigraph.Graph;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i@nyankosama.com on 2014/11/3.
 */
public class TestGraph {

    @Test
    public void testGraph() throws InstantiationException, IllegalAccessException {
        List<Object> list[] = create(ArrayList.class, 2);
        Graph g = new Graph(10);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        assert g.E() == 4;
        System.out.println(10 + Integer.MAX_VALUE);
    }

    private <T> T[] create(Class<T> clz, int lenth) throws IllegalAccessException, InstantiationException {
        T t[] = (T[]) new Object[lenth];
        for (int i = 0; i < lenth; i++) {
            t[i] = clz.newInstance();
        }
        return t;
    }
}
