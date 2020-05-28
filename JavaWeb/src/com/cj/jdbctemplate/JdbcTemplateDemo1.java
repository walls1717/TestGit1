package com.cj.jdbctemplate;

import com.cj.utils.JdbcUtils2;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 * @version 2020-5-28
 * @author CJ
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 创建 JdbcTemplate 对象
        JdbcTemplate template = new JdbcTemplate(JdbcUtils2.getDataSource());
        // 定义 sql
        String sql = " update account set balance = 5000 where id = ? ";
        // 调用方法
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
