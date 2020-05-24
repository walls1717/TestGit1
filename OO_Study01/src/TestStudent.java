/**
 * @author CJ
 */

public class TestStudent {
    //属性field
    String name;
    char sex;
    int age;
    int id;

    Computer comp;

    //方法
    void study(){
        System.out.println("我在认真学习");
    }
    void play(){
        System.out.println("我在玩游戏,用的"+comp.brand);
    }

    //程序执行的入口，必须要有
    public static void main(String[] args){
        TestStudent stu = new TestStudent();//创建一个对象
        System.out.println(stu);
        stu.id = 1001;
        stu.name = "CJ";
        stu.age = 18;
        stu.sex = 'm';

        Computer c1 = new Computer();
        c1.brand = "联想";

        stu.comp = c1;

        stu.play();
        stu.study();
    }
}

class Computer{
    String brand;
}