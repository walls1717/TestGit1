package cn.cj.test;

import java.util.Scanner;

/**
 * 测试枚举
 * @author CJ
 */

public class TestEnum {
    public static void main(String[] args){
        Season a = Season.AUTUMN;
        //枚举的遍历
        for(Week k:Week.values()){
            System.out.println(k);
        }

        switch(a){
            case SPRING:
                System.out.println("春天来了");
                break;
            case SUMMER:
                System.out.println("夏天来了");
                break;
            case AUTUMN:
                System.out.println("秋天来了");
                break;
            case WINTER:
                System.out.println("冬天来了");
                break;
        }
    }
}

enum Season{
    SPRING, SUMMER, AUTUMN, WINTER
}
enum Week{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
