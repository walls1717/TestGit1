package com.cj.mediator;

/**
 * 同事类
 *
 * @author CJ
 */

public interface Department {
    void selfAction(); //做本部门的事情
    void outAction(); //向总经理发出申请
}
