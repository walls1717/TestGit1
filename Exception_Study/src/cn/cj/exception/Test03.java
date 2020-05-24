package cn.cj.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static cn.cj.exception.Test02.readMyFile;

/**
 * 使用throws声明异常
 * @author CJ
 */

public class Test03 {
    public static void main(String[] args) throws IOException {
        readMyFile();
    }

    public static void readMyFile() throws IOException {
        FileReader reader = null;
        reader = new FileReader("d:/b.txt");
        System.out.println("step1");
        char c1 = (char)reader.read();
        System.out.println(c1);

        if (reader != null) {
            reader.close();
        }
    }
}
