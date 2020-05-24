package com.cj.iterator;

/**
 * 自定义的迭代器
 *
 * @author CJ
 */

public interface MyIterator {
    void first(); //将游标指向第一个元素
    void next(); //将游标指向下一个元素
    boolean hasNext(); //判断是否存在下一个元素
    boolean isFirst();
    boolean isLast();
    Object getCurrentObj(); //获取当前游标指向的对象
}
