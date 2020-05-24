package com.cj.vo;

public class EmpVO {
//    select e.id,e.empname,salary+bonus 'xinshui',age, d.dname 'deptName',d.address'deptAddress' from emp e
//    join dept d on e.deptId=d.id;

    private Integer id;
    private String empname;
    private Double xinshui;
    private Integer age;
    private String deptName;
    private String deptAddress;

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

    public Double getXinshui() {
        return xinshui;
    }

    public void setXinshui(Double xinshui) {
        this.xinshui = xinshui;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public EmpVO(Integer id, String empname, Double xinshui, Integer age, String deptName, String deptAddress) {
        this.id = id;
        this.empname = empname;
        this.xinshui = xinshui;
        this.age = age;
        this.deptName = deptName;
        this.deptAddress = deptAddress;
    }

    public EmpVO(){}

}
