package com.cj.test.fundamentals5_4;

/**
 * @author CJ
 */
public class PersonTest {
    public static void main(String[] args) {
        var people = new AbstractPerson[2];

        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        for(AbstractPerson p : people) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }
}
