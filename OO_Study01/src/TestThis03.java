/**
 * this()调用重载构造方法
 * @author CJ
 */

public class TestThis03 {
    int a, b, c;

    TestThis03(){
        System.out.println("正要初始化一个Hello对象");
    }
    TestThis03(int a, int b){
        //TestThis(); //这样是无法调用构造方法的！
        this();//调用无参的构造方法，并且必须位于第一行！
        //a = a;//这里都是指的局部变量而不是成员变量
        //这样就区分了成员变量和局部变量，这种情况占了this使用情况的大多数！
        this.a = a;
        this.b = b;
        System.out.println("a="+a+"b="+b);
    }
    TestThis03(int a, int b, int c){
        this(a, b);//调用带参的构造方法，并且必须位于第一行
        this.c = c;
    }

    void sing(){

    }
    void eat(){
        this.sing();//调用本类中的sing();
        System.out.println("你妈妈喊你回家吃饭了！");
    }
    public static void main(String[] args){
        TestThis03 hi = new TestThis03(2, 3);
        hi.eat();//调用eat方法

    }
}
