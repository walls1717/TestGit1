package cn.cj.test.arrays;

import java.util.Arrays;

/**
 * 测试数组存储表格数据
 * @author CJ
 */

public class TestArraysTableDate {
    public static void main(String[] args){
        Object[] emp1 = {1001, "CJ", 18, "学生", "2006.6.6"};
        Object[] emp2 = {1002, "JC", 19, "老师", "2006.6.7"};
        Object[] emp3 = {1003, "CCJ", 20, "程序员", "2006.6.8"};

        Object[][] tableDate = new Object[3][];
        tableDate[0] = emp1;
        tableDate[1] = emp2;
        tableDate[2] = emp3;

        for(Object[] temp:tableDate){
            System.out.println(Arrays.toString(temp));
        }
    }
}
