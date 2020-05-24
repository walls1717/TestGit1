package com.cj.facade;

/**
 * 办理注册公司流程的门面对象
 *
 * @author CJ
 */

public class RegisterFacade {
    public void register(){
        //工商局检查名字
        IABC iabc = new HeNanIABC();
        iabc.checkName();
        //质检局办理组织机构代码证
        QIB qib = new HeNanOIB();
        qib.orgCodeCertificate();
        //税务局办理税务登记
        TaxBureau taxBureau = new HeNanTaxBureau();
        taxBureau.taxCertificate();
        //银行开户
        Bank bank = new ICBC();
        bank.openAccount();
    }
}
