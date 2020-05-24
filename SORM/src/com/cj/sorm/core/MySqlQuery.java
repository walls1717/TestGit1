package com.cj.sorm.core;

import com.cj.po.Emp;
import com.cj.sorm.bean.ColumnInfo;
import com.cj.sorm.bean.TableInfo;
import com.cj.vo.EmpVO;
import com.mysql.cj.protocol.x.OkBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责针对Mysql数据库的查询
 *
 * @author CJ
 */
@SuppressWarnings("all")
public class MySqlQuery extends Query {
    public static void testDML(){
        Emp e = new Emp();
        e.setEmpname("lily");
        e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
        e.setAge(13);
        e.setSalary(234.23);
        e.setId(1);
        new MySqlQuery().delete(e);
        new MySqlQuery().insert(e);
        new MySqlQuery().update(e, new String[]{"empname", "age", "salary"});
    }

    public static void testQueryRows(){
        //        List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?", Emp.class, new Object[]{10, 6000});
//        for(Emp e:list){
//            System.out.println(e.getEmpname());
//        }

        String sql2 = "select e.id,e.empname,salary+bonus 'xinshui',age, d.dname 'deptName',d.address'deptAddress' from emp e "
                + "join dept d on e.deptId=d.id ";
        List<EmpVO> list2 = new MySqlQuery().queryRows(sql2, EmpVO.class, null);
        for(EmpVO e:list2){
            System.out.println(e.getEmpname()+"---"+e.getDeptAddress()+"---"+e.getXinshui());
        }
    }

    public static void main(String[] args){
        Number obj = (Number) new MySqlQuery().queryValue("select count(*) from emp where salary>?", new Object[]{1000});
//        Object obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[]{1000});
        System.out.println(obj.doubleValue());

//        testQueryRows();
    }

    @Override
    public Object queryPagenate(int pageNum, int size) {
        return null;
    }
}
