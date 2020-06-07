package cn.circle.gui.fruit.test;

import cn.circle.gui.fruit.service.AbstractAdminDialog;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 管理员测试类
 * @author CJ
 */
public class AbstractAdminDialogTest extends AbstractAdminDialog {
    public static void main(String[] args) {
        new AbstractAdminDialogTest().setVisible(true);
    }

    public AbstractAdminDialogTest() {
        queryFruitItem();
    }

    @Override
    public void queryFruitItem() {
        Object[] thread = {"水果名称", "水果编号", "水果单价（/元）", "计价单位"};
        Object[][] tbody = {
                {"1", "苹果", "5.0", "KG"},
                {"2", "葡萄", "3.2", "KG"},
                {"3", "雪梨", "3.8", "KG"},
                {"4", "泰国大榴莲", "120", "个"},
        };
        TableModel dataModel = new DefaultTableModel(tbody, thread);
        table.setModel(dataModel);
    }

    @Override
    public void addFruitItem() {

    }

    @Override
    public void updateFruitItem() {

    }

    @Override
    public void delFruitItem() {

    }
}
