package com.cj.booktest.test5_8;

import java.util.Arrays;

/**
 * 剔除数组中相同的元素并排序
 */
public class Work {
    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 23, 355, 233, 233, 23, 1};
        int[] arrTemp = sort(arr);
        System.out.println(Arrays.toString(arrTemp));
    }

    private static int[] sort(int[] arr) {
        Arrays.sort(arr);
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (temp == arr[j]) {
                    arr[j] = 0;
                }
            }
        }

        int[] arrTemp = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            if (temp != 0) {
                arrTemp[j++] = temp;
            }
        }
        return arrTemp;
    }
}
