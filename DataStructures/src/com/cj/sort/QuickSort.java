package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
        int[] arr = {-9, 0, 0, 23, -567, 70};
//        int[] arr = {1, 3, 8, 2, 0};
        quickSort5(arr, 0, arr.length - 1);
        System.out.println("arr：" + Arrays.toString(arr));
    }

    //
    private static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用

        //while循环的目的是让比pivot值小的放到左边
        //比pivot值大的放到右边
        while (l < r) {
            //在pivot的左边一直找，找到一个>=pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到一个<=pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot的左右两边的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l] == pivot值相等，r--，向前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r] == pivot值相等，l++，向前移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //如果 l == r，必须l++，r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    private static void quickSort2(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;
        //中间值
        int pivot = arr[(left + right) / 2];
        //临时变量，用于交换
        int temp = 0;

        while (l < r) {
            //循环中间值左边的数，直到找到大于中间值的数
            while (arr[l] < pivot) {
                l += 1;
            }
            //循环中间值右边的数，直到找到小于中间值的数
            while (arr[r] > pivot) {
                r -= 1;
            }

            //如果l与r相等了，证明中间值左右两变都循环完毕，可以退出循环
            if (l >= r) {
                break;
            }

            //交换左右两变的数，使中间值的左边都是小于中间值的，左边都是大于中间值的
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort2(arr, left, r);
        }
        if (right > l) {
            quickSort2(arr, l, right);
        }
    }

    private static void quickSort3(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];

        while (l < r) {

            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }

            if (l == r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < l) {
            quickSort3(arr, left, r);
        }
        if (right > r) {
            quickSort3(arr, l, right);
        }
    }

    //2020/3/28
    private static void quickSort4(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivod = arr[(left + right) / 2];

        while (l < r) {
            if (arr[l] < pivod) {
                l++;
            }
            if (arr[r] > pivod) {
                r--;
            }

            if (l == r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivod) {
                r--;
            }
            if (arr[r] == pivod) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }
        if (l > left) {
            quickSort4(arr, left, r);
        }
        if (r < right) {
            quickSort4(arr, l, right);
        }
    }

    //2020/3/29
    private static void quickSort5(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];

        while (l < r) {

            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }

            if (l == r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (l > left) {
            quickSort5(arr, left, r);
        }
        if (r < right) {
            quickSort5(arr, l, right);
        }
    }
}
