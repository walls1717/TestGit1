package com.cj.jvm.dynamiccomplie.server.servlet;

/**
 * <servlet>
 * <servlet-name>login</servlet-name>
 * <servlet-class>com.cj.server.basic</servlet-class>
 * </servlet>
 *
 * @author CJ
 */

public class Entity {
    private String name;
    private String clz;

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
