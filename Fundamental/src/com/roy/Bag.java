package com.roy;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 背包
 *
 * Created by Roy on 2015/11/9 0009.
 */
public class Bag<Item> implements Iterable<Item>
{
    private Node first;
    private class Node
    {
        Item item;
        Node next;
    }
    public void add(Item item)
    {   // 和Stack的push()方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove()     { }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
