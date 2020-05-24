package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 34, 265, 112, 3, 235, 5};

        //创建一个80000个的随机的一个数组
        /*int[] sort = new int[80000];
        for (int i = 0; i < sort.length; i++) {
            sort[i] = (int) (Math.random() * 800000000); //会生成[0，800000000)之间的随机数
        }
//        System.out.print("排序前");
//        System.out.println(Arrays.toString(sort));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + dateStr);

//        System.out.println("排序后");
        selectSort4(sort);
//        System.out.println(Arrays.toString(sort));
        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是：" + date2Str);

         */

        selectSort11(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 排序算法
     * 时间复杂度O(n^2)
     * 效率没有冒泡与选择高
     * @param sort 要排序的数组
     * @author CJ
     */
    private static void selectSort(int[] sort) {
        //用来交换
        int temp = 0;
        //大循环控制让每一个数都可以跟后面的数进行比较
        for (int i = 0; i < sort.length - 1; i++) {
            //内循环控制后面的所有数与前面的数比较
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[j] < sort[i]) {
                    temp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = temp;
                }
            }
//            System.out.printf("第%d次排序", i + 1);
//            System.out.println(Arrays.toString(sort));
        }
    }

    //选择排序时间复杂度O(n^2)
    private static void selectSort4(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min < arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.printf("第%d次排序", i + 1);
//            System.out.println(Arrays.toString(arr));
        }
    }

    private static void selectSort3(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            //用来存储下标
            int minIndex = i;
            //用来存储最小值
            int min = arr[i];
            for(int j = 1 + i; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.printf("第%d次排序", i + 1);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void selectSort2(int[] arr) {
        //在推导的过程中，我们发现了规律，因此可以使用for来解决
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = 1 + i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.printf("第%d轮后", i + 1);
            System.out.println(Arrays.toString(arr));
        }


        //使用逐步推导的方式
        //原始的数组：101，34，119，1
        //第一轮排序：1，34，119，101
        /*
        int minIndex = 0; //用来存储下标
        int min = arr[0]; //用来存储最小值，我们先假定它为第一个元素，但真实为多少还不知道
        for(int j = 0 + 1; j <arr.length; j++) {
            if(min > arr[j]) {
                //说明我们假定的最小值并不是最小
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }
        //将最小值，放在arr[0]，即交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }


        System.out.println("第一轮后");
        System.out.println(Arrays.toString(arr));

        //第二轮
        minIndex = 1; //用来存储下标
        min = arr[1]; //用来存储最小值，我们先假定它为第一个元素，但真实为多少还不知道
        for(int j = 1 + 1; j <arr.length; j++) {
            if(min > arr[j]) {
                //说明我们假定的最小值并不是最小
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }
        //将最小值，放在arr[0]，即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第二轮后");
        System.out.println(Arrays.toString(arr));

        //第三轮
        minIndex = 2; //用来存储下标
        min = arr[2]; //用来存储最小值，我们先假定它为第一个元素，但真实为多少还不知道
        for(int j = 2 + 1; j <arr.length; j++) {
            if(min > arr[j]) {
                //说明我们假定的最小值并不是最小
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }
        //将最小值，放在arr[0]，即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第三轮后");
        System.out.println(Arrays.toString(arr));

         */
    }

    private static void selectSort5(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    private static void selectSort6(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    private static void selectSort7(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    private static void selectSort8(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    private static void selectSort9(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    //2020/3/28
    private static void selectSort10(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    //2020/3/29
    private static void selectSort11(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
