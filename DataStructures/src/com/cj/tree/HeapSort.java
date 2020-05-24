package com.cj.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排列
//        int[] arr = {4, 6, 8, 5 ,9, 1, -1 ,0, 34, 2345};
        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = dateFormat1.format(date1);
        System.out.println("执行前的时间为：" + dateStr1);
        heapSort(arr);
        Date date2 = new Date();
        String dateStr2 = dateFormat1.format(date2);
        System.out.println("执行后的时间为：" + dateStr2);
    }

    //堆排序方法
    public static void heapSort(int[] arr) {
        int temp = 0;
//        System.out.println("堆排序");

        //分布完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第1次" + Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第2次" + Arrays.toString(arr));

        //最终代码
        //将无序序列构建成一个堆，根据升序降序需求许纳泽大顶堆或小顶堆
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        /*
        2.将堆顶元素于末尾元素交换，将最大元素“沉”到数组末端
        3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整 + 交换步骤，知道整个序列有序
         */
        for(int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
//        System.out.println("数组：" + Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树），调成一个大顶堆
     * 功能：完成将以i对应的非叶子节点的数调整成大顶堆
     *
     * @param arr 待调整的数组
     * @param i 表示非叶子节点再数组中的索引
     * @param length 表示对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; //先取出当前元素的值，保存在临时变量
        //开始调整
        //说明
        //1.k = i * 2 + 1表示的是i节点的左子节点
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { //说明左子节点他的值小于右子节点的值
                k++; //k指向右子节点
            }
            if (arr[k] > temp) { //如果子节点大于父节点
                arr[i] = arr[k]; //把较大的值赋给当前节点
                i = k; //i指向k，继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的数的最大值，放在了最顶（局部）
        arr[i] = temp; //将temp值放到调整后的位置
    }
}
