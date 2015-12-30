package com.roy.practice;

import com.roy.Example;

/**
 * 三向切分的快速排序
 * Created by Roy on 2015/12/29 0029.
 */
public class QuickThreeWay extends Example{

    public static void sort(Comparable[] a, int low, int high){
        if (high <= low) return;
        int lt = low, i = low + 1, gt = high;
        Comparable v = a[low];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0)        exch(a, lt, i);
            else if(cmp > 0)    exch(a, i, gt--);
            else                i++;
        } // a[low ... lt - 1]< v
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }
}
