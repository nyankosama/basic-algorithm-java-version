package com.nyankosama.algorithm.string;

/**
 * 子串查找暴力解法，对于大多数子串匹配很少的情况
 * 算法的比较此处可以近似N + M
 * 但是如果在最坏的情况下，比较次数为NM
 */
public class NaiveSearch {

    public static int search(String str, String pat) {
        int N = str.length();
        int M = pat.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (str.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == M) return i; //子串完全匹配
        }
        return N;
    }
}
