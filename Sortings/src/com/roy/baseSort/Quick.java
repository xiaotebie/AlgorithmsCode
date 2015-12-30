package com.roy.baseSort;

import com.roy.Example;
import edu.princeton.cs.algs4.StdOut;

/**
 * 快速排序
 * Created by ADMINISTRATOR on 2015/12/29 0029.
 */
public class Quick extends Example {

    public static int M = 50;
    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);   // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if (low >= high - M) { Insertion.sort(a,low,high+1); return;}
        int j = partition(a,low,high);
        sort(a, low, j - 1);
        sort(a, j+1, high);
    }

    public static int partition(Comparable[] a, int low, int high){
        int i = low, j = high+1;
        Comparable v = a[low];
        while (true){
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low)  break;
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a, low,j);
        //Arrays.sort(a);
        return j;
    }

    public static void main(String[] args){
        Comparable[] a = new Comparable[] {43,25,2,14,8,11,21,1};
        sort(a);
        for (Comparable b: a) {
            StdOut.print(b);
            StdOut.print(",");
        }
    }
}
