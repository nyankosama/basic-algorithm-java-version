package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class MergeSortTopDownImprove implements Sortable{
    //NOTE
    //1. 数量 <= 15的数组使用插入排序
    //2. 在merge前判断a[mid] <= a[mid+1]跳过merge
    //3. aux和a数组，在子递归中不断调换其作用，可以节省辅助数组复制的操作

    private Comparable[] aux;

    private int sortCount = 0;//用于判断a, b数组交换, 若为基数则正确的数据在a中，否则在b中

    private static final int INSERT_SORT_THRESHOLD= 3;


    @Override
    public void sort(Comparable[] a) {
        //初始化aux
        int N = a.length;
        aux = new Comparable[N];
        System.arraycopy(a, 0, aux, 0, N);
        sort(a, aux, 0, N - 1);
        if (sortCount % 2 == 1) {
            System.arraycopy(aux, 0, a, 0, N);
        }
    }

    private void sort(Comparable[] a, Comparable[] b, int low, int high) {
        int N = a.length;
        //NOTE 使用插入排序排序小数组
        if (high - low <= INSERT_SORT_THRESHOLD) {
            insertSort(a, low, high);
            return;
        }
        int mid = low + (high - low) / 2;
        //调换aux和a数组的作用
        sort(b, a, low, mid);
        sort(b, a, mid + 1, high);
        //判断 a[mid] <= a[mid+1]，如果是则跳过merge
        sortCount++;
        if (!less(b[mid], b[mid + 1]))
            merge(b, a, low, mid, high);
        else
            System.arraycopy(b, low, a, low, high - low + 1);
    }

    private void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
        int N = a.length;
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            if (left > mid) a[i] = b[right++];
            else if(right > high) a[i] = b[left++];
            else if (less(b[left], b[right])) a[i] = b[left++];
            else a[i] = b[right++];
        }
    }

    private void insertSort(Comparable[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            Comparable v = a[i];
            int j = 0;
            for (j = i; j > 0 && less(v, a[j - 1]); j--) {
                a[j] = a[j-1];
            }
            a[j] = v;
        }
    }
}
