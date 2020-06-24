package cn.walls1717.dao.impl;

import cn.walls1717.dao.UserDao;
import cn.walls1717.domain.User;
import cn.walls1717.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 用户操作的 Dao
 * @version 2020-6-23
 * @author CJ
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    private User user;

    @Override
    public List<User> findAll() {
        // 使用 jdbc 操作数据库

        // 定义sql
        String sql = " select * from user ";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void update() {
        String sql = "update user set gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getGender(),
                user.getAge(), user.getAddress(),
                user.getQq(), user.getEmail(), user.getId());
    }
}
