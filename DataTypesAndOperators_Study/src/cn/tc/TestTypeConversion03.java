package cn.tc;

/**
 * 基本类型转化时常见的错误和问题
 * @author CJ
 */

public class TestTypeConversion03 {
    public static void main(String[] args){
        int money = 1000000000;//10亿
        int years = 20;
        //输出为负数，因为范围超过了int
        int total = money*years;
        System.out.println("total="+total);
        //输出为负数，因为先转化为int再转化为long，数据已经失真
        long total1 = money*years;
        System.out.println("total="+total1);
        //输出正确，将两数中其中一数强制转化为了long型，数据就按照long型进行计算
        long total2 = money*((long)years);
        System.out.println("total2="+total2);
        //小技巧
        long total3 = 234L*2345*years*money>>2;//在写的时候可以先将一个值写为long类型
        System.out.println(total3);

        //命名问题
        int l = 2;//要使用大写的L进行命名，不然不易区分l与1
        long a = 12341243L;//使用大写的L
        System.out.println(l+1);
    }
}