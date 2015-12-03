package com.roy.practice;

import edu.princeton.cs.algs4.StdOut;

/**
 * <h1>算法1.4.20<h1/>
 * 双调数组，查找是否含有某个元素<br>
 * Created by Roy on 2015/12/3 0003.
 */
public class BitonicSort {

    /**
     * 双调排序选出最大值
     *
     * @param a     数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 最大值所处数组的位置
     */
    public int max(int[] a, int start, int end) {
        if (start == end)
            return start;
        int mid = start + (end - start) / 2;
        if (a[mid] < a[mid + 1])
            return max(a, mid + 1, end);
        if (a[mid] > a[mid - 1])
            return max(a, start, mid);
        else
            return mid;
    }

    /**
     * 查找
     *
     * @param a     数组
     * @param start 开始位置
     * @param end   结束位置
     * @return 数组中的位置
     */
    public int search(int[] a, int start, int end, int key) {
        if (start == end)
            return -1;
        int mid = start + (end - start) / 2;
        if (a[mid] > key)
            return search(a, start, mid, key);
        if (a[mid] < key)
            return search(a, mid + 1, end, key);
        else
            return mid;
    }

    public static void main(String[] args) {
        BitonicSort sort = new BitonicSort();
        int[] a = new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2};
        int mid = sort.max(a, 0, a.length - 1);
        int first = sort.search(a, 0, mid, 6);
        if (first > 0)
            StdOut.print("找到1:" + a[first]);
        int last = sort.search(a, mid+1,a.length - 1, 6);
        if (last > 0)
            StdOut.print("找到2:" + a[last]);
    }
}