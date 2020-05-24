package com.cj.oo;

/**
 * 测试封装
 * @author CJ
 */

public class PersonEncapsulation {
    private int id;
    private String name;
    private int age;
    private boolean man;//布尔类型的get要换成is

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        if(age >= 1 && age <= 130){
            this.age = age;
        }else{
            System.out.println("请输入正确的年龄！");
        }
    }
    public int getAge(){
        return this.age;
    }
}
