package com.cj.jvm.dynamiccomplie.reflection;

/**
 * 测试各种类型（class，interface，enum，annotation，primitive type，void）对应的Java.lang.Class对象的获取方式
 *
 * @author CJ
 */

@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {
        String path = "com.cj.bean.User";
        try {
            Class clazz = Class.forName(path);
            // 对象是表示或封装一些数据，一个类被加载后，
            // JVM会创建一个对应该类的Class对象，类的结构信息会放到对应的Class对象中
            // 这个Class对象就像一面镜子一样，通过这面镜子可以看到对应的全部信息
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path); // 一个类只对应一个Class对象
            System.out.println(clazz.hashCode());

            Class strClazz = String.class;
            Class strCLazz2 = path.getClass();
            System.out.println(strClazz == strCLazz2);

            Class intClazz = int.class;

            int[] arr01 = new int[10];
            int[] arr02 = new int[30];
            int[][] arr03 = new int[30][3];
            double[] arr04 = new double[10];

            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
