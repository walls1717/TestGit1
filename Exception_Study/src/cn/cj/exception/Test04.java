package cn.cj.exception;

/**
 * 自定义异常
 * @author CJ
 */

public class Test04 {
    public static void main(String[] args){
        Person p = new Person();
        p.setAge(-100);
    }
}

class Person{
    private int age;

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if (age < 0) {
            try {
                throw new IllegalAgeException("年龄不能为负数");
            } catch (IllegalAgeException e) {
                e.printStackTrace();
            }
        }
        this.age = age;
    }

}

class IllegalAgeException extends Exception{
    public IllegalAgeException(){
    }

    public IllegalAgeException(String msg){
        super(msg);
    }
}
