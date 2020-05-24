package com.cj.search;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, 1, 34, 1, 89}; //没有顺序的数组
        System.out.println(seqSarchAll(arr, 1));
    }

    /**
     * 这里我们实现的线性查找是找到一个就返回
     * @param arr 要查找的数组
     * @param value 要查找的数
     * @return 返回下标
     */
    private static int seqSearch(int[] arr, int value) {
        //线性查找是逐一比对，发现有相同的值时，就返回下标
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static List seqSarchAll(int[] arr, int value) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                list.add(i);
            }
        }
        return list;
    }
}
