package com.nyankosama.algorithm.datastructure.pq;

/**
 * Created by i@nyankosama.com on 2014/11/2.
 */
public class MinPQ<Key extends Comparable<Key>> {
    //NOTE 使用数组实现的优先队列

    private Key[] pq;
    private int N = 0;

    private int maxN;

    public MinPQ(int maxN) {
        this.maxN = maxN;
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void clear() {
        pq = (Key[]) new Comparable[maxN + 1];
        N = 0;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMin() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}
