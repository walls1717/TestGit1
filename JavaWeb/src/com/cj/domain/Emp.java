package com.cj.domain;

import java.util.Date;
import java.util.EnumMap;

/**
 * @version 2020-5-28
 * @author CJ
 */
public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private Double salary;
    private Date joinDate;
    private Integer deptId;

    public Emp() {}

    public Emp(Integer id, String name, String gender, Double salary, Date joinDate, Integer deptId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.joinDate = joinDate;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                ", deptId=" + deptId +
                '}';
    }
}
