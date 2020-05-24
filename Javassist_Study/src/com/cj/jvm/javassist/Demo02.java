package com.cj.jvm.javassist;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 测试javassist的API
 *
 * @author CJ
 */

@SuppressWarnings("all")
public class Demo02 {
    /**
     * 处理类的基本用法
     */
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.cj.javassist.Emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName()); //获取类名
        System.out.println(cc.getSimpleName()); //获取简要类名
        System.out.println(cc.getSuperclass()); //获得父类
        System.out.println(cc.getInterfaces()); //获得接口
    }

    /**
     * 测试产生新的方法
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.cj.javassist.Emp");

//        CtMethod m = CtNewMethod.make("public int add(int a, int b){return a + b;}", cc);
        CtMethod m = new CtMethod(CtClass.intType, "add"
                , new CtClass[]{CtClass.intType, CtClass.intType}, cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"CJCJ\");return $1 + $2;}");

        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance(); //通过调用Emp无参构造器，创建Emp对象
        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        Object result = method.invoke(obj, 200, 30);
        System.out.println(result);

    }

    /**
     * 修改已有的方法信息
     *
     * @throws Exception
     */
    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.cj.javassist.Emp");

        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"Start!!!\");");
        cm.insertAfter("System.out.println(\"End!!!\");");

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance(); //通过调用Emp无参构造器，创建Emp对象
        Method method = clazz.getDeclaredMethod("sayHello", int.class);
        Object result = method.invoke(obj, 200);
    }

    /**
     * 属性操作
     * @param args
     * @throws Exception
     */
    public static void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.cj.javassist.Emp");

//        CtField f1 = CtField.make("private int empno;", cc);
        CtField f1 = new CtField(CtClass.intType, "salary", cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);

//        cc.getDeclaredField("ename"); //获取指定属性

        //增加相应的set get方法
        cc.addMethod(CtNewMethod.getter("getSalary", f1));
        cc.addMethod(CtNewMethod.getter("setSalary", f1));
    }

    /**
     * 构造器操作
     * @throws Exception
     */
    public static void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.cj.javassist.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for(CtConstructor c:cs){
            System.out.println(c.getLongName());
        }
    }


    public static void main(String[] args) throws Exception {
        test05();
    }
}
