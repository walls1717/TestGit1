package com.cj.sparsearray;

import java.io.*;

/**
 * 原始二维数组与稀疏数组之间的转化
 *
 * @author CJ
 */
public class SparseArray {

    public static void test02(int[][] chessArr, int[][] sparseArr, int sum) {
        //将稀疏数组写入磁盘，并保存为map.data
        FileWriter writer = null;
        try {
            writer = new FileWriter("map2.data");

            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(sparseArr[i][j]);
                }
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //将稀疏数组从磁盘中读取出来
        FileReader reader = null;
        //定义一个新的稀疏数组，用来存放将要读取的数据
        int[][] sparseArr2 = new int[sum + 1][3];
        //指针，用来读取数据
        int getNum = 0;
        try {
            reader = new FileReader("map.data");

            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < 3; j++) {
                    getNum = reader.read();
                    sparseArr2[i][j] = getNum;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //输出读取出来后的稀疏数组
        System.out.println();
        System.out.println("读取出来的稀疏数组为");
        for (int i = 0; i < sparseArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr2[i][0], sparseArr2[i][1], sparseArr2[i][2]);
        }
        System.out.println();

        //将读取出来的稀疏数组转化成原始的二维数组
        int[][] chessArr3 = new int[sparseArr2[0][0]][sparseArr2[0][1]];

        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr3[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        System.out.println();
        System.out.println("转化后的原始的二维数组");
        for (int[] row : chessArr3) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //创建一个原始的二维数组 11 * 11
        //0：表示没有棋子，1：表示黑子，2：表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到稀疏数组中（sparseArr）
        int count = 0; //用于记录时第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //将稀疏数组 --> 恢复成原始的二维数组
        /*
           1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int[11] [11]
           2.再读取稀疏数组后几行的数据，并赋给原始的二维数组即可
         */

        //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int[11] [11]
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.再读取稀疏数组后几行的数据(从稀疏数组第二行开始)，并赋给原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        test02(chessArr1, sparseArr, sum);
    }
}
