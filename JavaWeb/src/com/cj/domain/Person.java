package com.cj.domain;

/**
 * @version 2020-5-19
 * @author CJ
 */
public class Person {
    private String name;
    private String sex;
    private int id;

    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {
    }

    public Person(String name, String sex, int id) {
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", id=" + id +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("Eat");
    }

    public void eat(String name) {
        System.out.println(name);
    }
}
