package com.cj.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Object[] 来封装一条记录
 * 使用List<Object[]>封装多条记录
 *
 * @author CJ
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
//                System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
                Object[] objs = new Object[3]; //一个Object数组封装了一条记录信息
                objs[0] = rs.getString(1);
                objs[1] = rs.getObject(2);
                objs[2] = rs.getObject(3);

                list.add(objs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }

        for (Object[] objs : list) {
            System.out.println("" + objs[0] + "---" + objs[1] + "---" + objs[2]);
        }
    }
}
