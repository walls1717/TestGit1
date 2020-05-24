package com.cj.io;

import java.io.*;

/**
 * 打印流 PrintStream
 * @author CJ
 */

public class PrintTest01 {
    public static void main(String[] args) throws FileNotFoundException {
        //打印流 System.out
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        //打印到文件
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")), true);
        ps.println("打印流");
        ps.println(true);
        ps.close();

        //重定向输出端
        System.setOut(ps);
        System.out.println("change");
        //重定向回控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
        System.out.println("backing");
    }
}
