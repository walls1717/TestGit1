package com.cj.io;

import java.io.*;

/**
 * 打印流 PrintWriter
 *
 * @author CJ
 */

public class PrintTest02 {
    public static void main(String[] args) throws FileNotFoundException {


        //打印到文件
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")), true);
        pw.println("打印流");
        pw.println(true);
        pw.close();

    }
}
