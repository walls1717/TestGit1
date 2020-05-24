package cn.tc;

/**
 * 测试自动类型转换
 * @author CJ
 */

public class TestTypeConversion01 {
    public static void main(String[] args){
        int a = 123;
        long b = a;
        double d = b;//容量小的可以向容量大的自动转化
//        a = b;//long大于int无法转化
//        long e = 1.23;//1.23自动为double类型大于long，无法转化
        float f = 234434L;//long可以转向float

        //特例
        byte b2 = 123;//可以将整型变量直接赋给byte，short，char等类型，不超出其范围即可
    }
}