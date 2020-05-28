package cn.homework.notpad;

import java.util.Scanner;

/**
 * 记事本
 * @author CJ
 */
public class Note {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var sc = new Scanner(System.in);
        int tap;
        while (true) {
            System.out.println("1：创建文件，2：保存文件，3：修改文件，4：读取文件，5：退出");
            tap = sc.nextInt();
            switch (tap) {
                case 1:
                    NoteUtils.createFile();
                    break;
                case 2:
                    NoteUtils.saveFile();
                    break;
                case 3:
                    NoteUtils.editFile();
                    break;
                case 4:
                    NoteUtils.openFile();
                    break;
                case 5:
                    System.out.println("谢谢使用");
                    System.exit(0);
                default:
            }
        }
    }
}
