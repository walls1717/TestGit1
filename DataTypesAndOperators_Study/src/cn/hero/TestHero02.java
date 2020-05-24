package cn.hero;

public class TestHero02 {
    String name;
    float hp;
    float armor;
    int moveSpeed;

    //坑队友
    void keng()
    {
        System.out.println("坑队友!");
    }

    //超神
    void chaoshen()
    {
        System.out.println("chaoshen");
    }

    //获得护甲值
    float getArmor()
    {
        return armor;
    }

    //获得血量
    float getHp()
    {
        return hp;
    }

    //增加移动速度
    void addSpeed(int speed)
    {
        moveSpeed = moveSpeed + speed;
    }

    //回血
    void addHp(float blood)
    {
        hp = hp + blood;
    }

    public static void main(String[] args)
    {
        TestHero02 garen = new TestHero02();
        garen.name = "盖伦";
        garen.hp = 4004.24f;
        garen.armor = 345.2f;
        garen.moveSpeed = 400;
        garen.addHp(1000);

    }
}