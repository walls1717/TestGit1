package cn.cj.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用try-catch处理异常
 * @author CJ
 */

public class Test02 {
    public static void main(String[] args){
        readMyFile();
    }

    public static void readMyFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("d:/a.txt");
            System.out.println("step1");
            char c1 = (char)reader.read();
            System.out.println(c1);
        } catch (FileNotFoundException e) {
            System.out.println("step2");//子类异常在父类异常前面
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            System.out.println("step3");
            try {
                if (reader != null) {
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
