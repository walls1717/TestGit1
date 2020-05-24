package cn.pdt; /**
 * 浮点型变量/常量
 *
 */

import java.math.BigDecimal;

public class TestPrimitiveDateType09 {

    public static void main(String[] args){
        float PI = 3.14F;//4字节，3.403E38，尾数可以精确到7位
        double PI2 = 3.1415D;//8字节，1.798E308，尾数可以精确到14位

        //科学计数法赋值
        double f = 314e2D;
        double f2 = 314e-2D;

        //浮点数是不精确的,一定不要用于比较
        float f3 = 0.1F;
        double d = 1.0/10;

        //测试比较
        float d1 = 423432423F;
        float d2 = d1+1;
        if(d1==d2){
            System.out.println("d1==d2");
        }else{
            System.out.println("d1!=d2");
        }

        //打印
        System.out.println(PI);
        System.out.println(PI2);
        System.out.println(f);
        System.out.println(f2);
        System.out.println(f==d);//结果为false

        System.out.println("##########################");

        //使用精确的浮点运行，推荐：BigDecimal
        BigDecimal bd = BigDecimal.valueOf(1.0);//定义bd的值为1.0
        bd = bd.subtract(BigDecimal.valueOf(0.1));//对bd减去0.1
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd);//按照以上方法减得到的值精确
        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);//直接进行减法运算得到的值不精确

        BigDecimal bd2 = BigDecimal.valueOf(0.1);//给定bd2的值为0.1
        BigDecimal bd3 = BigDecimal.valueOf(1.0/10.0);//给定bd3的值为1.0/10.0
        System.out.println(bd2.equals(bd3));//对bd2与bd3进行比较
    }
}
