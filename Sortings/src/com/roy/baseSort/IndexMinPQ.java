package com.roy.baseSort;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 关联索引的泛型优先队列的API
 * Created by ROY on 2015/12/30 0030.
 */
public class IndexMinPQ<Item extends Comparable<Item>> {

    private int maxN;
    private int N;
    private int[] pq;
    private int[] qp;
    private Item[] keys;

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int maxN){
        this.maxN = maxN;
        keys = (Item[])new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    /**
     * 插入一个元素，将它和索引K相关联
     * @param k 索引
     * @param item 插入的元素
     */
    public void insert(int k, Item item){
        if (k < 0 || k >= maxN) throw new IndexOutOfBoundsException();
        if (contains(k)) throw new IllegalArgumentException("index is already in the priority queue");
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = item;
        swim(N);
        Object[] a = {};
        Arrays.sort(a);
    }

    /**
     * 将索引为k的元素设为item
     * @param k 索引
     * @param item 元素
     */
    public void change(int k, Item item){
        changeKey(k,item);
    }


    public void changeKey(int i, Item key) {
        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    /**
     * 是否存在索引为k的元素
     * @param k 索引
     * @return 是否存在
     */
    public boolean contains(int k) {
        if (k < 0 || k >= maxN) throw  new IndexOutOfBoundsException();
        return qp[k] != -1;
    }

    /**
     * 删除索引k 及其相关联的元素
     * @param k 索引
     */
    public void delete(int k) {
        if (k < 0 || k >= maxN) throw  new IndexOutOfBoundsException();
        if (!contains(k)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    /**
     * 返回最小元素
     * @return 最小元素
     */
    public Item min() {
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    /**
     * 最小元素的索引
     * @return 索引
     */
    public int minIndex() {
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * 删除最小元素并返回它的索引
     * @return 最小元素的索引
     */
    public int delMin() {
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, N--);
        sink(1);
        qp[min] = -1;
        keys[pq[N+1]] = null;
        pq[N+1] = -1;
        return min;
    }

    /**
     * 优先队列是否是空
     * @return 队列是否是空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 优先队列中的元素数量
     * @return 队列中的元素数量
     */
    public int size() {
        return N;
    }

    /***************************************************************************
     * General helper functions.
     ***************************************************************************/
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


    /***************************************************************************
     * Heap helper functions.
     ***************************************************************************/
    private void swim(int k)  {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}