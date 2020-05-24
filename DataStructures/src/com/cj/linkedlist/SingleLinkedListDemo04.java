package com.cj.linkedlist;

import java.util.Scanner;

public class SingleLinkedListDemo04 {
    public static void main(String[] args) {
        HeroNode4 hero1 = new HeroNode4(1, "宋江", "及时雨");
        HeroNode4 hero2 = new HeroNode4(2, "卢俊义", "玉麒麟");
        HeroNode4 hero3 = new HeroNode4(3, "吴用", "智多星");
        HeroNode4 hero4 = new HeroNode4(4, "林冲", "豹子头");
        HeroNode4 hero5 = new HeroNode4(4, "CJ", "...");

        SingleLinkedList4 singleLinkedList4 = new SingleLinkedList4();

        singleLinkedList4.addByOrder(hero1);
        singleLinkedList4.addByOrder(hero4);
        singleLinkedList4.addByOrder(hero2);
        singleLinkedList4.addByOrder(hero3);
        singleLinkedList4.update(hero5);
        singleLinkedList4.del(1);
        singleLinkedList4.del(2);
        singleLinkedList4.del(3);
        singleLinkedList4.del(4);

        singleLinkedList4.list();
    }
}

class SingleLinkedList4 {
    HeroNode4 head = new HeroNode4(0, "", "");

    public void add(HeroNode4 heroNode4) {
        HeroNode4 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode4;
    }

    public void addByOrder(HeroNode4 heroNode4){
        HeroNode4 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode4.no) {
                break;
            } else if (temp.next.no == heroNode4.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("没有找到编号为%d的英雄", heroNode4.no);
        } else {
            heroNode4.next = temp.next;
            temp.next = heroNode4;
        }
    }

    public void update(HeroNode4 heroNode4){
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode4 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode4.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode4.name;
            temp.nikeName = heroNode4.nikeName;
        } else {
            System.out.println("");
        }
    }

    public void del(int no) {
        HeroNode4 temp = head;
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
            System.out.println("");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode4 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode4 {
    public int no;
    public String name;
    public String nikeName;
    public HeroNode4 next;

    public HeroNode4(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "HeroNode4{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
