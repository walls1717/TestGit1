package com.cj.stack;

public class Calculator {
    public static void main(String[] args) {
        //根据前面老师思路，完成表达式的运算
        String expression = "700+2*6-4";
        //创建两个栈，数栈，符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        //定义需要的相关变量
        int index = 0; //用于扫描
        int num1 = 0; //存放要计算的数
        int num2 = 0; //存放要计算的数
        int oper = 0; //存放运算符
        int res = 0; //存放结果
        char ch = ' '; //将每次扫描得到的char保存到ch中
        String keepNum = ""; //用于拼接多位数
        //开始用while循环的扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做出相应的处理
            if (operStack.isOper(ch)) { //如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的运算符
                    //就需要从数栈中pop出两个数，再从符号栈中pop出一个符号，进行运算，将的到结果，
                    //入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //把当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈。
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else {//如果是数，则直接入数栈
                //分析思路
                //1.当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2.在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                //3.因此我们需要定义一个字符串变量，用于拼接

                //处理多位数
                keepNum += ch;
                //如果ch已经是expression的最后一位就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果运算符则入栈
                    //注意是看后面一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的！！！，keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index + 1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行。
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字[结果]
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res); //入栈
        }
        //将数栈的最后数，pop出来，就是结果
        System.out.printf("表达式%s = %d", expression, numStack.pop());
    }
}