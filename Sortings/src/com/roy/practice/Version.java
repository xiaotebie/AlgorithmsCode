package com.roy.practice;

import edu.princeton.cs.algs4.StdOut;

import javax.print.DocFlavor;

/**
 * 版本，例如115.1.1、115.10.1,115.10.2
 * Created by ADMINISTRATOR on 2016/1/5 0005.
 */
public class Version implements Comparable {

    private String mVersion = null;
    private int[] mVerParts = null;

    public Version(String version) {
        this.mVersion = version;
        String[] vers = version.split("\\.");
        mVerParts = new int[vers.length];
        int i = 0;
        for (String partVer : vers) {
            int verInt = Integer.parseInt(partVer);
            mVerParts[i++] = verInt;
        }
    }

    @Override
    public int compareTo(Object o) {
        Version compared = (Version) o;
        int k = 0;
        int len = Math.min(this.mVerParts.length, compared.mVerParts.length);
        while (k < len) {
            if (this.mVerParts[k] > compared.mVerParts[k])
                return 1;
            else if (this.mVerParts[k] < compared.mVerParts[k])
                return -1;
            k++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Version version1 = new Version("115.1.1");
        Version version2 = new Version("115.10.1");
        Version version3 = new Version("115.10.2");
        StdOut.print("115.1.1 Compare to 115.10.1 is ");
        StdOut.println(version2.compareTo(version2));
        StdOut.print("115.1.1 Compare to 115.10.2 is ");
        StdOut.println(version3.compareTo(version1));
    }

}
