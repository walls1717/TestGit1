package cn.pdt;

public class TestPrimitiveDateType03 {
    public static void main(String[] args)
    {

        //整型的集中类型
        long val = 26L;
        int decVal = 26;
        int hexVal = 0x05;
        int oxVal = 032;
        int binVal = 0b11010;

        //浮点型的集中类型
        float f1 = 123.4F;
        double d1 = 123.4;
        double d2 = 1.234e2;

        //字符的集中类型
        String name = "盖伦";
        char a = 'c';

        //转义字符
        char tab = '\t';
        char carriageReturn = '\r';
        char newLine = '\n';
        char doubleLeQuote = '\"';
        char singLeQuote = '\'';
        char backslash = '\\';

        //习题
        byte b = 12;
        short s = 15;
        int i = 100;
        long l = 500;
        float f = 12.12F;
        double d = 3.14156;
        char c = 'C';
        String str = "CJ";

        //打印整型的集中类型
        System.out.println(val);
        System.out.println(decVal);
        System.out.println(hexVal);
        System.out.println(oxVal);
        System.out.println(binVal);
    }
}