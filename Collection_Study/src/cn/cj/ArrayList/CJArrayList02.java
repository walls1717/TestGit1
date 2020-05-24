package cn.cj.ArrayList;

/**
 * 增加数组扩容
 * @author CJ
 */

public class CJArrayList02<E> {

    private Object[] elementDate;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public CJArrayList02(){
        elementDate = new Object[DEFALT_CAPACITY];
    }

    public CJArrayList02(int capacity){
        elementDate = new Object[capacity];
    }

    public void add(E element){
        if (size == elementDate.length) {
            Object[] newArray = new Object[elementDate.length + (elementDate.length>>1)];
            System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
            elementDate = newArray;
        }
        elementDate[size++] = element;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(elementDate[i]+",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args){
        CJArrayList02 s1 = new CJArrayList02();

        for(int i = 0; i < 30; i++){
            s1.add("CJ" + i);
        }

        System.out.println(s1);
    }
}