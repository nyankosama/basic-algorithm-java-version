package com.nyankosama.algorithm.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用Trie树，实现符号表查找
 * 查找和插入键的复杂度与键的长度成正比
 */
public class TrieST<Value> {

    private static int R = 256;
    private Node<Value> root;

    private static class Node<Value> {
        private Value val;
        private Node<Value>[] next = new Node[R];
    }

    /**
     * 查找键
     * @param key
     * @return
     */
    public Value get(String key) {
        Node<Value> x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node<Value> x, String key, int d) {
        //递归查找
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    /**
     * 更新键
     * 如果键已经存在则更新val
     * 否则插入新的节点
     * @param key
     * @param val
     */
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node<Value> x, String key, Value val, int d) {
        if (x == null) x = new Node<>(); //插入新节点
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x; //链到前一个节点的next[c]处
    }

    /**
     * 返回所有的键
     * 只需要知道前缀为空字符串即可
     * @return
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }


    /**
     * 查找前缀为pre的所有键
     * @param pre
     * @return
     */
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q); //找到前缀为pre的节点x，x下的所有节点一定都满足
        return q;
    }

    private void collect(Node<Value> x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.offer(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    /**
     * 找到满足pat的所有键，其中'.' 可以匹配所有字符串
     * @param pat
     * @return
     */
    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new LinkedList<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node<Value> x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.offer(pre); //进过递归后到达d层时，如果有val则返回
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    /**
     * 找到前缀最长的键
     * @param s
     * @return
     */
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node<Value> x, String s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d; //每当找到一个val时就更新长度
        if (d == s.length()) return length; //直到到达length层的，此时的length一定是最大的
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    /**
     * 删除某一个键
     * @param key
     */
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node<Value> x, String key, int d) {
        if (x == null) return null; //改变前一个节点的next[c]
        if (d == key.length()) {
            x.val = null; //找到key，把val变成null
        } else {
            //否则继续
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val != null) return x; //如果删除完毕后，本节点val不等于null，则不删除本节点
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;//如果本节点的next有一个不为null，则不删除本节点
        }
        return null; //本节点所有的next为null且val也为null，则可以删除本节点
    }
}
