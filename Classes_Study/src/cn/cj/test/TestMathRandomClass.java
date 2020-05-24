package cn.cj.test;

import java.util.Random;

/**
 * 测试Math类常用方法/random类的常用方法
 * @author CJ
 */

public class TestMathRandomClass {
    public static void main(String[] args){
        //取整
        System.out.println(Math.ceil(3.4));//不管小数点后面是多少，直接进1
        System.out.println(Math.floor(3.4));//不管小数点后面是多少，直接去小数
        System.out.println(Math.round(3.4));//四舍五入
        System.out.println(Math.round(3.6));//四舍五入
        //绝对值，开方，a的b幂次方
        System.out.println(Math.abs(-59));//求绝对值
        System.out.println(Math.sqrt(64));//开平方
        System.out.println(Math.pow(5,2));//5的2次方
        System.out.println(Math.pow(2,45));//2的45次方
        //Math类中的常量
        System.out.println(Math.PI);//圆周率
        System.out.println(Math.E);//E常量
        //随机数
        System.out.println(Math.random());//[0,1)

        System.out.println("###################");

        Random rand = new Random();
        //随机生成[0,1)之间的double类型数据
        System.out.println(rand.nextDouble());
        //随机生成int类型允许范围内的整型类型
        System.out.println(rand.nextInt());
        //随机生成[0,1)之间的float类型数据
        System.out.println(rand.nextFloat());
        //随机生成false或true
        System.out.println(rand.nextBoolean());
        //随机生成[0,10)之间的int类型数据
        System.out.println(rand.nextInt(10));
        //随机生成[20,30)之间的int类型数据
        System.out.println(20 + rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据（此种方法较为复杂）
        System.out.println(20 + (int) (rand.nextDouble() * 10));

    }
}
