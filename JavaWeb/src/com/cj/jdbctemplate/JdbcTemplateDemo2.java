package com.cj.jdbctemplate;

import com.cj.domain.Emp;
import com.cj.utils.JdbcUtils2;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @version 2020-5-28
 * @author CJ
 */
public class JdbcTemplateDemo2 {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils2.getDataSource());

    /**
     * 修改一条记录
     */
    @Test
    public void test1() {
        // 定义 sql
        String sql = " update emp set salary = 10000 where id = 1 ";
        // 执行 sql
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2() {
        String sql = " insert into emp (id, name, dept_id) values (?, ?, ?) ";
        int count = template.update(sql, 7, "sb", 1);
        System.out.println(count);
    }

    /**
     * 删除一条记录
     */
    @Test
    public void test3() {
        String sql = " delete from emp where id = ? ";
        int count = template.update(sql, 7);
        System.out.println(count);
    }

    /**
     * 查询 id = 1 的记录，将其封装为 map
     * 注意：这个方法查询的结果集只能为1
     */
    @Test
    public void test4() {
        String sql = " select * from emp where id = ? ";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, 1);
        System.out.println(stringObjectMap);
    }

    /**
     * 查询所有记录，将其封装为 list
     */
    @Test
    public void test5() {
        String sql = "select * from emp ";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 查询所有记录，将其封装为 Emp 对象的 List 集合
     */
    @Test
    public void test6() {
        String sql = " select * from emp ";
       List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                double salary = resultSet.getDouble("salary");
                Date joinDate = resultSet.getDate("join_date");
                int deptId = resultSet.getInt("dept_id");

                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoinDate(joinDate);
                emp.setDeptId(deptId);

                return emp;
            }
        });

        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 简化操作
     */
    @Test
    public void test7() {
        String sql = " select * from emp ";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     */
    @Test
    public void test8() {
        String sql = " select count(id) from emp ";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
