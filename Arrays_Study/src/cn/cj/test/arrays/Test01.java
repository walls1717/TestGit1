package cn.cj.test.arrays;

/**
 * 数组的声明
 * @author CJ
 */
public class Test01 {
    public static void main(String[] args){
        int[] arr01 = new int[10];
        String[] arr02 = new String[5];

        arr01[0] = 13;
        arr01[1] = 14;
        //arr01[10] = 10;//ArrayIndexOutOfBoundsException

        //通过循环初始化赋值
        for(int i = 0; i < arr01.length; i++){
            arr01[i] = 10*i;
        }
        //通过循环读取数组初始化值
        for(int i = 0; i < arr01.length; i++){
            System.out.println(arr01[i]);
        }

        User[] arr03 = new User[3];
        arr03[0] = new User(1001, "CJ1");
        arr03[1] = new User(1002, "CJ2");
        arr03[2] = new User(1003, "CJ3");

        for(int i = 0; i < arr03.length; i++){
            System.out.println(arr03[i].getName());
        }
    }
}

