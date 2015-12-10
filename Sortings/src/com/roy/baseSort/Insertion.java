package com.roy.baseSort;

import com.roy.Example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 * Created by Roy on 2015/12/9 0009.
 */
public class Insertion extends Example{

    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            for (int j = i ; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j-1);
        }
    }

    public static void main(String[] args){
        // 从标准输入读取字符串，将它们排序输出
        Integer[] a = new Integer[] {1, 3, 2,29,11, 24 };
        sort(a);
        assert isSorted(a);
        show(a);
    }
//    public static void main(String[] args) {
//        List<> list= Arrays.asList(new int[]{1,2});
//        List<Integer>list2=new ArrayList<Integer>();
//        list2.add(1);
//        list2.add(2);
//        System.out.println(list);
//        System.out.println(list2);
//    }
}
