/**
 * 测试构造方法的重载
 * @author CJ
 */

public class TestConstructorOverLoad {
    int id;//id
    String name;//账户名
    String pwd;//密码
    //没有参数的构造器
    public TestConstructorOverLoad(){

    }
    public TestConstructorOverLoad(int id, String name){
        super();//构造方法的第一句总是super();
        this.id = id;//this表示创建好的对象
        this.name = name;
    }
    //参数个数不同，可以构成重载
    public TestConstructorOverLoad(int id, String name, String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
    public static void main(String[] args){
        TestConstructorOverLoad u1 = new TestConstructorOverLoad();
        TestConstructorOverLoad u2 = new TestConstructorOverLoad(101, "CJ");
        TestConstructorOverLoad u3 = new TestConstructorOverLoad(100, "Cjj", "123456");
    }
}
