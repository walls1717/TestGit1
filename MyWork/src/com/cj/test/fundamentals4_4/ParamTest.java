package com.cj.test.fundamentals4_4;

public class ParamTest {
    public static void main(String[] args) {
        /**
         * 在方法中传递参数，传递的是这个参数的副本，真正的参数不会改变
         * 只是在方法内部参数的符本改变
         * 比如说例子中的percent，传递进方法的时候为10，在方法内部的副本扩大了3倍
         * 但是这并不会影响真正的percent，真正的percent的值仍然是10
         */
        System.out.println("Testing tripleValue: ");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /**
         * 如果方法中传递的是对象，那么方法中的操作，可以改变真正的对象的状态
         * 从例子中可以看出，我们创建了一个Employee对象，放入harry中，将harry传入到方法里
         * 方法调用结束后，harry的状态发生了改变
         */
        System.out.println("\nTesting tripleSalary: ");
        var harry = new Employee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /**
         * 方法中传入了两个对象参数，两个对象参数在方法中交换了位置，但是
         * 并不影响真正的对象参数，真正的对象参数仍然是老样子
         * 方法不能让一个对象参数引用一个新的对象参数
         */
        System.out.println("\nTesting swap: ");
        var a = new Employee("Alice", 70000);
        var b = new Employee("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}
