package com.cj.linkedlist;

public class SingleLinkedListDemo02 {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "林冲", "豹子头");
        HeroNode2 hero2 = new HeroNode2(2, "鲁智深", "倒把垂杨柳");
        HeroNode2 hero3 = new HeroNode2(3, "宋江", "及时雨");
        HeroNode2 hero4 = new HeroNode2(3, "CJ", "大帅哥");

        SingleLinkedList2 singleLinkedList = new SingleLinkedList2();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.update(hero4);
        singleLinkedList.del(3);
        singleLinkedList.del(2);
        singleLinkedList.del(1);
        singleLinkedList.list();
    }
}

class SingleLinkedList2 {
    HeroNode2 head = new HeroNode2(0, "", "");

    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
    }

    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode2.no) {
                break;
            } else if (temp.next.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("英雄%d已经存在，添加失败", heroNode2.no);
        } else {
            heroNode2.next = temp.next;
            temp.next = heroNode2;
        }
    }

    public void update(HeroNode2 newheroNode2) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newheroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newheroNode2.name;
            temp.nickName = newheroNode2.nickName;
        } else {
            System.out.printf("没有找到编号为%d的英雄\n", newheroNode2.no);
        }
    }

    public void del(int no) {
        HeroNode2 temp = head;
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
            System.out.printf("没有找到你输入的%d号英雄\n", no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
