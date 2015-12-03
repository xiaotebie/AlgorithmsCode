package com.roy.practice;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ADMINISTRATOR on 2015/12/3 0003.
 */
public class GuessNum {

    int key = 5;

    public int guess(int m, int n){
        int mid = n - (n - m) / 2;

        if (compareToKey(mid) < 0)
            return guess(mid +1, n);
        if (compareToKey(mid) > 0)
            return guess(m, mid);
        else
            return mid;
    }

    public int compareToKey(int num){
        int result;
        if (num > key)
            result = 1;
        else if (num < key)
            result = -1;
        else
            result = 0;
        return  result;
    }

    public static void main(String[] args){
        GuessNum guess = new GuessNum();
        int num = guess.guess(1,10000000);
        StdOut.print(num);
    }
}
