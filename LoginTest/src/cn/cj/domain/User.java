package cn.cj.domain;

/**
 * 用户实体类
 * @version 2020-6-12
 * @author CJ
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String gender;

    public void setHehe(String gender) {
        this.gender = gender;
    }

    public String getHehe() {
        return gender;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
