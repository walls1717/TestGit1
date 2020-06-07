package cn.circle.gui.fruit.dao;

import cn.circle.gui.fruit.data.DataBase;
import cn.circle.gui.fruit.domain.FruitItem;

import java.util.ArrayList;

/**
 * 管理员界面操作按钮数据访问类
 * @author CJ
 */
public class AdminDao {
    /**
     * 查询所有数据
     * @return
     */
    public ArrayList<FruitItem> queryAllData() {
        return DataBase.data;
    }
    public void addFruitItem(FruitItem fruitItem) {
        DataBase.data.add(fruitItem);
    }

    public void delFruitItem(String delNumber) {
        for(int i = 0; i < DataBase.data.size(); i++) {
            FruitItem thisFruitItem = DataBase.data.get(i);
            // 如果水果项的编号与传入编号相同，则从集合中删除
            if (thisFruitItem.getNumber().equals(delNumber)) {
                DataBase.data.remove(i);
            }
        }
    }
}
