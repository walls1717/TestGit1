package com.cj.linkedlist;


public class CircleLinked {
    Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入的数值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy temp = first;
        while (true) {
            System.out.printf("小孩的编号是%d\n", temp.getNo());
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    public void countBoy(int startNum, int countNum, int nums) {
        if (first == null || startNum < 1 || startNum > nums) {
            System.out.println("参数有误，请重新输入");
            return;
        }

        Boy curBoy = first;
        while (true) {
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
        for (int j = 0; j < startNum - 1; j++) {
            first = first.getNext();
            curBoy = curBoy.getNext();
        }
        while (true) {
            if (curBoy == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                curBoy = curBoy.getNext();
            }
            System.out.printf("第%d个小孩出圈\n", first.getNo());
            first = first.getNext();
            curBoy.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩是%d\n", first.getNo());
    }
}
