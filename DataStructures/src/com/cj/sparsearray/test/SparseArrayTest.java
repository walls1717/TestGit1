package com.cj.sparsearray.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArrayTest {

    public static void PutAndOut(int[][] sparseArr, int sum) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("map3.data");
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
                if (null != writer) {
                    writer.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader reader = null;
        int[][] sparseArr2 = new int[sum+1][3];
        int getNum = 0;
        try {
            reader = new FileReader("map3.data");
            for(int i = 0; i < sparseArr.length; i++){
                for(int j = 0; j < 3; j++){
                    getNum = reader.read();
                    sparseArr2[i][j] = getNum;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int[][] chessArr = new int[sparseArr2[0][0]][sparseArr2[0][1]];

        for(int i = 1; i < sparseArr2.length; i++){
            chessArr[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        for(int[] row:chessArr){
            for(int data:row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[2][3] = 1; // 1代表黑子
        chessArr[4][2] = 2; // 2代表白子
        System.out.println(chessArr.length);

        //输出原始二维数组
        System.out.println("原始二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //遍历原始二维数组，并记录其中有几个有效的数据
        int sum = 0; //记录原始二维数组中的有效数据的个数
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历原始二维数组，将非0的有效数据给稀疏数组
        int count = 0; //用来记录是第几个有效数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        PutAndOut(sparseArr, sum);
    }
}
