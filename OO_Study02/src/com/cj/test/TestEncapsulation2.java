package com.cj.test;

import com.cj.oo.Human;

public class TestEncapsulation2 {
    public static void main(String[] args){
        Human h = new Human();
//        h.name = "CJ"; //name为默认的default属性，不能被不同包的类访问
        h.sayAge();
    }
}

class Girl extends Human{
    void sayGood(){
        System.out.println(height);//位于不同的包，但是为Human的子类，所以也可以使用
    }
}