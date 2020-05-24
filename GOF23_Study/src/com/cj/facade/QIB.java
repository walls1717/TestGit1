package com.cj.facade;

/**
 * 质检局
 *
 * @author CJ
 */

public interface QIB {
    void orgCodeCertificate(); //办理组织机构代码证
}

class HeNanOIB implements QIB{

    @Override
    public void orgCodeCertificate() {
        System.out.println("在河南质检局办理组织机构代码证");
    }
}