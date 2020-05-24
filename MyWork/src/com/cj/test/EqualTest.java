package com.cj.test;

import com.cj.test.fundamentals4_2.Employee;

/**
 * 测试equal
 *
 * @author CJ
 * @version 2020-5-1
 */
public class EqualTest {
    private String name;
    private double salary;
    public static void main(String[] args) {

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if(getClass() != obj.getClass()) {
            return false;
        }

        EqualTest other = (EqualTest) obj;

        return name.equals(other.name) && salary == other.salary;
    }
}
