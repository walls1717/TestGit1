/**
 * @author CJ
 */

class Computer1{
    String brand;
}

public class TestComputer {
    int id;
    String name;
    int age;
    Computer1 comp;
    void study(){
        System.out.println("我正在学习，使用我的电脑："+comp.brand);
    }
    public static void main(String[] args){
        TestComputer stu1 = new TestComputer();
        stu1.name = "CJ";
        Computer1 comp1 = new Computer1();//重新再堆里创建
        comp1.brand = "联想";
        stu1.comp = comp1;//需要初始化comp
        stu1.study();//调用study方法
    }
}
