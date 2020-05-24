package com.cj.school;

/**
 * 工人类
 * @version 2020-5-7
 * @author CJ
 */
public class Worker extends AbstractEmployee {
    private final int workingAge;

    /**
     * 新增了工龄
     * @param name 名称
     * @param workingAge 工龄
     * @param sex 性别
     */
    protected Worker(String name, int workingAge, String sex) {
        super(name, sex);
        this.workingAge = workingAge;
    }


    /**
     * 根据工龄计算津贴
     * @return 津贴
     */
    @Override
    public double subSidy() {
        return workingAge * 50;
    }

    /**
     * 根据工龄判断是否为骨干员工
     * @return 返回是否为骨干员工
     */
    @Override
    public boolean important() {
        return workingAge >= 10;
    }
}
