package com.cj.jvm.dynamiccomplie.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 几种内置注解
 * 1.@Override：只适用于修饰方法，重写父类方法注解，表示此方法为重写父类方法
 * 2.@Deprecated：适用于修饰方法，属性，类，
 *               表示不鼓励程序员使用这样的元素，通常是因为他很危险或存在更好的选择
 * 3.@SuppressWarnings：用来抑制编译时的警告信息
 * 参数：
 * 1.deprecation：使用了过时的类或方法的警告
 * 2.unchecked：执行了未检查的转换时的警告，如使用集合时未指定泛型
 * 3.fallthrough：当在switch语句使用时发生case穿透
 * 4.path：在类路径，源文件路径等中有不存在路径的警告
 * 5.serial：当序列化的类上缺少serialVersionUID定义时的警告
 * 6.finally：任何finally子句不能完成时的警告
 * 7.all：关于以上所有情况的警告
 * @author CJ
 */

@SuppressWarnings("all")
public class Demo01 {
    @Override
    public String toString() {
        return "";
    }
    @Deprecated
    public static void test001(){
        System.out.println("test001");
    }

    public static void test002(){
        List list = new ArrayList();
        List list1 = new ArrayList();
    }

    public static void main(String[] args) {
        Date d = new Date();
        test001();
    }
}
