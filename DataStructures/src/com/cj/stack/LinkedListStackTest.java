package com.cj.stack;

import com.cj.linkedlist.Boy;

public class LinkedListStackTest {
    public static void main(String[] args) {
        Boy boy1 = new Boy(1);
        Boy boy2 = new Boy(2);
        Boy boy3 = new Boy(3);
        LinkedListStack linkedListStack = new LinkedListStack();

        linkedListStack.push(boy1);
        linkedListStack.push(boy2);
        linkedListStack.push(boy3);

        linkedListStack.list();

    }
}
