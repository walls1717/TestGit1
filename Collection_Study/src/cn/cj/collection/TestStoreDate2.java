package cn.cj.collection;

import java.util.*;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储，多行使用放到map或list中
 * @author CJ
 */

public class TestStoreDate2 {
    public static void main(String[] args){
        User u1 = new User(1001, "张三", 2000, "2018.2.2");
        User u2 = new User(1002, "李四", 30000, "2010.2.2");
        User u3 = new User(1003, "王五", 3200, "2020.2.2");

        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        for(User u:list){
            System.out.println(u);
        }

        Map<Integer, User> map = new HashMap<>();
        map.put(1001, u1);
        map.put(1002, u2);
        map.put(1003, u3);
        Set<Integer> keyset = map.keySet();
        for(Integer key:keyset){
            System.out.println(key+"===="+map.get(key));
        }
    }
}

//一个完整的JavaBean。要又set和get方法，以及无参构造器
class User{
    private int id;
    private String name;
    private double salary;
    private String hiredate;

    public void User(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "id："+id+", name："+name+", salary："+salary+", Date："+hiredate;
    }
}
