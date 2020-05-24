/**
 * 测试参数传值机制
 * 基本数据类型参数的传递：传递的是值的副本，值的原件不会发生改变
 * 引用类型参数的传递：传递的是值的副本。但是引用类型指的是“对象的地址”。
 *                   因此，副本和原参数都指向了同一个“地址”，
 *                   改变 “副本指向地址对象的值，也意味着原参数指向地址对象的值也发生了改变”
 *
 * @author CJ
 */

public class TestParameterTransfer {
    int id;//id
    String name;//账户名
    String pwd;//密码

    public TestParameterTransfer(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void testParameterTransfer01(TestParameterTransfer u){
        u.name = "CJ";
    }
    public void testParamterTransfer02(TestParameterTransfer u){
        u = new TestParameterTransfer(200, "CJ23");
    }

    public static void main(String[] args){
        //创建了一个新的对象u1，id是100， 名字是CJCJ
        TestParameterTransfer u1 = new TestParameterTransfer(100, "CJCJ");
        /*通过u1调用01方法，将u1的地址拷贝给u，假如u1的地址是123，
          则u的地址也变为123，u1与u同时指向123，则原数值name发生改变，变为CJ
         */
        u1.testParameterTransfer01(u1);
        System.out.println(u1.name);
        /*
            通过u1调用02方法，将u1的地址拷贝给了u，则u的地址为123
            此时，在02中又新创建了一个对象，则u的地址指向了新对象的地址124
            u1仍然指向原来的地址123，所以在打印u1.name的时候，值不会发生改变
         */
        u1.testParamterTransfer02(u1);
        System.out.println(u1.name);
    }
}
