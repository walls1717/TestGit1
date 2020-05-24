package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort7(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后：" + Arrays.toString(arr));
    }

    //分+合方法
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);
        }
    }

    private static void mergeSort2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归
            mergeSort2(arr, left, mid, temp);
            //向右递归
            mergeSort2(arr, mid + 1, right, temp);
            //合并
            merge2(arr, left, mid, right, temp);
        }
    }

    private static void mergeSort3(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort3(arr, left, mid, temp);
            mergeSort3(arr, mid + 1, right, temp);
            merge3(arr, left, mid, right, temp);
        }
    }

    //2020/3/27
    private static void mergeSort4(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort4(arr, left, mid, temp);
            mergeSort4(arr, mid + 1, right, temp);
            merge4(arr, left, mid, right, temp);
        }
    }

    //2020/3/28
    private static void mergeSort5(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort5(arr, left, mid, temp);
            mergeSort5(arr, mid + 1, right, temp);
            merge5(arr, left, mid, right, temp);
        }
    }

    private static void mergeSort6(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort6(arr, left, mid, temp);
            mergeSort6(arr, mid + 1, right, temp);
            merge6(arr, left, mid, right, temp);
        }
    }

    //2020/3/29
    private static void mergeSort7(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort7(arr, left, mid, temp);
            mergeSort7(arr, mid + 1, right, temp);
            merge7(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   需要排序的数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组，做中转
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println("xxxx");
        int i = left; //初始化i，左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引

        //（一）
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) { //继续
            //如果左边的有序序列的当前一个数，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之，将右边有序序列的当前元素填充到temp种
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //（二）
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充的temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充的temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //（三）
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left; //
        //第一次合并时 tempLeft = 0; right = 1; //tempLeft = 2, right = 3; //tempLeft = 0, right = 3
        //最后一次 tempLeft = 0; right = 7;
        System.out.println("tempLeft:" + tempLeft + " right:" + right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    private static void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        //作为第一个数组的左起始点
        int i = left;
        //作为第二个数组的左起始点
        int j = mid + 1;
        //临时数组的指针
        int t = 0;

        while (i <= mid && j <= right) {
            //如果左边的数大，就放入临时数组，否则相反
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //如果左边的数还没有循环完毕，就将剩余的数放入临时数组
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        //如果右边的数还没有循环完毕，就将剩余的数放入临时数组
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //将临时数组中的数重新放回原始数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    private static void merge3(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    //2020/3/27
    private static void merge4(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    //2020/3/28
    private static void merge5(int[] arr, int left, int mid, int right, int[] temp) {
        //左边的初始索引
        int i = left;
        //右边的初始索引
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    private static void merge6(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    //2020/3/29
    private static void merge7(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while(j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
