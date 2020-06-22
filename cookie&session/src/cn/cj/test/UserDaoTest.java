package cn.cj.test;

import cn.cj.dao.UserDao;
import cn.cj.domain.User;
import org.junit.Test;

/**
 * 测试 UserDao
 * @version 2020-6-22
 * @author CJ
 */
public class UserDaoTest {

    @Test
    public void test() {
        User loginUser = new User();

        loginUser.setUsername("Jack");
        loginUser.setPassword("123");

        UserDao userDao = new UserDao();

        User login = userDao.login(loginUser);

        System.out.println(login);
    }
}
