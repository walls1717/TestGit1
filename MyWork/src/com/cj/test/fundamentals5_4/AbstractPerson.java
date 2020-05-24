package com.cj.test.fundamentals5_4;

/**
 * @author CJ
 */
public abstract class AbstractPerson {
    /**
     * 返回子类信息
     * @return 返回子类信息
     */
    public abstract String getDescription();

    private String name;

    public AbstractPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
