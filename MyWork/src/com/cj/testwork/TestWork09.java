package com.cj.testwork;

/**
 * 打印 1-100 之间的数，如果这个数，要么是3，要么5的倍数，就忽略掉
 * @author CJ
 */

public class TestWork09 {
    public static void main(String[] args){
        int h = 0;
        for(int i = 1; i <= 100; i++){
            if (i % 3 == 0 || i % 5 == 0) {
                continue;
            }else{
                System.out.print(i+"\t");
                h++;
            }
            if (h == 5) {
                System.out.println();
                h = 0;
            }
        }
    }
}
