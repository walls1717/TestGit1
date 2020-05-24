package cn.cj.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map
 * @author CJ
 */

public class TestMap {
    public static void main(String[] args){
        Map<Integer, String> m1 = new HashMap<>();

        //通过put往容器里面放元素
        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");

        System.out.println(m1.get(1));//通过get获得元素

        System.out.println(m1.size());//获得长度
        System.out.println(m1.isEmpty());//判断容器是否为空
        System.out.println(m1.containsKey(2));//判断容器中是否有键是2的元素
        System.out.println(m1.containsValue("three"));//判断容器中是否有名为xx的元素

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(4, "四");
        m2.put(5, "五");
        m1.putAll(m2);//将m2中所有的元素copy到m1中
        System.out.println(m1);

        //Map中的键不能重复!如果重复了新的就会覆盖旧的（是否重复是根据equals进行比较）
        m1.put(3, "four");
        System.out.println(m1);
    }
}
