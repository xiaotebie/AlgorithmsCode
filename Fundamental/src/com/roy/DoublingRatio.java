package com.roy;

import com.roy.practice.ThreeSum;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.4.39
 * 改变倍率测试的精度
 *
 * Created by Roy
 * on 2015/12/3 0003.
 */
public class DoublingRatio {

    public static double timeTrial(int N) {
        int Max = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-Max,Max);
        long start = System.nanoTime();
        int cnt = ThreeSum.count(a);
        return System.nanoTime() - start;
    }

    public static void main(String[] args){
        double prev = timeTrial(125);
        int newN = StdIn.readInt();
        for (int N = 250; N < 10000;N += N){
            int loop = newN;
            double time = 0;
            while (loop -- > 0) {
                time = timeTrial(N);
                StdOut.printf("%6d %7.1f", N, time);
                StdOut.printf("%5.1f\n", time / prev);

            }
            prev = time;
        }
    }

}
