package cn.walls1717.service.impl;

import cn.walls1717.dao.UserDao;
import cn.walls1717.dao.impl.UserDaoImpl;
import cn.walls1717.domain.User;
import cn.walls1717.service.UserService;

import java.util.List;

/**
 * 用户管理的业务
 * @version 2020-6-23
 * @author CJ
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        // 调用 Dao 完成查询
        return dao.findAll();
    }
}
