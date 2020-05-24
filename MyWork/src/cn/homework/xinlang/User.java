package cn.homework.xinlang;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * 用户类
 * @version 2020-5-10
 * @author CJ
 */
public class User {
    /**
     * 名字
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 重复密码
     */
    private String rePassword;
    /**
     * 出生日期
     */
    private LocalDate birthday;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 邮箱
     */
    private String eMail;

    public User(String name, String password, String rePassword, LocalDate birthday, String phoneNum, String eMail) {
        //将日期按照格式输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = birthday.format(formatter);
        LocalDate date = LocalDate.parse(text, formatter);

        this.name = name;
        this.password = password;
        this.rePassword = rePassword;
        this.birthday = date;
        this.phoneNum = phoneNum;
        this.eMail = eMail;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword() {
        this.rePassword = rePassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return
                "姓名：" + name + '\n' +
                "密码：" + password + '\n' +
                "出生日期：" + birthday + '\n' +
                "电话号码：" + phoneNum + '\n' +
                "邮箱：" + eMail + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(phoneNum, user.phoneNum) &&
                Objects.equals(eMail, user.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, phoneNum, eMail);
    }
}
