package cn.walls1717.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CJ
 */
public class User {

    private String name;
    private int age;
    private Date birthday;

    public String getBirStr() {
        // 格式化日期对象
        if (birthday != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 返回字符串
            return sdf.format(birthday);
        } else {
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
