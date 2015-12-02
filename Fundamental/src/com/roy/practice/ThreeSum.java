package com.roy.practice;

import com.roy.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * <h1>1.4.2练习</h1>
 * 修改后的ThreeSum，正确处理两个较大int值相加可能移除的情况
 * Created by Roy on 2015/12/2 0002.
 */
public class ThreeSum {
    public static int count(int[] a) {
        // 计算和为0的三元组的数目
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++) {
                    if (addOK(a[i],a[j]) && addOK(a[k], a[j]) && addOK(a[i],a[k]))
                        if (a[i] + a[j] + a[k] == 0)
                            cnt++;
                }
        return cnt;
    }

    /**
     * 相加是否溢出
     * @param x 第一个值
     * @param y 第二个值
     * @return 是否会溢出
     */
    public static boolean addOK(int x, int y) {
        int z = x + y;
        return !(x > 0 && y > 0 && z < 0) && !(x < 0 && y < 0 && z > 0);
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2000000000,300000000,2100000000};
        StdOut.println(count(a));
    }
}
