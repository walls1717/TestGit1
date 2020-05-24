/**
 * 精确计算总共写了多少行代码
 *
 * @author CJ
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CalculateRows {
    static long classcount = 0;//Java类的数量
    static long normalLines = 0;//空行
    static long commentLines = 0;//注释行
    static long writeLines = 0;//代码行
    static long allLines = 0;//代码行

    public static void main(String[] args) throws Exception {
        File f = new File("D:\\IntelliJ IDEA\\Test");//目录
        String type = ".java";//查找什么类型的代码，如".java"就是查找java代码开发量
        CalculateRows.treeFile(f, type);
        System.out.println("路径: " + f.getPath());
        System.out.println(type + "类数量: " + classcount);
        System.out.println("代码数量：" + writeLines);
        System.out.println("注释数量：" + commentLines);
        System.out.println("空行数量：" + normalLines);
//        if(classcount==0){
//            System.out.println("代码平均数量："+0);
//        }else{
//            System.out.println("代码平均数量："+writeLines/classcount);
//        }
        System.out.println("去除空行："+ (allLines - normalLines));
        System.out.println("总行数量：" + allLines);
    }


    public static void treeFile(File f, String type) throws Exception {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            File file = childs[i];
            if (!file.isDirectory()) {
                if (file.getName().endsWith(type)) {
                    classcount++;
                    BufferedReader br = null;
                    boolean comment = false;
                    br = new BufferedReader(new FileReader(file));
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        allLines++;
                        line = line.trim();
                        if (line.matches("^[//s&&[^//n]]*$")) {//这一行匹配以空格开头但不是以回车符开头，以回车符结尾
                            normalLines++;
                        } else if (line.startsWith("/*")
                                && !line.endsWith("*/")) {//匹配/*。。。*/括住的多行注释
                            commentLines++;
                            comment = true;
                        } else if (true == comment) {
                            commentLines++;
                            if (line.endsWith("*/")) {
                                comment = false;
                            }//匹配以//开头的单行注释，以及以/*。。*/的单行注释
                        } else if (line.startsWith("//") || (line.startsWith("/*")) && (line.endsWith("*/"))) {
                            commentLines++;
                        } else {//其它的就是代码行
                            writeLines++;
                        }
                    }
                    if (br != null) {
                        br.close();
                        br = null;
                    }
                }
            } else {
                treeFile(childs[i], type);
            }
        }
    }
}