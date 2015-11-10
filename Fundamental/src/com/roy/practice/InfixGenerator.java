package com.roy.practice;

import com.roy.Stack;

/**
 * <h1>算法习题1.3.9</h1>
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。<br>
 * 例如 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) <br>
 * 输出 ((1 + 2) * (3 - 4) * ( 5 - 6) ) ) <br>
 * Created by ADMINISTRATOR on 2015/11/9 0009.
 */
public class InfixGenerator {

    private static final String RIGHT_BRACKET = ")";
    private static final String LEFT_BRACKET = "(";
    static Stack<String> operatorStack = new Stack<>();
    static Stack<String> numberStack = new Stack<>();
    static StringBuilder outExp = new StringBuilder();
    /**
     * 补全表达式
     * @param in 未完成的表达式
     * @return 完成的表达式
     */
    static String completeExp(String in){
        for (int i = 0; i < in.length(); i++)
        {
            // 字符为数字
            if (in.charAt(i) >= 48 && in.charAt(i) <= 57) {
                numberStack.push(in.charAt(i) + "");
            }
            // 字符为运算符
            else if (in.charAt(i) == '+' || in.charAt(i) == '*' || in.charAt(i) == '-' || in.charAt(i) == '/'){
                operatorStack.push(in.charAt(i) + "");
            }
            // 遇到右括号时，将操作数出栈
            else if (in.charAt(i) == ')'){
                String last = numberStack.pop();
                String oper = operatorStack.pop();
                String first = numberStack.pop();
                numberStack.push(LEFT_BRACKET + first + oper + last + RIGHT_BRACKET);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!numberStack.isEmpty()) {
            builder.append(numberStack.pop());
        }
        return  builder.toString();
    }

    public static void main(String[] args){
        String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        System.out.println(completeExp(expression.trim()));
    }

}
