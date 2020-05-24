/**
 * this代表"当前对象"示例
 * @author CJ
 */

public class TestThis02 {
    int id;//id
    String name;//账户名
    String pwd;//密码

    public TestThis02(){

    }
    public TestThis02(int id, String name){
        System.out.println("正在初始化已经创建好的对象："+this);
        this.id = id;//不写this无法区分局部变量id和成员变量id
        this.name = name;//同理
    }
    public void login(){
        System.out.println(this.name+",要登陆！");//不写this效果一样
    }

    public static void main(String[] args){
        TestThis02 u3 = new TestThis02(101, "CJ");//创建新对象u3并调用构造器
        System.out.println("打印CJ对象："+u3);
        u3.login();//调用login方法
    }
}
