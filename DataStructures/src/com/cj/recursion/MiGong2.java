package com.cj.recursion;

public class MiGong2 {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        //将最上面一行跟最下面一行设置为1：代表墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //将最左边与最右边设置为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //再设置两个墙
        map[3][1] = 1;
        map[3][2] = 1;

        path(map, 1, 1);
        for(int[] rows:map) {
            for(int temp:rows) {
                System.out.print(temp+" ");
            }
            System.out.println();
        }
    }

    public static boolean path(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (path(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (path(map, i, j + 1)) {
                    //向左走
                    return true;
                } else if (path(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (path(map, i, j - 1)) {
                    //向右走
                    return true;
                } else {
                    //走不通，思路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
