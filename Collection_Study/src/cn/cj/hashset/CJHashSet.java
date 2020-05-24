package cn.cj.hashset;

import cn.cj.hashmap.CJHashMap;

import java.util.HashMap;

/**
 * 手动实现一个HashSet，更深刻理解HashSet底层原理
 * @author CJ
 */

public class CJHashSet {
    HashMap map;

    private static final Object PRESENT = new Object();

    public CJHashSet(){
        map = new HashMap();
    }
    public int size(){
        return map.size();
    }
    public void add(Object o){
        map.put(o, PRESENT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Object key:map.keySet()){
            sb.append(key+",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args){
        CJHashSet set = new CJHashSet();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("dd");
        System.out.println(set);
        System.out.println(set.size());
    }
}
