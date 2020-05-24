package com.cj.school;

/**
 * 测试类
 * @version 2020-5-7
 * @author CJ
 */
public class DemoTest {
    public static void main(String[] args) {
        var teacher = new Teacher("张三", "教授", "男");
        double sub = teacher.subSidy();
        boolean important = teacher.important();
        System.out.println(teacher + "津贴：" + sub + "是否是骨干员工：" + important);

        System.out.println("====================");
        var worker = new Worker("李四", 3, "男");
        sub = worker.subSidy();
        important = worker.important();
        System.out.println(worker + "津贴：" + sub + "是否是骨干员工：" + important);
    }
}
