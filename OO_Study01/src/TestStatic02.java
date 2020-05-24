/**
 * 测试静态初始化块
 * @author CJ
 */

public class TestStatic02 {
    int id;//id
    String name;//名字
    String pwd;//密码
    static String company;//静态成员变量，公司
    static{//静态块
        System.out.println("执行类的初始化工作");
        company = "CJ公司";
        printCompany();
    }
    public static void printCompany(){
        System.out.println(company);
    }
    public static void main(String[] args){
        TestStatic02 u3 = new TestStatic02();
    }
}
