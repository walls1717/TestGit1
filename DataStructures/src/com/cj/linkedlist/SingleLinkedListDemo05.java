package com.cj.linkedlist;

public class SingleLinkedListDemo05 {
    public static void main(String[] args) {
        HeroNode5 hero1 = new HeroNode5(1, "宋江", "及时雨");
        HeroNode5 hero2 = new HeroNode5(2, "卢俊义", "玉麒麟");
        HeroNode5 hero3 = new HeroNode5(3, "吴用", "智多星");
        HeroNode5 hero4 = new HeroNode5(4, "林冲", "豹子头");
        HeroNode5 hero5 = new HeroNode5(4, "CJ", "豹子头");

        SingleLinkedList5 singleLinkedList5 = new SingleLinkedList5();

        singleLinkedList5.addByOrder(hero3);
        singleLinkedList5.addByOrder(hero1);
        singleLinkedList5.addByOrder(hero2);
        singleLinkedList5.addByOrder(hero4);
        singleLinkedList5.update(hero5);
        singleLinkedList5.del(1);
        singleLinkedList5.del(2);
        singleLinkedList5.del(3);
        singleLinkedList5.del(4);

        singleLinkedList5.list();
    }
}

class SingleLinkedList5 {
    private HeroNode5 head = new HeroNode5(1, "", "");

    public void add(HeroNode5 heroNode5) {
        HeroNode5 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode5;
    }

    public void addByOrder(HeroNode5 heroNode5) {
        HeroNode5 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode5.no) {
                break;
            }
            if (temp.next.no == heroNode5.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("编号为%d的英雄已经存在", heroNode5.no);
        } else {
            heroNode5.next = temp.next;
            temp.next = heroNode5;
        }
    }

    public void update(HeroNode5 heroNode5) {
        HeroNode5 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode5.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode5.name;
            temp.nikeName = heroNode5.nikeName;
        } else {
            System.out.printf("没有找到编号为%d的英雄", heroNode5.no);
        }
    }

    public void del(int no) {
        if (head.next == null) {
            System.out.println("");
        }
        HeroNode5 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号为%d的英雄", no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode5 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class HeroNode5 {
    public int no;
    public String name;
    public String nikeName;
    public HeroNode5 next;

    public HeroNode5(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "HeroNode5{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
