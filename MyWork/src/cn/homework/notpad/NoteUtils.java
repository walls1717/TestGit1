package cn.homework.notpad;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本工具类
 * 1. 新键文件
 * 2. 打开文件
 * 3. 修改文件
 * 4. 保存文件
 * 5. 退出
 * @version 2020-5-28
 * @author CJ
 */
public class NoteUtils {
    private static String message = null;

    /**
     * 新键文件
     */
    public static void createFile() {
        System.out.println("请输入内容，停止编写请输入stop");
        var sb = new StringBuffer();
        var sc = new Scanner(System.in);
        String line = "";
        while (true) {
            line = sc.nextLine();
            if ("stop".equals(line)) {
                break;
            }
            sb.append(line).append("\r\n");
        }
        message = sb.toString();
    }

    /**
     * 保存文件
     */
    public static void saveFile() {
        System.out.println("请输入需要保存的路径");
        var sc = new Scanner(System.in);
        String path = sc.next();
        var file = new File(path);
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            byte[] data = message.getBytes();
            os.write(data);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打开文件
     */
    public static void openFile() {
        System.out.println("请输入文件路径");
        var sc = new Scanner(System.in);
        String path = sc.nextLine();
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            byte[] flush = new byte[1024*10];
            int len = -1;
            while((len = is.read(flush)) != -1) {
                String str = new String(flush);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void editFile() {
        System.out.println("请输入原文本内容：新文本内容 修改文件");
        System.out.println("以stop为标志结束修改");

        var sc = new Scanner(System.in);
        String line = "";
        while (true) {
            line = sc.nextLine();
            if("stop".equals(line)) {
                break;
            }
            String[] editMessage = line.split(":");
            message = message.replace(editMessage[0], editMessage[1]);
        }
    }
}
