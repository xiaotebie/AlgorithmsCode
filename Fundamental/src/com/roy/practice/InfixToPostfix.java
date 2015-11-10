package com.roy.practice;

import com.roy.Stack;

/**
 * <h1>算法1.3.10</h1>
 * 将算术表达式由中序表达式转为后序表达式。<br>
 * 中序表达式 2*3/(2-1)+3*(4-1)<br>
 * 后序表达式 23*21-/341-*+<br>
 * Created by Roy on 2015/11/10 0010.
 */
public class InfixToPostfix {
    public static final char OPER_ADD = '+';
    public static final char OPER_DELETE = '-';
    public static final char OPER_MULTI = '*';
    public static final char OPER_DIVISION = '/';

    private static final char RIGHT_BRACKET = ')';

    /**
     * 运算符堆栈
     */
    public static Stack<Character> operatorStack = new Stack<>();
    /**
     * 中序表达式转化为后序表达式<br>
     * 中序转后序，
     * 从左到右扫描
     * 遇到操作数将操作数输出到序列中
     * 遇到运算符压入堆栈
     * 遇到右括号出栈。
     * @param exp 中序表达式
     * @return 后序表达式
     */
    public static String InfixToPost(String exp){
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < exp.length(); i++){
            // 操作数直接输出
            if (exp.charAt(i) >= 48 && exp.charAt(i) <= 57){
               postfix.append(exp.charAt(i));
            }
            else if (exp.charAt(i) == OPER_ADD || exp.charAt(i) == OPER_DELETE || exp.charAt(i) == OPER_MULTI || exp.charAt(i) == OPER_DIVISION){
                operatorStack.push(exp.charAt(i));
            }
            else if (exp.charAt(i) == RIGHT_BRACKET) {
                postfix.append(operatorStack.pop());
            }
        }
        // 查询堆栈中如果不为空，则将所有运算符出栈
        while (!operatorStack.isEmpty())
            postfix.append(operatorStack.pop());
        return postfix.toString();
    }

    public static void main(String[] args){
        String exp = "((2*3)/(2-1))+(3*(4-1))";
        System.out.println(InfixToPost(exp));
    }
}
