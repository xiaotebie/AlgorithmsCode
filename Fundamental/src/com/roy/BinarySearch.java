package com.roy;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by Roy on 2015/11/7 0007.
 *
 */
public class BinarySearch {
    public static int rank(int key, int[] a)
    {   // 数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {   //被查找的键要么不存在，要么必然存在于A[lo..hi]之中
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key < a[mid]) lo = mid + 1;
            else  return mid;
        }
        return  -1;
    }

    public static void main(String[] args)
    {
        int[] whitelist = new int[args.length];
        for (int i = 0; i < args.length; i++){
            whitelist[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(whitelist);

          // 读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.println(key);

    }
}
