package cn.homework.filemanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * 工具类
 *
 * @author CJ
 * @version 2020-5-28
 */
public class FileMannerUtils {

    public static void searchByWorld() {
        var sc = new Scanner(System.in);
        System.out.print("请输入需要检索的目录位置：");
        String path = sc.nextLine();
        var file = new File(path);

        System.out.print("请输入关键字：");
        String key = sc.nextLine();
        listFiles(file, key);
    }

    public static void searchBySuffix() {
        var sc = new Scanner(System.in);
        System.out.print("请输入需要检索的目录位置：");
        String path = sc.nextLine();
        var file = new File(path);

        System.out.print("请输入后缀名：");
        String suffix = sc.nextLine();
        listSuffixFiles(file, suffix);
    }

    public static void copyDirectory() {
        var sc = new Scanner(System.in);
        System.out.print("请输入源目录：");
        String srcDirectory = sc.nextLine();
        File srcFile = new File(srcDirectory);

        System.out.print("请输入目标位置");
        String destDirectory = sc.nextLine();
        File destFile = new File(destDirectory);

        copySrcPathToDestPath(srcFile, destFile);

    }

    /**
     * 查询
     *
     * @param filePath 指定查询目录
     * @param key      关键字
     */
    private static void listFiles(File filePath, String key) {
        File[] files = filePath.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, key);
            } else {
                if (file.getName().contains(key)) {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
    }

    private static void listSuffixFiles(File filePath, String suffix) {
        File[] files = filePath.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listSuffixFiles(file, suffix);
            } else {
                if (file.getName().endsWith("." + suffix)) {
                    System.out.println(file.getAbsoluteFile());
                }
            }
        }
    }

    private static void copySrcPathToDestPath(File srcFile, File destFile) {
        destFile.mkdirs();

        File[] files = srcFile.listFiles();
        for (File file : files) {
            File dest = new File(destFile, file.getName());
            if (file.isDirectory()) {
                copySrcPathToDestPath(file, dest);
            } else {
                FileInputStream in = null;
                FileOutputStream out = null;
                try {
                    in = new FileInputStream(file);
                    out = new FileOutputStream(dest);
                    byte[] bytes = new byte[1024 * 10];
                    int len = 0;
                    while ((len = in.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    close(out, in);
                }
            }
        }
    }


    private static void close(AutoCloseable... targets) {
        for (AutoCloseable target : targets) {
            try {
                if (target != null) {
                    target.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
