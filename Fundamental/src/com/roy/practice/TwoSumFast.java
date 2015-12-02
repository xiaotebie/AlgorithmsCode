package com.roy.practice;

/**
 * <h1>1.4.15<h1/>
 * 计算已排序的数组中和为0的整数对的数量
 * <br>
 *     解决方法为采用两边夹逼的方式
 * <br>
 *     Created by Roy on 2015/12/2 0002.
 */
public class TwoSumFast {

    /**
     * 计算两个数字等于0 的情况
     * @param range 数组
     * @return 个数
     */
    public static int twoSumCount(int[] range){
        // 选取数组的第一个和最后一个元素，分别为最小和最大值
        int first = 0;
        int last  = range.length - 1;

        int count = 0;
        while (first < last){
            // 比较数组两头的数据是否能得到合为0的数字
            if (!addOK(range[first], range[last])){
                continue;
            }
            // 和不为0时，左边标志位右移一位
            if (range[first] + range[last] < 0) {
                first++;
            }
            // 和大于0时，右边标志位左移一位
            else if (range[first] + range[last] > 0){
                last--;
            }
            // 和等于
            else {
                int k = first + 1;
                while (k <= last && range[first] == range[k])
                    k++;
                int k2 = last -1;
                while (k2 >= first && range[last] == range[k2])
                    k2--;
                count += (k-first)*(last-k2);
                first = k;
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

    public static void main(String[] args){
        int[] range = new int[] {-2,-1,-1,1,2,2,4};
        System.out.print(twoSumCount(range));
    }
}
