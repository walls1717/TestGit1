/**
 * 测试static关键字的用法
 * 在类中，用static声明的成员变量为静态成员变量，也称为类变量。
 * 类变量的生命周期和类相同，在整个应用程序执行期间都有效.
 *
 * static修饰的成员变量和方法，从属于类。普通变量和方法从属与对象的
 * @author CJ
 */

public class TestStatic01 {
    int id;//id
    String name;//账户名
    String pwd;//密码

    static String company = "CJ";//公司名称

    public TestStatic01(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void login(){
        printCompany();
        System.out.println(company);
        System.out.println("登录："+name);
    }

    public static void printCompany(){
//        login();//调用非静态成员，编译就会报错
        System.out.println(company);
    }

    public static void main(String[] args){
        TestStatic01 u = new TestStatic01(101, "CJ");
        TestStatic01.printCompany();
        TestStatic01.company = "北京CJ";
        u.printCompany();
        u.login();
    }
}
