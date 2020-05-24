package com.cj.recursion;

import java.sql.SQLOutput;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        int[][] map2 = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板，1表示
        map[3][1] = 1;
        map[3][2] = 1;


        for (int i = 0; i < 7; i++) {
            map2[0][i] = 1;
            map2[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map2[i][0] = 1;
            map2[i][6] = 1;
        }
        //设置挡板，1表示
        map2[3][1] = 1;
        map2[3][2] = 1;



//        map[1][2] = 1;
//        map[2][2] = 1;
        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay2(map, 1, 1);
        setWay(map2, 1, 1);
//        System.out.println("地图的情况");
//        for(int i = 0; i < 8; i++) {
//            for(int j = 0; j < 7; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        if (check(map) > check(map2)) {
            System.out.println(check(map));
        } else {
            System.out.println(check(map2));
        }
    }
    //使用递归回溯来给小球找路
    //说明：
    //1.map：表示地图
    //2.i，j：表示从地图的那个位置开始出发（1，1）
    //3.如果小球能到map[6][5]位置，则说明路找到
    //4.约定：当map[i][j]为0时，表示该点没有走过，当为1表示墙，2表示路，可以走；3表示该点已经走过，但是不能走
    //5.在走迷宫时，我们需要确定一个策略（方法）下->右->上->左，如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   从那个位置开始走
     * @param j
     * @return 如果找到路，就返回true，否则就返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点没有走过
                //按照策略走
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通，死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j]不等于0，可能是 1，2，3
                return false;
            }
        }
    }

    //修改找路的策略，改为 上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点没有走过
                //按照策略走
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay2(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通，死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j]不等于0，可能是 1，2，3
                return false;
            }
        }
    }

    public static int check(int[][] map) {
        int count = 0;
        for (int[] rows : map) {
            for (int temp : rows) {
                if (temp == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
