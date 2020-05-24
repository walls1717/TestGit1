package cn.homework.xinlang;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * 测试类
 *
 * @author CJ
 * @version 2020-5-10
 */
public class DemoTest {
    private static HashSet<User> usersDate = new HashSet<>();

    public static void main(String[] args) {
        init();
        create();
    }

    /**
     * 模拟已经存在的用户
     */
    private static void init() {
        var init = new User("CJ", "123",
                "123", LocalDate.of(2000, 4, 16),
                "18039588916", "123@qq.com");
        usersDate.add(init);
    }

    /**
     * 创建账户
     */
    private static void create() {
        var user = XinLangTools.input();
        if(usersDate.add(user)) {
            usersDate.add(user);
            System.out.println("注册结果：创建成功！");
        } else {
            System.out.println("注册结果：账户已经存在！");
        }
    }
}
