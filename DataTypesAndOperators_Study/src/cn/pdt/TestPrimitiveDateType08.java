package cn.pdt;

/**
 * 整型变量/常量
 * @CJ
 */

public class TestPrimitiveDateType08 {
    public static void main(String[] argas){
        byte a = 127;//1字节，范围-128到127
        short b = 30000;//2字节，范围大约-三万到三万
        int c = 210000000;//4字节，范围大约在21亿
        long d = 2000000000L;//8字节，最大范围2的63次方
        int e = 015;//以0开头的是八进制
        int f = 0x15;//以0x开头的是十六进制
        int g = 0b1101;//以0b开头的是二进制

        //打印
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }
}
