package com.cj.recursion;

public class Queen {
    //总共几个皇后
    final int MAX = 8;
    //用来存放正确的结果
    int[] res = new int[MAX];
    //用来统计总共多少种方法
    static int count = 0;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.printf("总共有%d种解法", count);
    }

    //放置第n个皇后
    private void check(int n) {
        if (n == MAX) {
            print();
            return;
        }

        for (int i = 0; i < MAX; i++) {
            res[n] = i;
            if (way(n)) {
                check(n + 1);
            }
        }
    }

    //判断皇后的位置是否正确
    private boolean way(int n) {
        for (int i = 0; i < n; i++) {
            if (res[n] == res[i] || Math.abs(n - i) == Math.abs(res[n] - res[i])) {
                return false;
            }
        }
        return true;
    }

    //打印出结果
    private void print() {
        count++;
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
