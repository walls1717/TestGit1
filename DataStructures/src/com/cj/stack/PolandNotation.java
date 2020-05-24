package com.cj.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //完成将一个种中缀表达式转成后缀表达式的功能
        //1.说明1+((2+3)*4)-5 -> 1 2 3 + 4 * + 5 -
        //2.因为直接对字符串进行操作，不方便，因此，先将1+((2+3)*4)-5 -> 中缀表达式对应的List
        //即1+((2+3)*4)-5 -> ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        //3.将得到的中缀表达式对应的List -> 后缀表达式对应的List
        //即ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] -> ArrayList [1, 2, 3, +, 4, *, +, 5, -]

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List：" + infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List：" + parseSuffixExpressionList);

        System.out.printf("expression：%d", calculate(parseSuffixExpressionList));




        /*
        //先定义一个逆波兰表达式
        //(30+4)*5-6 -> 30 4 + 5 * 6 -
        //测试 30 4 + 5 * 6 -
        //测试 4 * 5 - 8 + 60 + 8 / 2 -> 4 5 * 8 - 60 + 8 2 / +
        //说明：为了方便，逆波兰表达式的数字和符号用空格隔开
        String suffixExpression ="4 5 * 8 - 60 + 8 2 / +";
        //思路
        //1.先将3 4 + 5 * 6 - 放到一个ArrayList中
        //2.将ArrayList传给一个方法，遍历ArrayList配合栈完成计算

        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList" + list);

        int res = calculate(list);
        System.out.println("计算的结果是：" + res);
        */
    }

    //即ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] -> ArrayList [1, 2, 3, +, 4, *, +, 5, -]
    //将得到的中缀表达式对应的List -> 后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>(); //符号栈
        //说明：因为s2这个栈，在整个转换过程中没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们不用Stack，直接使用List<String> s2
        //Stack<String> s2 = new Stack<String>(); //存储中间结果的栈
        List<String> s2 = new ArrayList<String>(); //存储中间结果的List

        //遍历ls
        for(String item:ls) {
            //如果是一个数，加入s2
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); //!!!!将（弹出s1栈，消除小括号
            } else {
                //当item的优先级小于或者是等于栈顶运算符的优先级，将s1栈顶的运算符弹出并压入到s2中
                //再次转到与s1中新的栈顶运算符进行比较
                //问题，缺少一个比较优先级高低的算法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2; //因为是存放到List，因此按顺序输出就是对应的后缀表达式对应的List
    }

    //将中缀表达式转成对应的List
    //s:1+((2+3)*4)-5
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这是一个指针，用于遍历中缀表达式字符串
        String str; //用来做对多位数的拼接工作
        char c; //每遍历一个字符，就放入c
        do {
            //如果c是一个非数字，我需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数字，需要考虑多位数的问题
                str = ""; //先将str置成“”
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while(i < s.length());
        return ls; //返回
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele:split) {
            list.add(ele);
        }
        return list;
    }
    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        //遍历list
        for(String item:ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}

//可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回对应的优先级数字
    public static int getValue(String operation) {
        int result =0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }
}
