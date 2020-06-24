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
}
