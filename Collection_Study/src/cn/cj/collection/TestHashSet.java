package cn.cj.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet
 *
 * 1.set没有顺序不可重复
 * 2.List有顺序可重复
 *
 * @author CJ
 */

public class TestHashSet {
    public static void main(String[] args){
        Set<String> set1 = new HashSet<>();
        set1.add("aa");
        set1.add("bb");
        set1.add("aa");
        System.out.println(set1);
        set1.remove("bb");
        System.out.println(set1);

        Set<String> set2 = new HashSet<>();
        set2.add("CJ");
        set2.addAll(set1);
        System.out.println(set2);
    }
}
