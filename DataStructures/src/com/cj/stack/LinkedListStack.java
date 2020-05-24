package com.cj.stack;

import com.cj.linkedlist.Boy;

@SuppressWarnings("all")
public class LinkedListStack {
    //定义头节点
    Boy head = new Boy(0);
    //栈顶
    private Boy top = null;

    public void push(Boy boy) {
        Boy temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(boy);
        top = boy;
    }

    public void show() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
        }

        int temp = top.getNo();
        while (temp == 0) {
            System.out.println(top);
            temp = top.getNo() - 1;
        }
    }

    //栈的遍历需要先将链表进行反转
    //链表反转
    public void reverseList(Boy head) {
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        // 定义一个辅助的指针(变量),帮助遍历原来的链表
        Boy cur = head.getNext();
        // 定义一个变量存储当前节点的下个节点，即指向当前节点[cur]的下个节点
        Boy next = null;
        //定义一个新链表的头结点
        Boy reverseHead = new Boy(0);
        // 遍历原来的链表，每遍历一个节点就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            // 暂时保存当前节点的下一个节点(后续需要使用)
            next = cur.getNext();
            // 将cur的下个节点指向新的链表的最前端
            cur.setNext(reverseHead.getNext());
            // 将cur连接到新的链表上
            reverseHead.setNext(cur);
            // 让cur后移
            cur = next;
        }
        // 将head.next指向reverseHead.next，实现单链表的反转
        head.setNext(reverseHead.getNext());
    }

    //显示栈的情况[遍历栈]，遍历时，需要从栈顶开始显示数据，即从链表尾遍历链表
//将链表进行反转，然后再打印链表
    public void list() {
        // 判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空！！！");
            return;
        }
        // 因为头结点不能动，需要辅助变量来遍历
        reverseList(head);
        Boy temp = head.getNext();
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.getNext();
        }
    }

    //栈空
    public boolean isEmpty() {
        return top == null;
    }
}
