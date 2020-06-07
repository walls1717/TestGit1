package cn.circle.gui.fruit.data;

import cn.circle.gui.fruit.domain.FruitItem;

import java.util.ArrayList;

/**
 * 存储数据仓库
 * @author CJ
 */
public class DataBase {
    public static ArrayList<FruitItem> data = new ArrayList<>();
    // 初始数据
    static {
        data.add(new FruitItem("1", "苹果", 5.0, "KG"));
    }
}
