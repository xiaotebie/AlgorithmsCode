package com.roy.baseSort;

import com.roy.Example;
import edu.princeton.cs.algs4.StdOut;

/**
 * 归并排序:自顶向下<br>
 * <p>
 * Created by Roy on 2015/12/10 0010.
 */
public class Merge extends Example {
    static Comparable[] auth;
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * 指定而下的归并排序
     *
     * @param a    数组
     * @param low  低位
     * @param high 高位
     */
    public static void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 原地化归并的抽象方法
     *
     * @param a    数组
     * @param low  低位
     * @param mid  中间值
     * @param high 高位
     */
    public static void merge(Comparable[] a, int low, int mid, int high) {
        auth = new Comparable[a.length];
        // 将a[low..mid] 和 a[mid+1 ... hign] 归并
        int i = low, j = mid + 1;

        System.arraycopy(a, low, auth, low, high + 1 - low);

        for (int k = low; k <= high; k++) {
            if (i > mid) auth[k] = a[j++];
            else if (j > high) auth[k] = a[i++];
            else if (less(a[i], a[j])) auth[k] = a[i++];
            else auth[k] = a[j++];
        }
    }

    public static void main(String[] args){
        Comparable[] raw = new Comparable[] {10 ,5,2,6,3,1,9,11,12};
        sort(raw);
        for (Comparable a: auth)
            StdOut.print(a + ",");
    }
}
