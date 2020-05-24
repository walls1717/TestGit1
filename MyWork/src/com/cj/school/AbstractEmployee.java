package com.cj.school;

/**
 * @version 2020-5-7
 * @author CJ
 */
abstract class AbstractEmployee {
    private final String name;
    private final String sex;

    protected AbstractEmployee(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    /**
     * 用于计算员工津贴值
     * @return 返回员工津贴值
     */
    public abstract double subSidy();

    /**
     * 判断员工是否为骨干员工
     * @return true：是骨干员工，false：不是骨干员工
     */
    public abstract boolean important();

    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
