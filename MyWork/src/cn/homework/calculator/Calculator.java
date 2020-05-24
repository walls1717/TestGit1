package cn.homework.calculator;

public class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1 = (int)(Math.random()*99) + 1;
    }

    public int getNum2() {
        return num2 = (int)(Math.random()*99) + 1;
    }

    public int result() {
        return num1 + num2;
    }
}
