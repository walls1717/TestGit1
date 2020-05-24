package com.cj.hashtable;

//表示一条链表
class EmpLinkedList {
    //头指针，指向第一个Emp，因此我们这个链表的head是直接指向第一个雇员的
    private Emp head; //默认是null

    //添加雇员到链表
    //说明：
    //1.假定，当添加雇员时，id是自增长，即id的分配总是从小到大
    //因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助我们定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) { //说明到链表最后
                break;
            }
            curEmp = curEmp.next; //后移
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            //说明链表为空
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"链表的信息为：");
        Emp curEmp = head; //辅助指针
        while (true) {
            System.out.printf("=> id = %d name = %s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) { //说明curEmp已经是最后节点
                break;
            }
            curEmp = curEmp.next; //后移遍历
        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到，就返回Emp，如果没找到，就返回空
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) { //说明找到
                break; //这时curEmp就指向要查找的雇员
            }
            //退出条件
            if (curEmp.next == null) { //说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next; //后移
        }
        return curEmp;
    }
}
