package com.cj.mediator;

/**
 * @author CJ
 */

public interface Mediator {
    void register(String dname, Department d);
    void command(String dname);
}
