package com.cj.state;

public interface State {
    void handle();
}

//空闲状态
class FreeState implements State{

    @Override
    public void handle() {
        System.out.println("房间空闲，没人住");
    }
}

//预定状态
class BookerState implements State{

    @Override
    public void handle() {
        System.out.println("房间已预定");
    }
}

//入住状态
class CheckedState implements State{

    @Override
    public void handle() {
        System.out.println("房间已入住，请勿打扰");
    }
}
