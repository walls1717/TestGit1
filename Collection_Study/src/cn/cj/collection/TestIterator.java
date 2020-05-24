package cn.cj.collection;

import java.util.*;

/**
 * 测试迭代器遍历List。Set。Map
 * @author CJ
 */

public class TestIterator {
    public static void main(String[] args){
//        testIteratorList();
//        testIteratorSet();
        testIteratorMap();
    }

    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        //使用iterator遍历List
        for(Iterator<String> iter = list.iterator(); iter.hasNext() ;){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("dd");

        //使用iterator遍历Set
        for(Iterator<String> iter = set.iterator(); iter.hasNext() ;){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorMap(){
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(100, "aa");
        map1.put(200, "bb");
        map1.put(300, "cc");
        map1.put(400, "dd");

        Set<Map.Entry<Integer, String>> ss = map1.entrySet();

        //第一种遍历Map的方式
        for(Iterator<Map.Entry<Integer, String>> iter = ss.iterator(); iter.hasNext() ;){
            Map.Entry<Integer, String> temp = iter.next();

            System.out.println(temp.getKey()+"----"+temp.getValue());
        }

        System.out.println("################");

        Set<Integer> keySet = map1.keySet();
        for(Iterator<Integer> iter = keySet.iterator(); iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key+"----"+map1.get(key));
        }

    }
}
