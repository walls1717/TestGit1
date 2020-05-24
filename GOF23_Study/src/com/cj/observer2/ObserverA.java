package com.cj.observer2;

import lombok.Getter;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {
    @Setter
    @Getter
    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

}
