package cn.cj.test.arrays;

/**
 * 数组的初始化
 * 方式：静态初始化，动态初始化，默认初始化
 *
 * @author CJ
 */

public class Test02 {
    public static void main(String[] args){
        //静态初始化
        int[] a = {2, 4, 53};
        User[] b = {new User(1001, "CJ"),
                    new User(1002, "CJ2"),
                    new User(1003, "CJ3")};

        //默认初始化
        int[] c = new int[3]; //默认初始化给数组元素进行赋值。赋值的规则和成员变量默认赋值规则一致

        //动态初始化
        int[] a1 = new int[2];
        a1[0] = 123;
        a1[1] = 3235;//给数组元素赋值
    }
}
