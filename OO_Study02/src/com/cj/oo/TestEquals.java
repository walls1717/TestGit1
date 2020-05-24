package com.cj.oo;

/**
 * 测试equals
 * 提供定义“对象内容相等”的逻辑
 *
 * JDK提供一些类，如String, Date, 包装类等，重写了Object的equals方法，调用这些类的equals方法
 * x.equals(y)，当x和y所引用的对象是同一类对象并且属性内容相等时（并不一定是相同对象）
 * 返回true，否则返回false
 */

public class TestEquals {
    public static void main(String[] args){
        Object obj;
        String str;//用来查看源码

        //创建了两个新对象u1和u2
        User u1 = new User(1001, "CJ", "123456");
        User u2 = new User(1001, "JC", "1233445");

        System.out.println(u1 == u2);//比较两个对象是否相等，很显然，这是两个独立的对象u1和u2，返回false
        /*
          在User类中，对equals进行了重写
          其作用变为判断两个对象的id是否相等
          相等返回true，不相等返回false
         */
        System.out.println(u1.equals(u2));

        /*
           在String中equals的作用是用来判断两个字符串是否相等
           相等返回true，不相等返回false
         */
        String str1 = new String("CJ");
        String str2 = new String("CJ");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}

class User {
    int id;
    String name;
    String pwd;

    public User(int id, String name, String pwd) {
        super();
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User)obj;
        if (id != other.id) {
            return false;
        }else{
            return true;
        }
    }
}
