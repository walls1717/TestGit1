package com.cj.test.fundamentals4_5;

import java.util.Random;

public class Employee {
    private static int nextId;

    private int id;
    private String name = ""; //实例字段初始化
    private double salary;

    //静态初始化块
    static {
        var generator = new Random();
        //设置nextId为0到9999的随机数
        nextId = generator.nextInt(10000);
    }

    //对象初始化块
    {
        id = nextId;
        nextId++;
    }

    //三个重载的构造器
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(double salary) {
        this("Employee #" + nextId, salary);
    }

    public Employee() {
        //name初始化为空串
        //id初始化为0-9999之间的随机数，并且随着对象的构造递增
        //salary默认为0
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
