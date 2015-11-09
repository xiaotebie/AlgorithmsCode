package com.roy.practice;

import com.roy.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * <h1>算法习题1.3.4</h1>
 * 从标准输入中读取一个文本流使用栈判定其中的符号是否配对完整。<br/>
 * 例如：[()]{}{[()()]()}打印True,[(])则打印false
 * Created by ADMINISTRATOR on 2015/11/9 0009.
 */
public class Parentheses
{
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN)   stack.push(LEFT_PAREN);
            if (s.charAt(i) == LEFT_BRACE)   stack.push(LEFT_BRACE);
            if (s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_PAREN) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_BRACE) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty())             return false;
                if (stack.pop() != LEFT_BRACKET) return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "[(()])()";
        StdOut.println(isBalanced(s));
    }
}
