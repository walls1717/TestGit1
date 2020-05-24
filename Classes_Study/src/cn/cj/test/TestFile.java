package cn.cj.test;

import java.io.File;
import java.io.IOException;

/**
 * File类的综合应用
 * @author CJ
 */

public class TestFile {
    public static void main(String[] args){
        //指定一个文件
        File file = new File("d:/sxt/b.txt");
        //判断文件是否存在，如果存在就删除，如果不存在就创建
        boolean flag = file.exists();
        if (flag) {
            boolean flagd = file.delete();
            //如果成功删除就打印删除成功，如果失败就打印删除失败
            if (flagd) {
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else{
            //创建
            boolean flagn = true;
            try{
                File dir = file.getParentFile();//获得file的路径
                dir.mkdirs();//先创建目录
                flagn = file.createNewFile();//再创建文件
                System.out.println("创建成功");
            } catch (IOException e) {
                System.out.println("创建失败");
                e.printStackTrace();
            }
        }
    }
}
