package cn.hero;

public class TestHero01 {
    String name;//名字
    int hp;//血量
    int moveSpeed;//移动速度
    int money;//金币
    float force;//攻击力

    public static void main(String[] args)
    {
        TestHero01 garen = new TestHero01();
        garen.name = "盖伦";
        garen.hp = 3000;
        garen.moveSpeed = 400;
        garen.force = 300.23f;
        garen.money = 20;
    }
}
