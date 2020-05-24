package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    private static void radixSort(int[] arr) {
        //定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        //说明：
        //1.二维数组包含十个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小为arr.length
        //3.明显，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来纪录各个桶每次放入的数据个数
        //可以这样理解：
        //比如：bucketElementCounts[0]，记录的就是bucket[0]桶的放入的数据个数
        int[] bucketElementCounts = new int[10];

        //第1轮排序(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitOfElement = arr[j] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
        int index = 0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，我们才放入到原数组中
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素，放入到arr中
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后，需要将每个bucketElementCounts[k] = 0;!!!
            bucketElementCounts[k] = 0;
        }
        System.out.println("第1轮对个位的排序处理：" + Arrays.toString(arr));


        //第2轮排序(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的十位
            int digitOfElement = arr[j] / 10 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
        index = 0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，我们才放入到原数组中
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素，放入到arr中
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第2轮对个位的排序处理：" + Arrays.toString(arr));

        //第3轮排序(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的百位
            int digitOfElement = arr[j] / 100 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
        index = 0;
        //遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，我们才放入到原数组中
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素，放入到arr中
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第3轮对个位的排序处理：" + Arrays.toString(arr));
    }

    //2020/3/27
    private static void radixSort2(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        //1.得到数组中最大的数的位数
        int max = arr[0]; //假设第一个数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数的位数
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素对应的位数
                int digitOfElement = arr[j] / n % 10;

                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组中
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素，放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后，需要将每个bucketElementCounts[k] = 0;!!!
                bucketElementCounts[k] = 0;
            }
//            System.out.println("第" + (i + 1) + "轮对个位的排序处理：" + Arrays.toString(arr));
        }
    }
}
