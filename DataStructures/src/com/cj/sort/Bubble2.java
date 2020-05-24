package com.cj.sort;

import java.util.Arrays;

public class Bubble2 {
    private void bubb2(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 56, 134, 42, 32, 1};
        Bubble2 bubble2 = new Bubble2();
        bubble2.bubb2(arr);
    }
}
