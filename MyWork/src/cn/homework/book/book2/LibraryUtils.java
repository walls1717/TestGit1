package cn.homework.book.book2;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 图书馆工具类
 *
 * @author CJ
 * @version 2020-5-18
 */
public class LibraryUtils {
    public static ArrayList<Books> booksArrayList = new ArrayList<>();

    /**
     * 启动：循环购买，直到用户自主结束程序
     */
    public static void start() {
        init();
        //先打印一遍初始列表
        for (Books book : booksArrayList) {
            System.out.println(book);
        }
        while (true) {
            buy();
        }
    }

    /**
     * 初始化
     * 实现存放 3 种图书
     */
    private static void init() {
        var book1 = new Books(101, "Java基础入门", "清华大学出版社", 44.5, 4450, 100);
        var book2 = new Books(102, "Java编程思想", "机械工业出版社", 108.0, 5400.0, 50);
        var book3 = new Books(103, "疯狂Java讲义", "电子工业出版社", 99.0, 9000.0, 100);
        booksArrayList.add(book1);
        booksArrayList.add(book2);
        booksArrayList.add(book3);
    }

    /**
     * 查找出图书
     * @return 返回指定图书编号的图书信息
     */
    private static Books search() {
        System.out.print("请输入图书编号：");
        //接收一个图书编号
        int id = new Scanner(System.in).nextInt();
        //循环查找图书列表，直到图书 id 与需要查找的 id 相同，返回图书信息。
        for (Books book : booksArrayList) {
            if (book.getId() == id) {
                return book;
            }
        }
        //如果没有找到返回null
        return null;
    }

    private static void buy() {
        //将找到的图书信息存储到变量 books 中
        Books books = search();

        //如果查找的这个图书存在，就输入需要购买几本书，并将其保存在本地
        if (books != null) {

            //获取需要购买的数量
            System.out.println("当前图书信息：" + books);
            System.out.print("请输入购买数量：");
            int num = new Scanner(System.in).nextInt();

            //判断库存是否充足
            if (books.getNumber() >= num) {
                //先将库存数量减少
                books.setNumber(books.getNumber() - num);
                //创建一个新的图书对象，将需要保存的购买信息存储起来
                var newBook = new Books(books.getId(), books.getName(), books.getPublish(), books.getMoney(), books.getMoney() * books.getNumber(), books.getNumber());

                //初始化文件名
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                String fileName = "销售记录" + dateFormat.format(date) + ".csv";

                try {
                    //判断文件是否已经存在，如果存在，直接追加保存在该文件中即可
                    var in = new FileInputStream(fileName);
                    if (in != null) {
                        in.close();
                        saveBooks(fileName, true, newBook);
                    }
                } catch (Exception e) {
                    //如果不存在，创建新文件
                    saveBooks(fileName, false, newBook);
                }
            } else {
                System.out.println("库存不足！");
            }
        } else {
            System.out.println("没有此图书！");
        }
    }

    /**
     * 将图书的购买信息保存到本地文件，用label判断是否追加
     *
     * @param fileName 文件名称
     * @param label    判断是否追加
     * @param books    需要保存的图书
     */
    private static void saveBooks(String fileName, boolean label, Books books) {
        BufferedOutputStream out = null;
        StringBuilder sbf = new StringBuilder();

        try {
            //如果文件已经存在，直接追加信息
            if (label) {
                out = new BufferedOutputStream(new FileOutputStream(fileName, true));
                //文件不存在，创建文件
            } else {
                //因为 微软的 excel 直接打开 UTF-8 的文件可能出现乱码情况
                //所以要加上表头，以防乱码
                byte[] uft8bom={(byte)0xef,(byte)0xbb,(byte)0xbf};
                out = new BufferedOutputStream(new FileOutputStream(fileName));
                out.write(uft8bom);
                out.flush();

                //新文件加上表头信息
                String[] filedSort = {"图书编号", "图书名称", "图书出版社", "图书单价", "图书库存", "图书总价"};
                for (String field : filedSort) {
                    sbf.append(field).append(",");
                }
            }
            //添加图书信息
            sbf.append("\r\n");
            sbf.append(books.getId()).append(",");
            sbf.append(books.getName()).append(",");
            sbf.append(books.getPublish()).append(",");
            sbf.append(books.getMoney()).append(",");
            sbf.append(books.getNumber()).append(",");
            sbf.append(books.getTotalMoney());

            String result = sbf.toString();
            byte[] bytes = result.getBytes();

            out.write(bytes);

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
