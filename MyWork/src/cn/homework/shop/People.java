package cn.homework.shop;

public class People {
    private String peoName; //人名

    public String getPeoName() {
        return peoName;
    }

    public void setPeoName(String peoName) {
        this.peoName = peoName;
    }

    public Product shopping(Market m, String name) {
        return m.sell(name);
    }
}
