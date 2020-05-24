package cn.cj.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map常用方法
 * @author CJ
 */

public class TestMap2 {
    public static void main(String[] args){
        //定义了四个新的对象
        Employee e1 = new Employee(1001, "CJ", 50000);
        Employee e2 = new Employee(1002, "CJ2", 6000);
        Employee e3 = new Employee(1003, "CJ3", 7000);
        Employee e4 = new Employee(1001, "CJ5", 7000);

        System.out.println(e1.hashCode());

        Map<Integer, Employee> map = new HashMap<>();

        //将对象放入map容器中
        map.put(1001, e1);
        map.put(1002, e2);
        map.put(1003, e3);
        map.put(1001, e4);//此处重复放置1001，所以此处新放置的覆盖了前面放置的

        Employee emp = map.get(1001);
        System.out.println(emp.getEname());//调用Employee中的getEname方法

        System.out.println(map);
    }
}


//Employee类，雇员的基本信息
class Employee{
    private int id;
    private String ename;
    private double salary;

    @Override
    public String toString() {
        return "id:"+id+" name:"+ename+" salary:"+salary;
    }

    public int getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String ename, double salary) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }
}
