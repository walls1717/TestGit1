package cn.homework.calculator;

import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        int j = 0;
        int i = 0;
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();
        for(i = 0;i < 6; i++) {
            System.out.print(calculator.getNum1() + " + " + calculator.getNum2() + " = ");
            int sc = scanner.nextInt();
            if(sc == calculator.result()) {
                System.out.println("答对了");
                j++;
            } else {
                System.out.println("答错了");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("共用时：" + (end - start)/1000 + "秒");
        System.out.println("共有：" + i + "道题");
        System.out.println("答对了" + j + "道题");
    }
}
