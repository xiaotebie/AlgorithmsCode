package com.roy.baseSort;

import com.roy.Example;

/**
 * 优先队列<br>
 * 二叉堆，完全二叉树表示
 * Created by ROY on 2015/12/30 0030.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;           // 基于堆的完全二叉树
    private int N = 0;          // 存储于pq[1..N]中，pq[0] 没有使用

    public MaxPQ(){}

    /**
     * 创建一个初始容量为max的优先队列
     * @param max 最大值
     */
    @SuppressWarnings("unchecked")
    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    /**
     * 用a[] 中的元素创建一个优先队列
     * @param a
     */
    public MaxPQ(Key[] a) {}

    /**
     * 向优先队列中插入一个元素
     * @param k 元素
     */
    public void Insert(Key k){
        pq[++N] = k;
        swim(N);
    }

    /**
     * 返回最大值
     * @return 最大值
     */
    public Key max() {
        return pq[1];
    }

    /**
     * 删除最大元素并返回
     * @return 最大值
     */
    public Key delMax(){
        Key max = pq[1];        // 从根节点得到最大元素
        exch(1, N--);           // 将其和最后一个结点交换
        pq[N+1] = null;         // 防止对象游离
        sink(1);                // 恢复堆的有序性
        return max;
    }

    /**
     * 返回队列是否是空
     * @return 队列是否是空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 返回优先队列中的元素个数
     * @return 队列的元素总数
     */
    public int size() {
        return N;
    }

    /**
     * 堆中元素上浮
     * @param k 上浮元素
     */
    private void swim(int k){
        while (k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * 堆中元素下沉
     * @param k 下沉元素
     */
    private void sink(int k) {
        while (2 * k <= N){
            int i = 2 * k;
            if (i < N && less(i, i+1)) i++;
            if (!less(k,i)) break;
            exch(i, k);
            k = i;
        }
    }

    /**
     * 比较大小
     * @param i A元素
     * @param j B元素
     * @return A元素比B元素小返回True
     */
    private boolean less(int i, int j){
        return  pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换元素位置
     * @param i A元素
     * @param j B元素
     */
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
