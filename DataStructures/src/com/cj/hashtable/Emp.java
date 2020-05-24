package com.cj.hashtable;

//雇员
class Emp {
    //雇员id
    public int id;
    //雇员名字
    public String name;
    //指向链表下一个
    public Emp next; //默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
