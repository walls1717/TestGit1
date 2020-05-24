package cn.homework.shop;

public class Shopping {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.setProName("电视");
        p1.setProName("洗衣机");
        p1.setProName("拖拉机");
        p1.setProName("奥特曼");

        Market market = new Market();
        market.getNAME();
        market.setProducts(new Product[]{p1, p2, p3, p4});

        People people = new People();
        people.setPeoName("小明");

        Product result = people.shopping(market, "奥特曼");

        if (result != null) {
            System.out.println(people.getPeoName() + "购买成功");
        } else {
            System.out.println(people.getPeoName() + "购买失败");
        }
    }
}
