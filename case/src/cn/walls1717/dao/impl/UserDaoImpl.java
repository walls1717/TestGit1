package cn.walls1717.dao.impl;

import cn.walls1717.dao.UserDao;
import cn.walls1717.domain.User;
import cn.walls1717.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户操作的 Dao
 * @version 2020-6-23
 * @author CJ
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        // 使用 jdbc 操作数据库

        // 定义sql
        String sql = " select * from user ";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        try {
            // 定义 sql
            String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, null, null)";
            template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from user where id = ?";

            template.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 定义模板sql
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历 map
        Set<String> keySet = condition.keySet();
        // 定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            // 排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            // 获取 value
            String value = condition.get(key)[0];

            // 判断 value 是否有值
            if(value != null && !"".equals(value)) {
                // 有值
                sb.append(" and "+ key +" like ? ");
                // 条件的值
                params.add("%" + value + "%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历 map
        Set<String> keySet = condition.keySet();
        // 定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            // 排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            // 获取 value
            String value = condition.get(key)[0];

            // 判断 value 是否有值
            if(value != null && !"".equals(value)) {
                // 有值
                sb.append(" and "+ key +" like ? ");
                // 条件的值
                params.add("%" + value + "%");
            }
        }

        // 添加分页查询
        sb.append(" limit ?, ? ");
        // 添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();

        System.out.println(sql);
        System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}
