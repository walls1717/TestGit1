package cn.pdt;

public class TestPrimitiveDateType04 {
    public static void main(String[] args)
    {
        byte b = 5;
        int i1 = 10;
        int i2 = 300;

        short x = 1;
        short y = 2;

        b = (byte) i1;
        System.out.println(b);

        b = (byte) i2;
        System.out.println(b);

        System.out.println(Integer.toBinaryString(i2));
        System.out.println(x+y);
    }
}
