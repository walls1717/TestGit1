package com.cj.linkedlist;

import java.util.Stack;

@SuppressWarnings("all")
public class SingleLinkedListDemo01 {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(4, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "sb", "豹子头");
        HeroNode hero6 = new HeroNode(1, "cj", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero5);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        merge(singleLinkedList.getHead(), singleLinkedList2.getHead());

        //测试单链表的反转功能
//        System.out.println("原来链表的情况");
//        singleLinkedList.list();

//        System.out.println("测试逆序打印单链表, 没有改变链表本身的结构");
//        reversePrint(singleLinkedList.getHead());

//        System.out.println("反转单链表");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        /*
        //加入按照编号的顺序
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        System.out.println("修改前的显示情况");
        singleLinkedList.list();
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "小麒麟");
        singleLinkedList.update(newHeroNode);

        //删除一个节点
        singleLinkedList.del(4);
        singleLinkedList.del(1);


        //显示
        System.out.println("修改后的显示情况");
        singleLinkedList.list();

        //测试，求单链表节点个数
        System.out.println("有效的节点个数："+getLength(singleLinkedList.getHead()));

        //测试，看看是否得到了倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println("res="+res);
         */
    }

    //合并两个链表，并按照顺序打印
    public static void merge(HeroNode head1, HeroNode head2) {
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;

        HeroNode newHead = new HeroNode(0,"", "");
        if(head1.next == null){
            newHead.next = head2.next;
        }else if (head2.next == null){
            newHead.next = head1.next;
        }
        HeroNode temp3 = newHead;
        while(temp1 != null || temp2 != null){
            if(temp1 == null && temp2 != null){
                temp3.next = temp2;
                temp2 = temp2.next;
            }else if(temp2 == null && temp1 != null){
                temp3.next = temp1;
                temp1 = temp1.next;
            }else {
                if (temp1.no <= temp2.no) {
                    temp3.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp3.next = temp2;
                    temp2 = temp2.next;
                }
            }
            temp3 = temp3.next;
        }
        HeroNode temp = newHead.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }

    //使用栈逆序打印链表
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return; //空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; //cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //先进后出
        }
    }

    //将单链表进行反转
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助的变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; //指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next; //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next; //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur连接到新的链表上
            cur = next; //让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    //查找单链表中倒数第K个节点
    //思路：
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index表示倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总长度 getLength
    //4.得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    //5.如果找到了就返回该节点，否则返回空
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null; //没有找到
        }
        //第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历 size-index 位置，就是我们倒数第k个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next; //3 //3-1 = 2
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //方法：获取到单链表的节点个数（如果是带头节点的链表，需求不统计头节点）

    /**
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量，这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //显示链表[遍历]
    public static void list(SingleLinkedList singleLinkedList) {
        //先判断链表是否为空
        if (singleLinkedList.getHead().next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = singleLinkedList.getHead().next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}


//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号的顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next域指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //第二种添加英雄的方式，根据排名将英雄插入到指定的位置
    //（如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助变量来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //标志添加的标号是否存在，默认为false
        while (true) {
            if (temp.next == null) { //说明temp已经再链表的最后
                break; //
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) { //说明希望添加的heroNode的编号已经存在
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了，不能加了\n", heroNode.no);
        } else {
            //插入到链表中， temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no不能修改
    //说明
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号来找
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nikeName = newHeroNode.nikeName;
        } else { //没有找到
            System.out.printf("没有找到编号为%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    //思路
    //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2.说明我们在比较时，是temp.next.no和需要删除的节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; //标志是否找到待删除节点
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }
    }

    //显示链表[遍历]
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}

