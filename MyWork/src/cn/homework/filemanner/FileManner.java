package cn.homework.filemanner;

import java.util.Scanner;

/**
 * 文件管理器
 * @author CJ
 */
public class FileManner {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var sc = new Scanner(System.in);
        int tap;
        while (true) {
            System.out.println("1：指定关键字检索文件 2：指定后缀名检索文件 3：复制文件/目录 4：退出");
            tap = sc.nextInt();
            switch (tap) {
                case 1:
                    FileMannerUtils.searchByWorld();
                    break;
                case 2:
                    FileMannerUtils.searchBySuffix();
                    break;
                case 3:
                    FileMannerUtils.copyDirectory();
                    break;
                case 4:
                    System.out.println("谢谢！");
                    System.exit(0);
                default:
            }
        }
    }
}
