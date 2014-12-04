package com.nyankosama.algorithm.datastructure.graph.digraph;

/**
 * Created by i@nyankosama.com on 2014/12/4.
 */
public class DirectedEdge {

    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
