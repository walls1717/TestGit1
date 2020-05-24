package com.cj.linkedlist;

public class SingleLinkedListDemo03 {
    public static void main(String[] args) {
        HeroNode3 hero1 = new HeroNode3(1, "林冲", "豹子头");
        HeroNode3 hero2 = new HeroNode3(2, "鲁智深", "倒把垂杨柳");
        HeroNode3 hero3 = new HeroNode3(3, "宋江", "及时雨");
        HeroNode3 hero4 = new HeroNode3(3, "CJ", "aaa");
        SingleLinkedList3 singleLinkedList3 = new SingleLinkedList3();
        singleLinkedList3.add(hero1);
        singleLinkedList3.add(hero2);
        singleLinkedList3.add(hero3);
        singleLinkedList3.del(1);
        singleLinkedList3.del(2);
        singleLinkedList3.del(3);
        singleLinkedList3.list();
        singleLinkedList3.update(hero4);
        System.out.println();
        singleLinkedList3.list();
    }
}

class SingleLinkedList3 {
    HeroNode3 head = new HeroNode3(0, "", "");

    //不考虑排序添加一个英雄
    public void add(HeroNode3 heroNode3) {
        HeroNode3 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode3;
    }

    //考虑排序添加
    public void addByOrder(HeroNode3 heroNode3) {
        HeroNode3 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode3.no) {
                break;
            } else if (temp.next.no == heroNode3.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("没有找到编号为%d的英雄", heroNode3.no);
        } else {
            heroNode3.next = temp.next;
            temp.next = heroNode3;
        }
    }

    //删除
    public void del(int no){
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode3 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到%d英雄", no);
        }
    }

    //修改一个英雄
    public void update(HeroNode3 heroNode3) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode3 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode3.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode3.name;
            temp.nikeName = heroNode3.nikeName;
        } else {
            System.out.printf("没有找到编号为%d的英雄", heroNode3.no);
        }
    }

    //遍历
    public void list() {
        if (head.next == null) {
            System.out.println("列表为空");
        }
        HeroNode3 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//每个HeroNode3对象就是一个节点
class HeroNode3 {
    public int no;
    public String name;
    public String nikeName;
    public HeroNode3 next;

    public HeroNode3(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    //重写toString方法，方便打印
    @Override
    public String toString() {
        return "HeroNode3{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
