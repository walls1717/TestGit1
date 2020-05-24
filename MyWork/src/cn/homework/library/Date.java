package cn.homework.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 用户
 *
 * @author CJ
 * @version 2020-5-12
 */
class Date {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Book> books = new ArrayList<>();

    protected static void show() {
        System.out.println("1. 添加");
        System.out.println("2. 删除");
        System.out.println("3. 查询");
        System.out.println("4. 显示全部");
        System.out.println("5. 退出");
    }

    /**
     * 添加图书
     */
    protected static void addBook() {
        System.out.println("输入你需要添加图书的编号，书名，作者，数量（用空格隔开）");
        //输入需要添加的图书信息，并转化为字符串数组，方便计算
        String name = sc.nextLine();
        String[] nameArr = name.split(" ");

        //将图书库存转化为integer类型，方便计算
        int nameInt = Integer.parseInt(nameArr[3]);
        var book = new Book(nameArr[0], nameArr[1], nameArr[2], nameInt);

        //判断ArrayList是否为空，如果为空，直接添加，如果不为空，设置库存
        Iterator<Book> iterator = books.iterator();
        if (!books.isEmpty() && is(book)) {
            while (iterator.hasNext()) {
                Book arr = iterator.next();
                if (arr.equals(book)) {
                    arr.setSock((arr.getStock() + nameInt));
                }
            }
        } else {
            books.add(book);
        }
    }

    /**
     * 判断图书馆中是否已经存在了这种图书
     * @param book 需要判断的图书
     * @return 返回真假
     */
    private static boolean is(Book book) {
        for(Book b : books) {
            if(b.equals(book)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除图书
     */
    protected static void delBook() {
        System.out.println("请输入需要删除的图书编号");
        String num = sc.nextLine();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getNum().equals(num)) {
                if (book.getStock() == 1) {
                    books.remove(book);
                } else {
                    book.setSock(book.getStock() - 1);
                }
            }
        }
    }

    /**
     * 展示图书
     */
    protected static void showList() {
        System.out.println(books);
    }

    /**
     * 查询
     */
    protected static void search() {
        System.out.println("输入你需要查询的书籍编号：");
        String name = sc.nextLine();
        for(Book b : books) {
            if(b.getNum().equals(name)) {
                System.out.println(b);
            }
        }
    }
}
