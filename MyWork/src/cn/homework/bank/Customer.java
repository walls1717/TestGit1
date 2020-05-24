package cn.homework.bank;

public class Customer {
    public static void main(String[] args) {
        //开户
        Bank bank = new Bank("CJ", 123456, 100);
        //存款
        bank.topUp("CJ", 123456, 100);
        //取款
        bank.withdraw("CJ", 123456, 190);
    }
}
