package cn.cj.collection;

import java.util.*;

/**
 * 测试表格数据的存储
 * ORM思想的简单实验：map表示一行数据， 多行数据是多个map；将多个map放到list中
 * @author CJ
 */

public class TestStoreDate {
    public static void main(String[] args){

        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1001);
        row1.put("name", "张三");
        row1.put("salary", 20000);
        row1.put("Date", "2019.9.9");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 1002);
        row2.put("name", "李四");
        row2.put("salary", 30000);
        row2.put("Date", "2010.4.2");

        Map<String, Object> row3 = new HashMap<>();
        row3.put("id", 1003);
        row3.put("name", "王五");
        row3.put("salary", 3000);
        row3.put("Date", "2020.4.2");

        List<Map<String, Object>> table1 = new ArrayList<>();
        table1.add(row1);
        table1.add(row2);
        table1.add(row3);
        for(Map<String, Object> row:table1){
            Set<String> keyset = row.keySet();
            for(String key:keyset){
                System.out.print(key+":"+row.get(key)+"\t");
            }
            System.out.println();
        }

    }
}
