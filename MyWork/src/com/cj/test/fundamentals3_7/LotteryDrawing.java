package com.cj.test.fundamentals3_7;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String[] args) {
        //数组中有1-50个数
        Scanner in = new Scanner(System.in);
        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        int[] numbers = new int[n];
        //将1-50放入数组中
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        //用于存放抽取出来的结果
        int[] result = new int[k];
        //随机的从原始数组中抽取6个数然后存放到结果数组中
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }
}
