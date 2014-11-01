package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class MergeSortNature implements Sortable{
    //NOTE 自然归并排序，不考虑复制优化

    private Comparable[] aux;
    private int[] pass; //记录自然有序子串的开始index
    private int natureNum; //记录当前循环下的子串的数目

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        natureNum = 0;
        aux = new Comparable[N];
        pass = new int[N + 1];
        pass(a);
        while (natureNum > 1) {
            int newNatureNum = 0;
            int i;
            for (i = 0; i < natureNum - 1; i += 2) {
                merge(a, pass[i], pass[i + 1] - 1, pass[i + 2] - 1);
                pass[newNatureNum++] = pass[i];
            }
            if (i == natureNum - 1) {
                //NOTE 最后一个索引如果成单无法进入merge，仍然需要移动pass数组
                pass[newNatureNum++] = pass[i];
            }
            natureNum = newNatureNum;
            pass[natureNum] = N;
        }
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        int N = a.length;
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }
        for (int i = low; i <= high; i++) {
            if (left > mid) a[i] = aux[right++];
            else if(right > high) a[i] = aux[left++];
            else if (less(aux[left], aux[right])) a[i] = aux[left++];
            else a[i] = aux[right++];
        }
    }

    private void pass(Comparable[] a) {
        int N = a.length;
        pass[0] = 0;
        natureNum++;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i - 1])) {
                pass[natureNum++] = i;
            }
        }
        pass[natureNum] = N;
    }
}
