package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        /*int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间为：" + dataStr);

        insertSort10(arr);

        Date date2 = new Date();
        String dat2Str2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间为：" + dat2Str2);

         */



        insertSort14(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    private static void insertSort(int[] arr) {
        //逐步推导
        //第一步101, 34, 119, 1 -> 34, 101, 119, 1

        //定义待插入的数
//        int insertVal = arr[1];
        //即arr[1]的前面这个数的下标
//        int insertIndex = 1 - 1;

        //给insertVal找到插入的位置
        //说明
        //1.insertIndex >= 0 保证给insertVal找插入位置的时候，不越界
        //2.insertVal < arr[insertIndex]：待插入的数还没找到适当的位置
        //3.就需要将arr[insertIndext]后移
        /*while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex + 1
        arr[insertIndex + 1] = insertVal;

        System.out.print("第一轮后");
        System.out.println(Arrays.toString(arr));
        */

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;

            System.out.printf("第%d轮后", i);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void insertSort2(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //用来存储需要插入的元素
            insertVal = arr[i];
            //用来记录下标：需要插入的元素的前一个元素的下标
            insertIndex = i - 1;
            //如果下标不为负数的时候和需要插入的元素比前一个元素小的时候进入循环
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //将元素后移，给需要插入的元素腾出地方
                arr[insertIndex + 1] = arr[insertIndex];
                //向前移动
                insertIndex--;
            }
            //退出while循环时，表示已经找到了要插入的位置，并插入
            //这里我们判断是否需要赋值
            if (insertIndex + 1 == i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort3(int[] arr) {
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort4(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort5(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort6(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort7(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort8(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort9(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    private static void insertSort10(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            for(; insertIndex >= 0 && insertVal < arr[insertIndex]; insertIndex--) {
                arr[insertIndex + 1] = arr[insertIndex];
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    //2020.3.26
    private static void insertSort11(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    //2020.3.27
    private static void insertSort12(int[] arr) {
        //用于存放将要插入的数
        int insertVal = 0;
        //用于表示被插入数的下标
        int insertIndex = 0;

        //从下标为1的开始循环，因为我们要将下标为0的数作为新数组进行插入
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            //insertIndex向前移动，直到小于等于零的时候，说明遍历完毕
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    //2020/3/28
    private static void insertSort13(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    //2020/3/29
    private static void insertSort14(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
