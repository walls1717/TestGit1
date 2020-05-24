package com.cj.test.fundamentals5_14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author CJ
 * @version 2020-5-20
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g java.util.Date): ");
            name = in.next();
        }

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + " ");
        }
        System.out.print("class " + name);
        if (supercl != null && supercl != Object.class) {
            System.out.print(" extends " + supercl.getName());
        }

        System.out.print(" {\n");
        printFields(cl);
        System.out.println();
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println("}");
    }

    /**
     * 输出构造器
     * @param cl 被输出类
     */
    public static void printConstructors(Class cl) {
        // 获取所有的构造器
        Constructor[] constructors = cl.getDeclaredConstructors();


        for (Constructor c : constructors) {
            // 获取构造器名字
            String name = c.getName();
            System.out.print("    ");
            // 获得构造器修饰符，并转为字符串形式
            String modifiers = Modifier.toString(c.getModifiers());
            // 如果不止一个修饰符，在每个修饰符后面加上空格
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // 获得参数的类型
            Class[] paramTypes = c.getParameterTypes();
            // 输出每一个参数
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 输出方法
     * @param cl 被输出类
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods) {
            // 获得方法的返回值类型
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");

            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");

            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 输出成员变量
     * @param cl 被输出类
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
