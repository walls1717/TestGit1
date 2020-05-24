package com.cj.booktest.test5_8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求出数组中最大最小值，平均值
 */
public class Work2 {
    public static void main(String[] args) {
        double[] arr = new double[5];
        Scanner scanner = new Scanner(System.in);
        double sc;
        System.out.println("Please enter 5 double number");
        for (int i = 0; i < arr.length; i++) {
            sc = scanner.nextDouble();
            arr[i] = sc;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(max(arr));
        System.out.println(min(arr));
        System.out.println(pri(arr));
    }

    private static double max(double[] arr) {
        double max = 0;
        for (int i = 0; i < 1; i++) {
            max = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
        }
        return max;
    }

    private static double min(double[] arr) {
        double min = 0;
        for(int i = 0; i < 1; i++) {
            min = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                }
            }
        }
        return min;
    }

    private static double pri(double[] arr) {
        double pri = 0;
        for(int i = 0; i < arr.length; i++) {
            pri += arr[i] / arr.length;
        }
        return pri;
    }
}
