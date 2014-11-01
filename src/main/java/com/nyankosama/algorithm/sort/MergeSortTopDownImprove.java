package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/11/1.
 */
public class MergeSortTopDownImprove implements Sortable{
    //NOTE
    //1. 数量 <= 15的数组使用插入排序
    //2. 在merge前判断a[mid] <= a[mid+1]跳过merge
    //3. 只复制一次到aux中，merge中的复制可以避免

    private Comparable[] aux;

    private static final int INSERT_SORT_THREASHOLD= 15;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        int N = a.length;
        //NOTE 使用插入排序排序小数组
        if (high - low <= INSERT_SORT_THREASHOLD) {
            insertSort(a, low, high);
            //这里直接复制，避免merge的时候重复复制
            for (int i = low; i <= high; i++) {
                aux[i] = a[i];
            }
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        //判断 a[mid] <= a[mid+1]，如果是则跳过merge
        if (!less(a[mid], a[mid + 1]))
            merge(a, low, mid, high);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        int N = a.length;
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            if (left > mid) a[i] = aux[right++];
            else if(right > high) a[i] = aux[left++];
            else if (less(aux[left], aux[right])) a[i] = aux[left++];
            else a[i] = aux[right++];
        }
    }

    private void insertSort(Comparable[] a, int low, int high) {
        int N = high - low + 1;
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
