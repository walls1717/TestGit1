package com.cj.stack;

//定义一个类表示栈结构
class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据就放在该数组中
    private int top = -1; //top表示栈顶，初始化为-1：表示没有数据

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //可以返回当前栈定的值，但是不是真正出栈
    public int peek() {
        return stack[top];
    }

    //返回运算符的优先级，优先级是程序员来确定的，优先级使用数字来表示
    //数字越大则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; //假定目前的计算表达式只有+ - * /
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char value) {
        return value == '+' || value == '-' || value == '/' || value == '*';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; //用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意顺序
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈-pop，将栈顶的数据返回
    public int pop() {
        //先判断是否为空
        if (isEmpty()) {
            //抛出异常处理
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况[遍历栈]，遍历时，需要从栈定开始显示
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for(int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
}
