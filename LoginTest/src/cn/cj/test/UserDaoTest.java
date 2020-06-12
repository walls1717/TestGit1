package cn.cj.test;


import cn.cj.dao.UserDao;
import cn.cj.domain.User;
import org.junit.Test;

/**
 * 测试 UserDao
 * @version 2020-6-12
 * @author CJ
 */
public class UserDaoTest {

    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123111");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
