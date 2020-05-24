package com.cj.linkedlist;

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    //英雄的编号
    public int no;
    //英雄的名字
    public String name;
    //英雄的称号
    public String nikeName;
    //指向下一个节点
    public HeroNode next;
    //指向前一个节点
    public HeroNode pre;

    //构造器
    public HeroNode(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    //为了显示方便，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
