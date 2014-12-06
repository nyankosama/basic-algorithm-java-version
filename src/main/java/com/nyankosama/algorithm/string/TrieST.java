package com.nyankosama.algorithm.string;

/**
 * 使用Trie树，实现符号表查找
 */
public class TrieST<Value> {

    private static int R = 256;
    private Node<Value> root;

    private static class Node<Value> {
        private Value val;
        private Node<Value>[] next = new Node[R];
    }

    public Value get(String key) {
        Node<Value> x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node<Value> x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node<Value> x, String key, Value val, int d) {
        if (x == null) x = new Node<>();
        if (d == key.length()) { x.val = val; return x;}
        char c = key.charAt(d);
        x.next[x] = put(x.next[c], key, val, d + 1);
        return x;
    }
}

