package cn.homework.bank;

/**
 * 银行类
 * 属性：银行名字，客户名字，余额，密码，交易额度
 * 实现：存款，取款
 * 说明：目前银行只实现了整数存款与取款，默认用户是新开户用户
 */
public class Bank {
    //银行名字
    private String bankName = "商丘学院银行";
    //客户名字
    private String empName;
    //余额
    private int balance;
    //开户费用
    private final int OPEN = 10;
    //密码
    private int password;
    //交易额度
    private int turnover;

    public Bank(String empName, int password, int money) {
        this.empName = empName;
        this.password = password;
        open(money);
    }


    public void open(int money) {
        System.out.println(bankName);
        if (money >= OPEN) {
            System.out.println("开户成功");
            this.balance = money - OPEN;
            System.out.println("扣除工本费后，您账户的余额为：" + this.balance);
        } else {
            System.out.println("您的存款金额不满足工本费，开户失败，请重新存款");
        }
    }

    /**
     * 存款
     *
     * @param empName  用户名
     * @param password 用户密码
     * @param money    需要存款的额度
     */
    public void topUp(String empName, int password, int money) {
        System.out.println();
        System.out.println(bankName);
        if (empName.equals(empName) && password == this.password) {
            this.balance = money + balance;
            System.out.println("此次存款金额：" + money);
            System.out.println("您账户的余额为：" + this.balance);
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    public void withdraw(String empName, int password, int money) {
        System.out.println();
        System.out.println(bankName);
        if (empName.equals(empName) && password == this.password) {
            if (this.balance >= money) {
                this.balance = balance - money;
                System.out.println("此次取款金额为：" + money);
                System.out.println("您账户的余额为：" + this.balance);
            } else {
                System.out.println("余额不足");
            }
        } else {
            System.out.println("用户名或密码错误");
        }
    }

}
