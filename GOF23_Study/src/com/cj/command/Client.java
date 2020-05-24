package com.cj.command;

public class Client {
    public static void main(String[] args) {
        Command c = new ConcreteCommand(new Receive());
        Invoke invoke = new Invoke(c);

        invoke.call();
    }
}
