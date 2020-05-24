package cn.network;

public class Network {
    //成员变量
    int id;//id
    String name;//名字
    //String email = "@gameschool.com";//邮箱末尾
    String idEmail;//真正的邮箱

    //构造器
    public Network(int id, String name){
        this.id = id;
        this.name = name;
        idEmail = this.id + "@gameschool.com";
    }
    public Network(int id, String name, String idEmail){
        this(id, name);//调用上面的构造器
        this.idEmail = idEmail;
    }
    //打印结果
    public void display(){
        System.out.println("id="+id);
        System.out.println("name="+name);
        System.out.println("idEmail="+idEmail);
        System.out.println();
    }

    public static void main(String[] args){
        //创建两个新的对象
        Network n1 = new Network(1001, "CJ");
        Network n2 = new Network(1002, "JC", "1002@qq.com");
        //打印结果
        n1.display();
        n2.display();
    }
}