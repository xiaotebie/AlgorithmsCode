package com.roy.practice;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * 快速3-sum。平方级别的算法
 * Created by Roy on 2015/12/2 0002.
 */
public class ThreeSumFast {
    /**
     * 两个数组快速排序
     * @param a 数组
     * @param sum 局部和值
     * @param i 开始位置
     * @return 个数
     */
    public static int twoSumFaster(int[] a,int sum,int i)
    {
        // 选取数组的第一个和最后一个元素，分别为最小和最大值
        int first = i;
        int last  = a.length - 1;

        int count = 0;
        while (first < last){
            // 比较数组两头的数据是否能得到合为0的数字
            if (!addOK(a[first], a[last])){
                continue;
            }
            // 和不为0时，左边标志位右移一位
            if (a[first] + a[last] < sum) {
                first++;
            }
            // 和大于0时，右边标志位左移一位
            else if (a[first] + a[last] > sum){
                last--;
            }
            // 和等于
            else {
                int k1 = first + 1;
                while (k1 <= last && a[first] == a[k1])
                    k1++;
                int k2 = last -1;
                while (k2 >= first && a[last] == a[k2])
                    k2--;
                count += (k1-first)*(last-k2);
                first = k1;
                last = k2;
            }

        }
        return count;
    }

    /**
     * 相加是否溢出
     * @param x 相加值
     * @param y 相加值
     * @return 可否会产生溢出
     */
    public static boolean addOK(int x, int y) {
        int z = x + y;
        return !(x > 0 && y > 0 && z < 0) && !(x < 0 && y < 0 && z > 0);
    }

    /**
     * A+B+C=0   借鉴twoSumFaster.  B+C=-A便可  即令k=-A带入
     *
     */
    public static int threeSumFaster(int[] a)
    {
        int cnt=0;
        for(int i=0;i<a.length-1;i++)
        {
            int k=-a[i];
            cnt+=twoSumFaster(a, k, i+1);
        }
        return cnt;
    }

    public static void main(String[] args)
    {
        int[] a= new int[]{-2,-1,-1,1,2,2,4};
        Arrays.sort(a);
        StdOut.println(Arrays.toString(a));
        StdOut.println(threeSumFaster(a));
    }
}
