package cn.cj.ArrayList;

/**
 * 增加set和get方法
 * 增加数组边界的检查
 *
 * @author CJ
 */

public class CJArrayList03<E> {

    private Object[] elementDate;//定义一个Object型
    private int size;//用来定义长度

    private static final int DEFALT_CAPACITY = 10;//数组长度的常量

    //构造器，创建一个新的数组，默认长度为10
    public CJArrayList03(){
        elementDate = new Object[DEFALT_CAPACITY];
    }

    //有参数的构造器，可以自己定义数组长度
    public CJArrayList03(int capacity){
        //如果传递的长度小于零，抛出异常
        if (capacity < 0) {
            throw new RuntimeException();
            //如果长度等于零，就创建一个默认长度为10的数组
        } else if (capacity == 0) {
            elementDate = new Object[DEFALT_CAPACITY];
            //传递的长度正常的话，就按照传递的长度创建数组
        }else{
            elementDate = new Object[capacity];
        }
    }

    //数组扩容的方法
    public void add(E element){
        //如果长度等于这个数组的长度了，就进行扩容
        if (size == elementDate.length) {
            //创建一个新的数组，大小是原数组大小加上原数组大小的二分之一
            Object[] newArray = new Object[elementDate.length + (elementDate.length>>1)];
            //将原数组内容原封不动的copy到新数组中
            System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
            //并使新数组重新给elementDate
            elementDate = newArray;
        }
        elementDate[size++] = element;//将数组元素存入elementDate中
    }

    //检查输入的索引是否合法
    public void checkRange(int index){
        //索引合法判断[0,size)
        if (index < 0 || index > size - 1) {
            //如果输入的索引是负数或者超过数组长度就抛出异常
            throw new RuntimeException();
        }
    }

    //获得指定索引处的元素
    public E get(int index){
        return (E)elementDate[index];
    }
    //修改指定索引处的元素
    public void set(E element, int index){
        checkRange(index);//先进行索引判断，索引合法了执行，不合法直接抛出异常
        elementDate[index] = element;//将输入的元素在指定位置修改
    }

    //重写toString方法，用来打印数组每一个元素
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();//创建一个可变字符串
        sb.append("[");
        //依次打印数组每一个元素
        for(int i = 0; i < size; i++){
            sb.append(elementDate[i]+",");
        }
        //将最后一个字符替换为指定字符
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();//返回数组
    }

    public static void main(String[] args){
        CJArrayList03 s1 = new CJArrayList03();//调用空构造器，默认数组长度为10

        //此时我要打印30个数，会调用数组扩容
        for(int i = 0; i < 30; i++){
            s1.add("CJ" + i);
        }
        s1.set("ddd", 10);
        System.out.println(s1);
        System.out.println(s1.get(30));
    }
}