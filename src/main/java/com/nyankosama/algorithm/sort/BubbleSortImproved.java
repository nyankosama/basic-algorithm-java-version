package com.nyankosama.algorithm.sort;

/**
 * @created: 2015/2/6
 * @author: nyankosama
 * @description:
 * 优化：
 * 1. 设置flag，如果某一趟未发生交换，则说明排序已完成
 * 2. 记录最后一次发生交换的位置，说明该位置之后的元素均已有序并且大于之前元素，以后只比较该位置之前的元素即可
 */
public class BubbleSortImproved implements Sortable{

    @Override
    public void sort(Comparable[] a) {
        int flag = a.length, k;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int j = 1; j < k; j++) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    flag = j;
                }
            }
        }
    }

    public static void main(String args[]) {
        Integer a[] = {5, 3, 2, 1, 4};
        Sortable s = new BubbleSortImproved();
        s.sort(a);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
