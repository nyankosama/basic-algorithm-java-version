package com.nyankosama.algorithm.string;

/**
 * KMP算法
 * 具体理解见：http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * 对于长度为M的模式文本和长度为N的文本，KMP算法访问字符不会超过M+N个
 */
public class KMPSearch {

    public static int search(String str, String pat) {
        int N = str.length();
        int M = pat.length();
        int[] pmt = new int[M];
        //构造部分匹配表
        createPMT(pmt, pat);
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (str.charAt(i) != pat.charAt(j)) {
                if (j == 0) {
                    //匹配0个, 直接后移一位
                    i++;
                } else {
                    i -= pmt[j - 1]; //根据pmt回退
                    j = 0;
                }
            } else {
                //匹配成功，继续匹配下一位
                i++;
                j++;
            }
        }
        if (j == M)
            return i - j; //匹配成功
        else
            return -1; //未找到
    }

    private static void createPMT(int[] pmt, String pat) {
        int M = pat.length();
        for (int i = 1; i <= M; i++) {
            String match = pat.substring(0, i);
            int max = 0;
            for (int j = 1; j < i; j++) {
                String pre = match.substring(0, j);
                String post = match.substring(i - j, i);
                if (pre.equals(post)) max = j;
            }
            pmt[i - 1] = max;
        }
    }
}
