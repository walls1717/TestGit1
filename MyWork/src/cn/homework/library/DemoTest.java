package cn.homework.library;

import java.util.Scanner;

/**
 * 测试类
 * @version 2020-5-12
 * @author CJ
 */
public class DemoTest {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        while(true) {
            Date.show();
            var sc = new Scanner(System.in).nextInt();
            switch (sc) {
                case 1:
                    Date.addBook();
                    break;
                case 2:
                    Date.delBook();
                    break;
                case 3:
                    Date.search();
                    break;
                case 4:
                    Date.showList();
                    break;
                case 5:
                    System.exit(0);
                default:
            }
        }
    }
}
