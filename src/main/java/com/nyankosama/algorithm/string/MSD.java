package com.nyankosama.algorithm.string;

/**
 * 高位优先的字符串排序
 * 字符串长度可以不相等
 */
public class MSD {
    private static final int R             = 256;   // 基数
    private static final int CUTOFF        =  15;   // 小数组切换阈值

    public static void sort(String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(a, 0, N-1, 0, aux);
    }

    //返回index为d的字符串的char类型，如果d超过length则返回-1
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

        // 如果是小数组则使用插入排序
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        // 计算频率
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }

        // 将频率转换为索引
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // 数据分类
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // 回写
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];


        // 递归以每个字符串分类进行排序
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //以插入排序进行完整的字符串排序，从index为d的char开始排序
    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
}
