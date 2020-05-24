package com.cj.jdbc;

import javax.sql.rowset.JdbcRowSet;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 * 测试使用JDBCUtil类简化JDBC开发
 *
 * @author CJ
 */

public class Demo11 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getMysqlConn();
            ps = conn.prepareStatement("insert into t_user (username) values (?)");
            ps.setString(1, "CJaaCJ2sdf3CJ");
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
    }
}