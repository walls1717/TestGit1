package com.cj.prototype;

import java.util.Date;

/**
 * 测试深复制
 *
 * @author CJ
 */

public class Sheep02 implements Cloneable{ //1997，英国的克隆羊，多利！
    private String name;
    private Date birthday;

    public Sheep02(){
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //直接调用object对象的clone()方法
        //添加如下代码实现深赋值
        Sheep02 s = (Sheep02) obj;
        s.birthday = (Date) this.birthday.clone(); //把属性也进行拷贝
        return obj;
    }

    public Sheep02(String name, Date birthday) {
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
