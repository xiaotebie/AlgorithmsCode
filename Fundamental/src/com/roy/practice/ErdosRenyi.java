package com.roy.practice;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

/**
 * 1.5.17
 * Created by ADMINISTRATOR on 2015/12/9 0009.
 */
public class ErdosRenyi {

    public static int count(int N){
        Random random = new Random();
        int x = random.nextInt(N);
        int y = random.nextInt(N);
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while(!uf.connected(x,y))
            uf.union(x,y);
        return uf.count();
    }

    public static void main(String[] args){
        int N = StdIn.readInt();

        StdOut.print(count(N));
    }
}
