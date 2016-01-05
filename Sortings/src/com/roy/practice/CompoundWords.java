package com.roy.practice;

import com.roy.Example;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesHandlerImpl;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 2.5.2
 * 编写一段程序，从标准输入读入一列单词，并打印出其中所有由两个单词组成的组合词。<br>
 * 例如 如果输入单词为after、thought和afterthought，那么afterthought就是一个组合词
 * Created by Roy on 2016/1/4 0004.
 */
public class CompoundWords extends Example {

    static String[] wordList = null;

    public static void printCombinedWord(){
        int k = 0;
        int length = wordList.length;
        while (k < length - 1) {
            String word = wordList[k];
            int i = k + 1;
            int seclen = compareStr(wordList[i], word);
            while (seclen > 1) {
                int key = Arrays.binarySearch(wordList, wordList[i].substring(word.length()));
                if (key > 0) {
                    StdOut.print("组合词是：");
                    StdOut.println(wordList[i]);
                }
                seclen = compareStr(wordList[++i],word);
            }
            k++;
        }

    }

    public static int compareStr(String first, String second) {
        if (first == second) return 0;
        int n = Math.min(first.length(), second.length());
        for (int i = 0; i < n; i++){
            if (first.charAt(i) < second.charAt(i))         return -1;
            else if (first.charAt(i) < second.charAt(i))    return 1;
        }
        return first.length() - second.length();
    }

    public static void readWords(String... words){
        Arrays.sort(words);
        wordList = words;
        int k = 0;
        for (String word: words) {
            wordList[k++] = word;
            StdOut.print(word);
            StdOut.print(", ");
        }
    }

    public static void main(String[] args) {
        readWords(args);
        printCombinedWord();
    }
}
