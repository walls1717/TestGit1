/**
 * 测试this
 * this本质：表示当前方法所在的对象。“创建好的对象的地址”由于在构造方法调用前，对象已经创建。因此，在构造方法中也可以使用this代表当前对象
 * 对象创建的过程
 * 1.分配对象空间，并将对象成员变量初始化为0或空
 * 2.执行属性值的显示初始化
 * 3.执行构造方法
 * 4.返回对象的地址给相关变量
 *
 * this不能用于static方法中
 * @author CJ
 */

public class TestThis01 {
    int a, b, c;

    TestThis01(int a, int b){
        this.a = a;
        this.b = b;
    }

    TestThis01(int a, int b, int c){
        this(a, b);//调用构造器，这个就是调用TestThis(int a, int b)，构造器的调用必须位于第一句
        this.c = c;
    }

    void sing(){

    }

    void eat(){
        this.sing();//调用本类中的this
        System.out.println("你妈喊你回家吃饭！");
    }

    public static void main(String[] args){
        TestThis01 hi = new TestThis01(2, 3);
        hi.eat();
    }
}
