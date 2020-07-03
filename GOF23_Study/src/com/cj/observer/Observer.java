/*
package com.cj.observer;


import lombok.Getter;
import lombok.Setter;

public interface Observer {
    void update(Subject subject);
}

class ObserverA implements Observer{

    @Setter
    @Getter
    private int myState; //myState需要跟目标对象的State保持一致

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }
}
*/
