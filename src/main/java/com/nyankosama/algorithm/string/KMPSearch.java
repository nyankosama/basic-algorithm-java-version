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
                    j = pmt[j - 1]; //模式匹配串移动到下一个位置
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

    /**
     * 算法的关键在于next数组的生成,用动态规范法生成。
     * 比如：str = abcabd，next初始化为：[0,0,0,0,0,0];
     * 已知第0个字符a没有任何相同的前后缀，则next[0] = 0。
     * 加入第1个字符，则前面已知的最长公共前后缀长度为next[0]，此时如果str[next[0]]与str[1]相等，就可知道next[1]=next[0]+1，如不相等则可直接判定next[1]=0；这里str[next[0]]!=str[1]，故next[1]=0。
     * ...，next[2]=0。
     * ...，next[3]=next[2]+1=1。
     * ...，next[4]=next[3]+1=2。
     * ...，next[5]=0。
     * 最后，next=[0,0,0,1,2,0];
     * @param pmt
     * @param pat
     */
    private static void createPMT(int[] pmt, String pat) {
        for (int i = 1; i < pat.length(); i++) {
            if (pat.charAt(pmt[i - 1]) == pat.charAt(i)) {
                pmt[i] = pmt[i - 1] + 1;
            } else {
                pmt[i] = 0;
            }
        }
    }
}
