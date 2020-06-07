package cn.circle.gui.fruit.service;

import cn.circle.gui.fruit.dao.AdminDao;
import cn.circle.gui.fruit.domain.FruitItem;

import java.util.ArrayList;

/**
 * 管理界面的功能服务类
 * @author CJ
 */
public class AdminService {
    private AdminDao adminDao = new AdminDao();

    public ArrayList<FruitItem> queryFruitItem() {
        ArrayList<FruitItem> data = adminDao.queryAllData();
        return data;
    }

    public boolean addFruitItem(String number, String name, String price, String unit) {
        ArrayList<FruitItem> data = adminDao.queryAllData();
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem = data.get(i);
            // 如果存在重复编号数据，则添加不成功
            if(number.equals(fruitItem.getNumber())) {
                return false;
            }
        }
        FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
        // 调用 dao 中添加数据的方法
        adminDao.addFruitItem(thisFruitItem);
        return true;
    }

    public boolean updateFruitItem(String number, String name, String price, String unit) {
        ArrayList<FruitItem> data = adminDao.queryAllData();
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem = data.get(i);
            // 如果存在相同编号数据，则可以更新
            if(number.equals(fruitItem.getNumber())) {
                // 删除
                adminDao.delFruitItem(number);
                FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
                adminDao.addFruitItem(thisFruitItem);
                // 在修改数据之后返回添加成功
                return true;
            }
        }
        return false;
    }

    public boolean delFruitItem(String delNumber) {
        ArrayList<FruitItem> data = adminDao.queryAllData();
        for (int i = 0; i < data.size(); i++) {
            FruitItem fruitItem = data.get(i);
            if(delNumber.equals(fruitItem.getNumber())) {
                adminDao.delFruitItem(delNumber);
                return true;
            }
        }
        return false;
    }
}
