package com.roy.practice;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.4.44
 * 编写一个程序，从命令行接受一个整数N作为参数并使用StdRandom.uniform()生成一些了0到N-1之间的随机整数。<br><br>
 * 通过实验验证产生第一个重复的随机数之前生成的整数数量<br>
 * Created by ADMINISTRATOR on 2015/12/3 0003.
 */
public class SameRandomTest {

    public int hasSame(int n) {
        int count = 0;
        byte[] randomArray = new byte[n];
        while (true) {
            int random = randomArray[StdRandom.uniform(0, n - 1)];
            if (random == 0) {
                randomArray[StdRandom.uniform(0, n - 1)] = 1;
                count++;
            } else
                break;
        }
        return count;
    }

    public double randomFact(int n) {
        double a = Math.PI * n / 2;
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        SameRandomTest test = new SameRandomTest();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            int same = test.hasSame(n);
            StdOut.print("实际个数：" + same);
            StdOut.print("理论个数：" + (int) test.randomFact(n) + System.getProperty("line.separator"));
            sum += same;
        }
        StdOut.print("平均值为：" + sum / 1000);
    }
}
