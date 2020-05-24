package com.cj.redpackage;

import java.util.ArrayList;
import java.util.Random;

/**
 * 员工
 * 只负责收红包，没有发红包的功能
 *
 * @author CJ
 * @version 2020-5-4
 */
public class Employee extends Person {
    public Employee(String name, int balance) {
        super(name, balance);
    }

    /**
     * 收红包
     * @param redArr 传入红包数组
     */
    public void getRedEnp(ArrayList<Integer> redArr) {
        //红包数组不为0，也就是说有红包的时候
        if (redArr.size() != 0) {
            //获得一个0-数组长度的随机数
            int index = new Random().nextInt(redArr.size());
            //更新余额
            setBalance(getBalance() + redArr.get(index));
            //领取完红包后，将红包从数组中删除
            redArr.remove(index);
            //如果数组为0，表明数组中没有红包
        } else {
            System.out.println("群主余额不足，没有红包！");
        }
    }
}
