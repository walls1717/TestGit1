package cn.cj.test.arrays;

/**
 * 测试数组的拷贝
 * @auhtor CJ
 */

public class Test04 {
    public static void main(String[] args){
        String[] str = {"阿里", "京东","百度"};
        //removeElment(str, 1);
        str = extendRange(str);
    }
    //测试数组的拷贝
    public static void testBasicCopy(){
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 2, s2, 6, 3);

        for(int i = 0; i < s2.length; i++){
            System.out.println(i+"---"+s2[i]);
        }
    }

    //删除数组中指定索引位置的元素，并将原数组返回
    public static String[] removeElment(String[] s, int index){
        System.arraycopy(s, index+1, s, index, s.length-index-1);
        s[s.length-1] = null;
        for(int i = 0; i < s.length; i++){
            System.out.println(i+"---"+s[i]);
        }
        return s;
    }

    //数组的扩容
    public static String[] extendRange(String[] s1){

        String[] s2 = new String[s1.length + 10];

        System.arraycopy(s1, 0, s2, 0, s1.length);

        for(String temp:s2){
            System.out.println(temp);
        }
        return s2;
    }
}
