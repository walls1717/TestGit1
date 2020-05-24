package cn.cj.test;

/**
 * 测试StringBuilder/StringBuffer
 * 可变的字符序列
 * @author CJ
 */

public class TestStringBuilder {
    public static void main(String[] args){
        String str;

        //StringBuilder线程不安全，效率高（一般使用它）；StringBuffer线程安全，效率低
        StringBuilder sb = new StringBuilder("abcdefgh");
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(2, 'M');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
    }
}
