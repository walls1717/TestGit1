package cn.cj.test.arrays;

import java.util.Arrays;

/**
 * 测试java.util.Arrays工具类的使用
 * @author CJ
 */

public class TestArrays {
    public static void main(String[] args){
        int[] a = {10, 324, 30, 3, 4562, 35, 356,2};
        System.out.println(Arrays.toString(a));//打印指定数组内容
        Arrays.sort(a);//将数组从大到小排序
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 30));//查找数组中的某个数并输出下标，如果没有就输出负数
    }
}
