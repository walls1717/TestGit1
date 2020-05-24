package com.cj.test.fundamentals4_6;

import com.cj.test.fundamentals4_2.Employee;
import static java.lang.System.*;

public class PackageTest {
    public static void main(String[] args) {
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        out.println("name=" + harry.getName() + ", salary=" + harry.getSalary());
    }
}
