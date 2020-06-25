package cn.walls1717.dao;

import cn.walls1717.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的 Dao
 * @version 2020-6-23
 * @author CJ
 */
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    public List<User> findAll();

    /**
     * 获取用户名密码
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     * @param user 待添加用户
     * @return 是否添加成功
     */
    void addUser(User user);

    /**
     * 根据id 删除
     * @param id
     */
    void delete(int id);

    /**
     * 根据id 查询
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页的记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
