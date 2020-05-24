package cn.cj.test.arrays;

import java.util.Arrays;

/**
 * 测试冒泡排序
 *
 * @author CJ
 */

public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {1, 345, 5634, 345, 6453, 432, 24, 53, 2345};
        bubbleSort(values);//调用冒泡排序方法

    }

    //冒泡排序的方法
    public static void bubbleSort(int[] values) {
        int temp = 0;//用来临时储存将要交换的数
        for (int i = 0; i < values.length - 1; i++) {//外部循环，有n个数需要排序，则总共循环n-1此
            boolean flag = true;//用来判断排序是否完成，完成直接结束循环
            for (int j = 0; j < values.length - 1 - i; j++) {//每一趟循环都从数组的前两个元素开始比较，直到将大的数排到最后

                //比较大小换顺序
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;

                    flag = false;//每次循环之后将boolean变为false
                }
            }
            //判断排序是否完成，因为每次交换顺序都会将boolean变为false，当boolean没有再变为false一直为真的时候，表明交换已经结束，排序完成
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(values));//循环体完成，打印排序后的结果
    }
}
