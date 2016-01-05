package com.roy.practice;

import com.roy.Example;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现一个方法，返回一个有序的a[]， 并删去其中的重复元素
 * Created by ROY on 2016/1/5 0005.
 */
public class Dedup extends Example {

    public static String[] dedup(String[] a) {
        Arrays.sort(a);
        List<String> sorted = new ArrayList<>();
        int i = 0;
        int len = a.length;
        while (i < len) {
            String first = a[i];
            int k = i + 1;
            while (k < len) {
                if (!a[k++].equals(first)) {
                    sorted.add(a[i]);
                    break;
                }else
                    i++;
            }
            i++;
        }

        return (String[]) sorted.toArray(a);
    }

    public static void main(String[] args) {

        for (String arg : args) {
            StdOut.print(arg);
            StdOut.print(",");
        }

        String[] sorted = dedup(args);

        StdOut.println("排序和删除重复之后：");
        for (String arg : sorted) {
            StdOut.print(arg);
            StdOut.print(",");
        }
    }
}
