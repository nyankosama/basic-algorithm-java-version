package com.nyankosama.algorithm.string;

/**
 * 低位优先的字符串排序
 * 假设字符串的长度相同
 */
public class LSD {

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1]; // 计算出现频率
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++)  //将频率转换为索引，即应该分组后的起始位置
                count[r + 1] = count[r];
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)  //回写
                a[i] = aux[i];
        }
    }
}
