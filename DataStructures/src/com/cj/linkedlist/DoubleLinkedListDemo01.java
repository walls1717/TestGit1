package com.cj.linkedlist;

public class DoubleLinkedListDemo01 {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "鲁智深", "倒把垂杨柳");
        HeroNode hero3 = new HeroNode(3, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "CJ", "程序员");
        HeroNode hero5 = new HeroNode(3, "CJ", "程序员");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
//        doubleLinkedList.del(4);
        doubleLinkedList.upadte(hero5);

        doubleLinkedList.showLast(doubleLinkedList.getHead());

    }
}

@SuppressWarnings("all")
class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //不按照顺序添加
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //按照从小到大的顺序添加
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; //标志
        while (true) {
            if (temp.next == null) {
                break;
            }
            //temp.next：temp后面的一个节点，当后面这个节点的no大于将要添加的这个节点，
            //表明将要在这个位置添加该节点
            if (temp.next.no > heroNode.no) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true; //当flag标志为真时，说明想要添加的新节点已经存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号为%d的英雄已经存在", heroNode.no);
        } else {
            //让新的节点跟后面的节点连接起来
            heroNode.next = temp.next;
            //让新的节点跟前面的节点连接起来
            temp.next = heroNode;
            //让新的节点的pre与前面的节点连接起来
            heroNode.pre = temp;
            //如果将要添加的节点位于链表的最后一个，则此语句不用执行
            //此语句的意思是将将要添加的节点的后一个节点的pre指向将要添加的节点
            if (heroNode.next != null) {
                heroNode.next.pre = heroNode;
            }
        }
    }

    public void upadte(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nikeName = heroNode.nikeName;
        } else {
            System.out.printf("没有找到编号为%d的英雄", heroNode.no);
        }
    }

    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //这里我们的代码有问题
            //如果是最后一个节点就不需要执行下面这句话，否则会出现空指针异常
            //temp.next = null
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("");
        }
    }

    public void showLast(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //临时变量：指向除了头节点的第一个节点
        HeroNode temp = head.next;
        //用来存放链表最后一个节点
        HeroNode cur = null;
        while (true) {
            //判断链表是否循环完毕，此时循环完毕，
            //temp指向的是链表最后一个节点的next，也就是说temp为null
            if (temp == null) {
                break;
            }
            //cur = temp在temp = temp.next的前面是因为temp在最后会指向链表最后一个节点的后面
            //如果将cur = temp放在了后面，也就是说把null给了cur，就会空指针
            cur = temp;
            temp = temp.next;
        }

        //得到了链表的最后一个节点后，就可以利用pre来进行反向输出了
        while (true) {
            //head.next.pre的意思是头节点后面的一个节点的pre
            //如果不用head.next在打印的时候就会把头节点也打印进去
            if (cur == head.next.pre) {
                break;
            }
            System.out.println(cur);
            //令cur指向下一个pre
            cur = cur.pre;
        }
    }

    public void showFirst(HeroNode head) {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
