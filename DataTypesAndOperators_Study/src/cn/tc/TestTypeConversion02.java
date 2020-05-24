package cn.tc;

/**
 * 测试强制类型转化
 * @author CJ
 */

public class TestTypeConversion02 {
    public static void main(String[] args){
        double x = 3.14;
        int nx = (int)x;//将double类型强制转化为int型,精度会损失
        char c = 'a';
        int d = c+2;//这一步将c转化为了int型
        System.out.println(nx);
        System.out.println(d);
        System.out.println((char)d);//将d强制转化为char型

        //特例
        int b = 1000;
        byte bx = (byte)b;//byte类型小于int类型
        System.out.println(bx);
    }
}
