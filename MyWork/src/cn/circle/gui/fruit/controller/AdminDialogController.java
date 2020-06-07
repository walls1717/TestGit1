package cn.circle.gui.fruit.controller;

import cn.circle.gui.fruit.service.AbstractAdminDialog;
import cn.circle.gui.fruit.domain.FruitItem;
import cn.circle.gui.fruit.service.AdminService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * 管理员界面按钮操作类
 * @author CJ
 */
public class AdminDialogController extends AbstractAdminDialog {

    private AdminService adminService = new AdminService();

    public AdminDialogController() {
    }

    public AdminDialogController(Frame owner, boolean modal) {
        super(owner, modal);
        queryFruitItem();
    }

    @Override
    public void queryFruitItem() {
        String[] thead = {"水果编号", "水果名称", "水果单价（/元）", "计价单位"};
        ArrayList<FruitItem> dataList = adminService.queryFruitItem();
        String[][] tbody = list2Array(dataList);
        TableModel dataModel = new DefaultTableModel(tbody, thead);
        table.setModel(dataModel);
    }

    public String[][] list2Array(ArrayList<FruitItem> list) {
        String[][] tbody = new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            FruitItem fruitItem = list.get(i);
            tbody[i][0] = fruitItem.getNumber();
            tbody[i][1] = fruitItem.getName();
            tbody[i][2] = fruitItem.getPrice() + "";
            tbody[i][3] = fruitItem.getUnit();
        }
        return tbody;
    }

    @Override
    public void addFruitItem() {
        String addNumber = addNumberText.getText();
        String addName = addNameText.getText();
        String addPrice = addPriceText.getText();
        String addUnit = addUnitText.getText();

        boolean addSuccess = adminService.addFruitItem(addNumber, addName, addPrice, addUnit);
        if (addSuccess) {
            queryFruitItem();
        } else {
            JOptionPane.showMessageDialog(this, "水果编号不能重复！");
        }
    }

    @Override
    public void updateFruitItem() {
        String updateNumber = updateNumberText.getText();
        String updateName = updateNameText.getText();
        String updatePrice = updatePriceText.getText();
        String updateUnit = updateUnitText.getText();

        boolean updateSuccess = adminService.updateFruitItem(updateNumber, updateName, updatePrice, updateUnit);

        if (updateSuccess) {
            queryFruitItem();
        } else {
            JOptionPane.showMessageDialog(this, "没有此编号的水果");
        }
    }

    @Override
    public void delFruitItem() {
        String delNumber = delNumberText.getText();
        boolean delSuccess = adminService.delFruitItem(delNumber);

        if (delSuccess) {
            queryFruitItem();
        } else {
            JOptionPane.showMessageDialog(this, "没有此编号水果");
        }
    }
}
