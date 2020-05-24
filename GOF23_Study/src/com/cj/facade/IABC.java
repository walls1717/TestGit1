package com.cj.facade;

/**
 * 工商局
 * @author CJ
 */

public interface IABC {
    void checkName(); //核名
}

class HeNanIABC implements IABC{

    @Override
    public void checkName() {
        System.out.println("检查名字是否有冲突");
    }
}
