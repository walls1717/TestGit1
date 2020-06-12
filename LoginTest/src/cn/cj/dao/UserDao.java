package cn.cj.dao;

import cn.cj.domain.User;
import cn.cj.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中 User 表的类
 * @version 2020-6-12
 * @author CJ
 */
public class UserDao {

    /**
     * 声明 JDBCTemplate 对象共用
     */
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user 包含用户全部数据，如果没有查询到，返回 null
     */
    public User login(User loginUser) {
        try {
            // 编写 sql
            String sql = " select * from user where username = ? and password = ? ";
            // 调用 query 方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
