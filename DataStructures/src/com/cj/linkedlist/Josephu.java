package com.cj.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        //测试，看看构件环形链表，链表遍历是否正确
//        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
//        circleSingleLinkedList.addBoy(125); //加入5个小孩节点
//        circleSingleLinkedList.showBoy();
//
//        //测试小孩出圈是否正确
//        circleSingleLinkedList.countBoy(10, 12, 125); //2,4,1,5,3

        CircleLinked circleLinked = new CircleLinked();
        circleLinked.addBoy(5);
        circleLinked.showBoy();
        circleLinked.countBoy(1, 2, 5);
    }
}
