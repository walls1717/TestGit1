package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 3, 10, 9};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));

        //测试冒泡排序的速度O(n^2)，给80000个数据测试一下
        //创建一个80000个的随机的一个数组
        /*int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 800000000); //会生成[0，800000000)之间的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + dateStr);

        bubble(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是：" + date2Str);

         */

        bubble14(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubble(int[] arr) {
        //为了容易理解，我们把冒泡排序的演变过程展示出来
        //冒泡排序的时间复杂度O(n^2)
        int temp = 0; //临时变量，用来做交换
        boolean flag = true; //标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，就交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
//            System.out.printf("第%d趟排序后的数组：", i + 1);
//            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }

        /*
        //第二趟排序，就是将第二大的数排在倒数第二位
        for(int j = 0; j < arr.length - 1 - 1; j++) {
            //如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第二趟排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第三趟排序，就是将第二大的数排在倒数第三位
        for(int j = 0; j < arr.length - 1 - 2; j++) {
            //如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第三趟排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //第四趟排序，就是将第二大的数排在倒数第四位
        for(int j = 0; j < arr.length - 1 - 3; j++) {
            //如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第四趟排序后的数组：");
        System.out.println(Arrays.toString(arr));
         */
    }

    public static void bubble2(int[] arr) {
        int temp = 0;
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
            System.out.printf("第%d趟排序后的数组：", i + 1);
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble3(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble4(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble5(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble6(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble7(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble8(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble9(int[] arr) {
        int temp = 0;
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

            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble10(int[] arr) {
        int temp = 0;
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
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void bubble11(int[] arr) {
        int temp = 0;
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    //2020.3.26
    private static void bubble12(int[] arr) {
        int temp = 0;
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    //2020.3.27
    private static void bubble13(int[] arr) {
        //用于交换的临时变量
        int temp = 0;
        //用于表示是否结束循环，标记是否完成排序
        boolean flag = true;

        //外循环：控制循环数组中每一个数，
        //i < arr.length - 1是因为当前面所有的数都排好位置，
        //剩下的一个数自然就在应该在的位置了
        for(int i = 0; i < arr.length - 1; i++) {
            //内循环：控制比较数组中相邻的两个数，进行交换位置，将大的数移到后面
            //j < arr.length - 1是因为已经循环了几次，已经将几个较大的数移到了后面
            //就没有必要再比较后面已经排好序的数了
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //每次交换完就将标志置为false
                    flag = false;
                }
            }
            //如果标志为true表示没有发生一次交换，则数组排序完毕
            if (flag) {
                break;
                //否则，就将flag重新置为true，确保下次正确判断
            } else {
                flag = true;
            }
        }
    }

    //2020/3/29
    private static void bubble14(int[] arr) {
        int temp = 0;
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }
}
