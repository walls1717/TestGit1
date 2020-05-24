package com.cj.sort;

import java.util.Arrays;

public class Bubble {
    private void bubb(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
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
        int[] arr = {1, 345, 5634, 345, 6453, 432, 24, 53, 2345};
        Bubble bubble = new Bubble();
        bubble.bubb(arr);
    }
}
