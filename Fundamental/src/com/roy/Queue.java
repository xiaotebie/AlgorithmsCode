package com.roy;

import java.util.Iterator;

/**
 * 先进先出队列
 * Created by Roy on 2015/11/9 0009.
 */
public class Queue<Item>{
    private Node first;
    private Node last;
    private int N;

    private class Node {   // 定义了节点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {   // 向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue()
    {   //从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
