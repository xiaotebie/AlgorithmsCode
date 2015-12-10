package com.roy;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * Created by ADMINISTRATOR on 2015/12/9 0009.
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    /**
     * 交换元素位置
     * @param a 数组
     * @param i 位置1
     * @param j 位置2
     */
    protected static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a){
        for (Comparable anA : a) StdOut.print(anA + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args){
        // 从标准输入读取字符串，将它们排序输出
        Integer[] a = new Integer[] {1, 3, 2,29,11, 24 };
        sort(a);
        assert  isSorted(a);
        show(a);

    }
}
