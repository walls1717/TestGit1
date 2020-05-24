package cn.cj.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试接口中的方法
 * @author CJ
 */

public class TestList {
    public static void main(String[] args) {
        test02();
        test03();
    }

    public static void test01() {
        Collection<String> c = new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("CJ");//在容器中添加一个对象
        c.add("CJCJ");
        System.out.println(c);
        System.out.println(c.size());//检测容器长度

        System.out.println(c.contains("CJ23"));//判断容器中是否包含这个对象

        Object[] objs = c.toArray();//将容器转化为一个数组

        c.remove("CJCJ");//把对象从容器中移除，并不是删除
        System.out.println(c);

        c.clear();
        System.out.println(c.size());
    }

    public static void test02() {
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:" + list01);
//        list01.addAll(list02);//把另一个容器里所有的元素加到另一个容器中
//        list01.removeAll(list02);//把两个容器里相同的元素移除
        list01.retainAll(list02);//把两个容器里不相同的元素移除
        System.out.println("list01:" + list01);

        System.out.println(list01.containsAll(list02));//容器01是否包含了02里的所有元素
    }

    public static void test03() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);

        list.add(2, "CJ");//在索引位置插入一个元素
        System.out.println(list);

        list.remove(2);//把索引位置处的元素移除
        System.out.println(list);

        list.set(2, "CJ");//将索引位置处的元素替换为指定元素
        System.out.println(list);

        System.out.println(list.get(2));//返回指定索引处的元素

        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list);
        System.out.println(list.indexOf("D"));//返回指定元素从前往后第一次出现的位置
        
    }
}
