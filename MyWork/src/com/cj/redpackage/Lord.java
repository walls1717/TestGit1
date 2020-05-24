package com.cj.redpackage;

import java.util.ArrayList;

/**
 * 群主
 * 只负责发红包，没有领红包的功能
 * @version 2020-5-4
 * @author CJ
 */
public class Lord extends Person {

    public Lord(String name, int balance) {
        super(name, balance);
    }

    /**
     * 发红包
     * @param redMoney 红包金额
     * @param peopleNum 需要发多少人
     * @return 返回一个存放红包的ArrayList数组
     */
    public ArrayList<Integer> redEnvelope(int redMoney, int peopleNum) {
        //创建一个与人数相同大小的ArrayList提高效率
        var redArr = new ArrayList<Integer>(peopleNum);
        //红包的金额应当小于余额
        if (redMoney < getBalance()) {
            //更新余额
            setBalance(getBalance() - redMoney);
            //取出平均一个红包多少钱
            int averageRed = redMoney / peopleNum;
            //如果除不尽，将余数放入最后一个红包
            int remRed = redMoney % peopleNum;
            //循环将各个红包放入ArrayList
            for(int i = 0; i < peopleNum - 1; i++) {
                redArr.add(averageRed);
            }
            //将最后一个红包放入ArrayList
            redArr.add(averageRed + remRed);
        }
        //如果红包金额小于余额，就返回一个与peopleNum大小相同的ArrayList数组
        //否则返回一个长度为0的
        return redArr;
    }
}
