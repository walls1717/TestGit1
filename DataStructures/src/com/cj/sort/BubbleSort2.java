package com.cj.sort;

import java.util.Arrays;

public class BubbleSort2 {
    private static void bubble(int[] arr) {
        //用来交换
        int temp = 0;
        //标志排序是否结束
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }

            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[8];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 800000);
//        }
        int[] arr = {1, 34, 265, 112, 3, 235, 5};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        System.out.println("排序后");
        bubble(arr);
    }
}
