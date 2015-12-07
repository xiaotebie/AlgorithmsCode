package com.roy.practice;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.5章的算法
 * Created by ROY on 2015/12/7 0007.
 */
public class UF {
    private int[] id;
    private int count;
    public UF(int N){
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        // 如果p和q已经在相同的分量之中，则不需要采取任何行动
        if (pID == qID) return;

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public int find2(int p) {
        // 找出分量的名称
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union2(int p, int q) {
        // 将p和q的根节点统一
        int pRoot = find2(p);
        int qRoot = find2(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }
    public static void main(String[] args){
        int N = StdIn.readInt();            // 读取触点数量
        UF uf = new UF(N);                  // 初始化N个分量
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();            // 读取整数对
            if (uf.connected(p,q)) continue;    // 如果已经连通则忽略
            uf.union(p,q);                      // 归并分量
            StdOut.println(p + "" + q);         // 打印连接
        }
        StdOut.println(uf.count() + "components");
    }
}
