package cn.walls1717.service.impl;

import cn.walls1717.dao.UserDao;
import cn.walls1717.dao.impl.UserDaoImpl;
import cn.walls1717.domain.PageBean;
import cn.walls1717.domain.User;
import cn.walls1717.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageBean<User> findUserByPage(String currentPage1, String rows1, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(currentPage1);
        int rows = Integer.parseInt(rows1);

        if (currentPage <= 0) {
            currentPage = 1;
        }

        // 创建空的 pageBean 对象
        PageBean<User> pb = new PageBean<User>();
        // 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 调用 dao 查询总记录数
        int  totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        // 调用 dao 查询 list 集合
        // 计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        // 计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
