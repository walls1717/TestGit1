package com.cj.chainOfResp;

public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader b2 = new ViceGeneralManager("李筱思");
        Leader c = new GeneralManager("王五");

        //组织责任链的关系
        a.setNextLeader(b);
        b.setNextLeader(b2);
        b2.setNextLeader(c);

        //开始请假操作
        LeaveRequest req1 = new LeaveRequest("TOM", 15, "回英国老家探亲");
        a.handlerRequest(req1);

    }
}
