package com.nyankosama.test;

import com.nyankosama.algorithm.datastructure.graph.Graph;
import org.junit.Test;

/**
 * Created by i@nyankosama.com on 2014/11/3.
 */
public class TestGraph {

    @Test
    public void testGraph() {
        Graph g = new Graph(10);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        assert g.E() == 4;
    }
}
