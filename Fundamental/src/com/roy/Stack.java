package com.roy;

/**
 * 下压堆栈（链表实现）
 * Created by Roy on 2015/11/9 0009.
 */
public class Stack<Item>
{
    private Node first;
    private int N;

    private class Node
    {   // 定义了节点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null;}
    public int size()        { return N;}
    public void push(Item item)
    {   // 向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop()
    {   // 从栈顶删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
