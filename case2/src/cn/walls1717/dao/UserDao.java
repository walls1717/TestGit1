package cn.walls1717.dao;

import cn.walls1717.domain.User;

import java.util.List;

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
     * 修改用户信息
     */
    public void update();
}
