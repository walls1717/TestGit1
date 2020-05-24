/**
 * 常量测试
 * @CJ
 *
 */

public class TestConstant {
    public static void main(String[] args){
        int AGE = 18;//确定值，为常量
        final String NAME = "CJ";//用final修饰的是符号常量,常量按规范来说要大写
        final double PI = 3.1415;//final常量

        //变量
        double r = 5;//
        double area = PI*r*r;
        double circle = 2*PI*r;

        //打印area与circle的值
        System.out.println("area="+area);
        System.out.println("circle="+circle);
    }
}
