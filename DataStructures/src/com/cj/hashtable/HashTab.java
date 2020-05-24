package com.cj.hashtable;

//创建HashTab管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArr;
    private int size; //表示有多少条链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArr
        empLinkedListArr = new EmpLinkedList[size];
        //不要忘了分别初始化每个链表
        for(int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应当添加到那条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArr[empLinkedListNo].add(emp);
    }

    //遍历所有的链表，遍历hashTab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list(i);
        }
    }

    //根据输入的id，查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到那条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArr[empLinkedListNo].findEmpById(id);
        if (emp != null) { //找到了
            System.out.printf("在第%d条链表中找到该雇员id = %d\n", (empLinkedListNo + 1), id);
        } else {
            System.out.println("在哈希表中没有找到该雇员！！");
        }
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}
