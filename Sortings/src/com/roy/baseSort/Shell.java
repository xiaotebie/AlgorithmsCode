package com.roy.baseSort;

import com.roy.Example;

/**
 * 希尔排序，使数组中任意间隔为h的元素都是有序的
 * Created by Roy on 2015/12/10 0010.
 */
public class Shell extends Example {

    public static void sort(Comparable[] a){
        // 将a按照升序排序
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;  // 1, 4, 13, 40, 121, 364
        while (h >= 1){
            // 将数组变为h有序的
            for (int i = h; i < N; i++) {
                // 将a[i] 插入到a[i - h],a[i - 2h]...之中
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a,j,j-h);
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] {1, 3, 2,29,11, 24 };
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
