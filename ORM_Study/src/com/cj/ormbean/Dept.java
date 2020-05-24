package com.cj.ormbean;

public class Dept {
    private Integer id;
    private String dname;
    private String adress;

    public Dept(){
    }

    public Dept(String dname, String adress) {
        this.dname = dname;
        this.adress = adress;
    }

    public Dept(Integer id, String dname, String adress) {
        this.id = id;
        this.dname = dname;
        this.adress = adress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
