package com.cj.redpackage;

import java.util.ArrayList;

/**
 * 测试
 *
 * @author CJ
 * @version 2020-5-4
 */
public class DemoTest {
    public static void main(String[] args) {
        //群主
        var lord = new Lord("CJ", 50000);
        //三个员工
        var staff = new Employee[3];
        staff[0] = new Employee("Jack", 0);
        staff[1] = new Employee("Li", 0);
        staff[2] = new Employee("Smith", 0);

        System.out.println("群主余额：" + lord.getName() + " " + lord.getBalance());

        System.out.println("领取红包前每个人的余额");
        for (Employee e : staff) {
            System.out.println(e.getName() + " " + e.getBalance());
        }

        //发红包
        ArrayList<Integer> redArr = lord.redEnvelope(20000, 3);

        //领红包
        for (Employee e : staff) {
            e.getRedEnp(redArr);
        }

        System.out.println("领取红包后每个人的余额");
        for (Employee e : staff) {
            System.out.println(e.getName() + " " + e.getBalance());
        }
    }
}
