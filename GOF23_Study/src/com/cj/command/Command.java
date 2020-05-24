package com.cj.command;

public interface Command {
    /**
     * 这个方法是一个返回结果为空的方法。
     * 实际项目中，可以根据需求设计多个不同的方法
     */
    void execute();
}

class ConcreteCommand implements Command{

    private Receive receive; //命令的真正执行者

    public ConcreteCommand(Receive receive) {
        this.receive = receive;
    }

    @Override
    public void execute() {
        //命令真正执行前或后，执行相关处理
        receive.action();
    }
}
