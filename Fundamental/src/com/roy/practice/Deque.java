package com.roy.practice;

import sun.misc.GC;

/**
 * 一个双向队列,同时支持在两端添加或删除元素<br>
 *     使用双向链表
 * Created by ROY on 2015/11/10 0010.
 */
public class Deque<Item> {

    /**
     * 定义栈顶元素
     */
    private Node first;

    /**
     * 定义栈底元素
     */
    private Node last;

    private int N;

    private class Node {
        Item item;
        Node before;
        Node next;
    }
    public Deque(){
        first   = null;
        last    = null;
        N       = 0;
    }

    public boolean isEmpty() {
       return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 向左端添加一个新元素
     * @param item 元素
     */
    public void pushLeft(Item item) {
        Node old        = first;
        first           = new Node();
        first.item      = item;
        first.before    = null;
        first.next      = old;
        N++;
    }

    /**
     * 向右端添加一个新元素
     * @param item 元素
     */
    public void pushRight(Item item) {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        old.next = last;
    }

    /**
     * 从左端删除一个元素
     */
    public void popLeft() {
        first = first.next;
        first.before = null;
    }

    /**
     * 从右端删除一个元素
     */
    public void popRight(){
        last = last.before;
        last.next = null;
    }
}
