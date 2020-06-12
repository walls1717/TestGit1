package cn.cj.test;


import cn.cj.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author CJ
 */
public class BeanUtilsTest {

    @Test
    public void test() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "hehe", "male");
            System.out.println(user);
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
