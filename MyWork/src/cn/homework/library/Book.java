package cn.homework.library;

import java.util.Objects;

/**
 * 存放图书
 * @version 2020-5-12
 * @author CJ
 */
public class Book {
    private String num;
    private String bookName;
    private String writer;
    private int stock;

    /**
     *
     * @param num 书籍编号
     * @param bookName 书籍名称
     * @param writer 书籍作者
     * @param stock 书籍库存
     */
    public Book(String num, String bookName, String writer, int stock) {
        this.num = num;
        this.bookName = bookName;
        this.writer = writer;
        this.stock = stock;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getStock() {
        return stock;
    }

    public void setSock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "编号：" + num + '\t' +
                "书名：" + bookName + '\t' +
                "作者：" + writer + '\t' +
                "剩余数量：" + stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName) &&
                Objects.equals(num, book.num) &&
                Objects.equals(writer, book.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, num, writer);
    }
}
