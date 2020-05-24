package com.cj.facade;

/**
 * 税务局
 *
 * @author CJ
 */

public interface TaxBureau {
    void taxCertificate(); //办理税务登记
}

class HeNanTaxBureau implements TaxBureau{

    @Override
    public void taxCertificate() {
        System.out.println("在河南税务局办理税务登记");
    }
}
