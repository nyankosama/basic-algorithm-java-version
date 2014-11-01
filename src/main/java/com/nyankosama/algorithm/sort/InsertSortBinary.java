package com.nyankosama.algorithm.sort;

/**
 * Created by i@nyankosama.com on 2014/10/30.
 */
public class InsertSortBinary implements Sortable{
    //NOTE 使用二分查找法查找应该插入的位置，并使用System.arrayCopy整体复制数组内存块

    private int binarySearch(Comparable[] a, int low, int high, Comparable key) {
        int mid;
        while (low <= high) {
            mid = (low + high)/2;
            if (a[mid].compareTo(key) < 0) {
                low = mid + 1;
            }else if (a[mid].compareTo(key) > 0) {
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return low;
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable v = a[i];
            int index = binarySearch(a, 0, i - 1, v);
            System.arraycopy(a, index, a, index + 1, i - index);
            a[index] = v;
        }
    }
}
