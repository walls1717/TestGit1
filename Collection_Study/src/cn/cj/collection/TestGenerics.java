package cn.cj.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试泛型
 * @author CJ
 */

public class TestGenerics {
    public static void main(String[] args){
        MyCollection<String> mc = new MyCollection<String>();

        mc.set("CJ", 0);
        mc.set("CJCJ", 1);

        String a = mc.get(1);
        String b = mc.get(0);
        System.out.println(a);
        System.out.println(b);

        List list = new ArrayList();
        Map map = new HashMap();
    }
}

class MyCollection<E>{//其中的<E>代表后期传进来的类型
    Object[] objs = new Object[5];

    public void set(E e, int index){
        objs[index] = e;
    }
    public E get(int index){
        return (E)objs[index];
    }
}
