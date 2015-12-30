package com.roy.baseSort;

/**
 * 归并排序<br>
 *     自底向上排序
 * Created by Roy on 2015/12/20 0020.
 */
public class MergeUB extends Merge{
    public static void sort(Comparable[] a){
        // 进行lgN次亮亮归并
        int N = a.length;
        auth = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            for (int low = 0; low < N - sz; low += sz + sz)
                merge(a, low, low + sz + 1, Math.min(low + sz + sz + 1, N - 1));
    }
}
