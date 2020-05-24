package com.cj.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * 备忘录类
 *
 * @author CJ
 */

public class EmpMemento {
    @Getter
    @Setter
    private String ename;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private double salary;

    public EmpMemento(Emp e){
        this.ename = e.getEname();
        this.age = e.getAge();
        this.salary = e.getSalary();
    }
}
