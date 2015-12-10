package com.roy.practice;

import com.roy.Example;

/**
 * 出列排序<br>
 * 如何将一副扑克牌排序<br>
 * 限制条件是只能查看最上面的两张牌，交换最上面的两张牌，或是将最上面的一张牌放到这摞牌的最下面<br>
 * Created by Roy on 2015/12/10 0010.
 */
public class SortPoker extends Example {

    /**
     * 排序
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 循环一次找到最大的那张牌，直接放到牌底
        while (N > 0) {
            for (int i = N - 1; i > 0; i--) {
                if (less(a[a.length - 2], a[a.length - 1]))
                    switchTop(a);
                TopToBottom(a);
            }
            for (int i = a.length - N; i > 0; i--) {
                if (less(a[a.length - 1], a[a.length - 2]))
                    switchTop(a);
                TopToBottom(a);
            }
            N--;
        }
    }

    /**
     * 交换最上面两张牌
     *
     * @param a
     */
    public static void switchTop(Comparable[] a) {
        exch(a, a.length - 1, a.length - 2);
    }

    /**
     * 交换最上面一张牌和第
     *
     * @param a
     */
    public static void TopToBottom(Comparable[] a) {
        int N = a.length;
        Comparable top = a[N - 1];
        System.arraycopy(a, 0, a, 1, N - 1);
        a[0] = top;
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序输出
        Integer[] a = new Integer[]{1, 13, 2, 8, 3, 12, 6};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
