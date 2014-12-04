package com.nyankosama.algorithm.datastructure.graph.digraph;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by i@nyankosama.com on 2014/12/4.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
    }

    public EdgeWeightedDigraph(InputStream in) {
        Scanner scanner = new Scanner(in);
        this.V = scanner.nextInt();
        this.E = scanner.nextInt();
        while (scanner.hasNextInt()) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public int V(){return V;}
    public int E(){return E;}

    public void addEdge(DirectedEdge edge) {
        this.adj[edge.from()].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
