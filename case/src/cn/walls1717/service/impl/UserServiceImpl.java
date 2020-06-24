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

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            // 遍历数组
            for (String id : ids) {
                // 调用 dao 删除
                dao.delete(Integer.parseInt(id));
            }
        }
    }
}
