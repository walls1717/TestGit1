package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        int[] arr = {8, 9, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = dateFormat1.format(date1);
        System.out.println("执行前的时间为：" + dateStr1);

        shellSort2(arr);
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String dateStr2 = dateFormat1.format(date2);
        System.out.println("执行后的时间为：" + dateStr2);
    }

    //对交换式的希尔排序进行优化 - > 移位法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    //使用逐步推导的方式编写希尔排序
    private static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //第一层循环：控制给数组分成几组，每次分成的组数是数组长度/2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //第二层循环：确定这几组数中后一个数的位置
            for (int i = gap; i < arr.length; i++) {
                //第三层循环：确定这几组数种第一个数的位置，并比较两个数的大小，交换位置
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "论排序：" + Arrays.toString(arr));
        }

        /*
        //希尔排序第一轮
        //思路：因为第一轮排序是将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明要交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮排序后：" + Arrays.toString(arr));

        //希尔排序第二轮
        //思路：因为第二轮排序是将10个数据分成了5/2 = 2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的那个元素，说明要交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序第二轮排序后：" + Arrays.toString(arr));

        //希尔排序第三轮
        //思路：因为第二轮排序是将10个数据分成了2/2 = 1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的那个元素，说明要交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第三轮排序后：" + Arrays.toString(arr));

         */
    }
}
