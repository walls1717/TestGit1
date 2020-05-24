package com.cj.test.fundamentals5_4;

/**
 * @author CJ
 */
public class Student extends AbstractPerson {
    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in" + major;
    }
}
