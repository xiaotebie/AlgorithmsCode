package com.roy.practice;

/**
 * 给出一段代码，删除链表的尾节点，其中链表的首节点为first
 * Created by ADMINISTRATOR on 2015/11/10 0010.
 */
public class LinkedListPractice {

    static Node first = new Node();
    static Node second = new Node();
    static Node third = new Node();
    private static class Node {
        int value;
        Node next;
    }

    /**
     * 删除尾节点
     */
    public static void deleteLastNode(){
        for (Node x = first; x != null; x = x.next){
            if (x.next == null)
                break;
            if (x.next.next == null)
                x.next = null;
        }
    }

    /**
     * 删除链表的第k个元素
     * @param k 第k个元素
     */
    public static void delete(int k) {
        int i = 1;
        for (Node x = first; x != null; x = x.next, i++){
            if (i == k-1){
                x.next = x.next.next;
            }
        }
    }

    /**
     * 寻找一个链表中某个结点数值相同的
     * @param key 值
     * @return 是否有相同的
     */
    public static boolean find(int key){
        boolean result = false;
        for (Node x = first; x != null; x = x.next){
            if (x.value == key){
                result = true;
            }
        }
        return result;
    }

    /**
     * 删除该节点的后序节点
     */
    public static void removeAfter(Node node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    /**
     * 添加一个结点
     * @param one 第一个链表结点
     * @param two 第二个链表结点
     */
    public static void insertAfter(Node one, Node two) {
        if (one != null && two != null) {
            two.next = one.next;
            one.next = two;
        }
    }

    /**
     * 删除链表中所有item域为key的结点
     * @param x 链表
     * @param key 结点关键字
     */
    public static void remove(Node x, int key){
        for (; x != null; x = x.next){
            if (x.value == key) {
                x.value = x.next.value;
                x.next = x.next.next;
            }
        }
    }

    static int max = first.value;
    /**
     * 返回链表中键最大的结点的值(递归方式)
     * @return 最大结点的值，如果都为正整数，则返回0
     */
    public static Node max(Node x){

        if (x == null)
            throw new NullPointerException("Node is null");
        if (x.next == null)
            return x;
        if (x.value > x.next.value){
            x.next = x.next.next;
            return max(x);
        }
        else {
            return max(x.next);
        }
    }

    public static void main(String[] args) {
        first.value = 3;
        first.next = second;
        second.value = 7;
        second.next = third;
        third.value = 3;
        third.next = null;
        Node max = max(first);
        System.out.println(max.value);
    }
}
