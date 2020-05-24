import java.util.Scanner;

/**
 * 测试键盘输入
 * @author CJ
 */

public class TestScanner {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //从键盘获取名字和年龄
        System.out.println("Your name:");
        String name = s.nextLine();
        System.out.println("Your age:");
        int age = s.nextInt();

        //判断年龄，并输出相应的语句
        if(age<18){
            System.out.println("Hello "+name+" You are youth!");
        }else{
            System.out.println("Hello "+name+" You are adult!");
        }
    }
}
