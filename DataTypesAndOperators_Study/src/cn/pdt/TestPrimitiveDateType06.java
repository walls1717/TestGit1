package cn.pdt;

/**
 * 测试变量
 * @CJ
 */

public class TestPrimitiveDateType06 {
    int a; //成员变量，从属于对象；成员变量会被自动初始化
    static int size;//静态变量，从属于类

    public static void main(String[] args){

        {
            int age;//局部变量，作用域在这个区域内，从属于语句块
            age = 18;
        }
        int salary = 3000;//局部变量，从属于方法
        double a = 3.1415926;//双精度浮点double类型，默认为这个类型
        float b = 12.13F;//单精度浮点，结尾要加上f或者F,建议大写
        boolean c = true;//布尔型，只有true与false
        char d = 'a';//字符型，只能为一个字符

        int ago = 13;
        System.out.println(ago);
        System.out.println(salary);
//        System.out.println(a);

        int i;
        //int j = i + 5;//编译出错，i没有被初始化。在定义i时应当初始化
    }
}
