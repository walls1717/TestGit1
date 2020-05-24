package cn.cj.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap
 * @author CJ
 */

public class TestTreeMap {
    public static void main(String[] args){
        Map<Integer, String> treemap1 = new TreeMap<>();
        treemap1.put(20, "aa");
        treemap1.put(3, "bb");
        treemap1.put(6, "cc");

        //按照key递增的方式排序
        for(Integer key:treemap1.keySet()){
            System.out.println(key+"----"+treemap1.get(key));
        }

        Map<Emp, String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(100, "张三", 50000), "张三是个好小伙");
        treemap2.put(new Emp(200, "李四", 300), "李四工作不积极");
        treemap2.put(new Emp(150, "王五", 5000), "王五工作还不错");
        treemap2.put(new Emp(250, "赵6", 5000), "250");

        for(Emp key:treemap2.keySet()){
            System.out.println(key+"----"+treemap2.get(key));
        }

    }
}

class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id"+id+",name"+name+",salary"+salary;
    }

    @Override
    public int compareTo(Emp o) {//负数：小于0；等于，正数：大于
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
