package cn.walls1717.service;

import cn.walls1717.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 * @version 2020-6-23
 * @author CJ
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    public List<User> findAll();

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 保存对象
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id 删除
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据 id 查询
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除
     * @param ids
     */
    void delSelectedUser(String[] ids);
}
