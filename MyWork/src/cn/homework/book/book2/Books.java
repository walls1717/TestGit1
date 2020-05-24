package cn.homework.book.book2;

/**
 * 图书
 * @version 2020-5-18
 * @author CJ
 */
public class Books {
    private int id;
    private String name;
    private String publish;
    private double money;
    private double totalMoney;
    private int number;

    public Books() {}

    /**
     *
     * @param id 图书编号
     * @param name 图书名称
     * @param publish 图书出版社
     * @param money 图书单价
     * @param number 图书库存
     */
    public Books(int id, String name, String publish, double money, double totalMoney, int number) {
        this.id = id;
        this.name = name;
        this.publish = publish;
        this.money = money;
        this.totalMoney = totalMoney;
        this.number = number;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  "图书编号：" + id +
                ", 图书名称：'" + name + '\'' +
                ", 图书出版社：'" + publish + '\'' +
                ", 图书单价：" + money +
                ", 图书库存：" + number +
                ", 图书总价：" + money * number;
    }
}
