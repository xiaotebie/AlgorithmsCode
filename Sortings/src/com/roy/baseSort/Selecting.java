package com.roy.baseSort;

import com.roy.Example;

/**
 * 选择排序算法<br>
 * 1、找到数组中最小的那个元素<br>
 * 2、将它和数组的第一个元素交换位置<br>
 * 3、在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置,如此往复，直到将整个数组排序 <br>
 * Created by Roy on 2015/12/9 0009.
 */
public class Selecting extends Example{

    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if(less(a[j], a[min])) min = j;
            exch(a,i,min);
        }
    }

    public static void main(String[] args){
        // 从标准输入读取字符串，将它们排序输出
        Integer[] a = new Integer[] {1, 3, 2,29,11, 24 };
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
