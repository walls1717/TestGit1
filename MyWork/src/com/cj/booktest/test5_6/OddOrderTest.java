package com.cj.booktest.test5_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author CJ
 */
public class OddOrderTest {
    public static void main(String[] args) {
        int[][] arr = oddOrder();
        System.out.println("奇数阶幻方：");
        for(int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("对角线相加为：" + diagonalOdds(arr));
    }

    public static int[][] oddOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入～");
        //由键盘输入一个奇数
        int n = sc.nextInt();
        //判断输入的数字是否是奇数
        boolean isOdd = n % 2 == 0;
        if (isOdd) {
            System.out.println("请输入奇数");
            return null;
        }
        //创建一个n行n列的数组
        int[][] array = new int[n][n];
        //获取最后一行的行下标
        int a = n - 1;
        //获取中间列的列下标
        int b = n / 2;
        for (int i = 1; i <= n * n; i++) {
            //给最后一行的中间的元素赋值为1
            array[a++][b++] = i;
            //判断当前i的值是否是n的倍数
            if (i % n == 0) {
                //如果是则放在上行同列的位置上
                a = a - 2;
                b = b - 1;
                //否则放在下一行的下一列(右下方)
            } else {
                a = a % n;
                b = b % n;
            }
        }
        return array;
    }

    public static int diagonalOdds(int[][] array) {
        int row = array.length - 1;
        int column = array.length - 1;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result + array[row][column];
            row -= 1;
            column -= 1;
        }

        row = 0;
        column = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (row == array.length / 2 && column == array.length / 2) {
                row += 1;
                column -= 1;
            } else {
                result = result + array[row][column];
                row += 1;
                column -= 1;
            }
        }
        return result;
    }
}
