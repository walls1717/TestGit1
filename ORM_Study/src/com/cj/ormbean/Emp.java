package com.cj.ormbean;

import java.util.Date;

public class Emp { //表结构和类对应
    private Integer id;
    private String empname;
    private Integer age;
    private double salary;
    private Date birthday;
    private Integer deptId;

    public Emp(){
    }

    public Emp(String empname, Integer age, double salary, Date birthday, Integer deptId) {
        this.empname = empname;
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
        this.deptId = deptId;
    }

    public Emp(Integer id, String empname, Integer age, double salary, Date birthday, Integer deptId) {
        this.id = id;
        this.empname = empname;
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
        this.deptId = deptId;
    }

    public Emp(String empname, double salary, Integer age) {
        this.empname = empname;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
