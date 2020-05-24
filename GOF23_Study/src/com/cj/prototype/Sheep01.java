package com.cj.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CJ
 */

public class Sheep01 implements Cloneable, Serializable { //1997，英国的克隆羊，多利！
    private String name;
    private Date birthday;

    public Sheep01(){
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //直接调用object对象的clone()方法
        return obj;
    }

    public Sheep01(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
