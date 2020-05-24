package cn.pdt;

/**
 * 字符型变量/常量
 * @CJ
 */

public class TestPrimitiveDateType10 {

    public static void main(String[] args){
        char a = 'C';//只能是一个字符
        char b = '程';//可以使用汉字
        char c = '\u0061';
        System.out.println(c);

        //转义字符
        System.out.println(""+'a'+'\n'+'b');//换行
        System.out.println(""+'a'+'\t'+'b');//制表符
        System.out.println(""+'a'+'\''+'b');//打印单引号

        //String就是字符序列
        String d = "abc";
    }
}
