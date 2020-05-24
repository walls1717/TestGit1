package cn.cj.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * 测试TreeSet
 * 熟悉Comparable接口
 * @author CJ
 */

public class TestTreeSet {
    public static void main(String[] args){
        Set<Integer> set = new TreeSet<>();

        set.add(300);
        set.add(400);
        set.add(500);



        Set<Emp> set2 = new TreeSet<>();
        set2.add(new Emp(100, "张三", 3000));
        set2.add(new Emp(50, "李四", 4000));
        set2.add(new Emp(120, "王五", 5000));
        set2.add(new Emp(250, "赵六", 6000));
        set2.add(new Emp(10, "2六", 6000));
        //自增的顺序排序
        for(Emp m:set2){
            System.out.println(m);
        }
    }
}
