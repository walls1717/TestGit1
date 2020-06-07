package cn.circle.gui.fruit.service;

import cn.circle.gui.fruit.tools.GuiTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author CJ
 */
public abstract class AbstractAdminDialog extends JDialog {

    private JLabel tableLabel = new JLabel("水果列表");
    private JScrollPane tablePanel = new JScrollPane();
    protected JTable table = new JTable();
    private JLabel numberLabel = new JLabel("水果编号");
    private JLabel nameLabel = new JLabel("水果名称");
    private JLabel priceLabel = new JLabel("水果单价");
    private JLabel unitLabel = new JLabel("计价单位");

    protected JTextField addNumberText = new JTextField(6);
    protected JTextField addNameText = new JTextField(6);
    protected JTextField addPriceText = new JTextField(6);
    protected JTextField addUnitText = new JTextField(6);
    private JButton addBtn = new JButton("添加水果");

    protected JTextField updateNumberText = new JTextField(6);
    protected JTextField updateNameText = new JTextField(6);
    protected JTextField updatePriceText = new JTextField(6);
    protected JTextField updateUnitText = new JTextField(6);
    private JButton updateBtn = new JButton("修改水果");

    protected JTextField delNumberText = new JTextField(6);
    private JButton delBtn = new JButton("删除水果");

    public AbstractAdminDialog() {
        this(null, true);
    }

    public AbstractAdminDialog(Frame owner, boolean modal) {
        super(owner, modal);
        this.init();
        // 添加组件
        this.addComponent();
        // 添加监听器
        this.addListener();
    }

    private void init() {
        this.setTitle("超市货物管理");
        this.setSize(600, 400);
        GuiTools.center(this);
        this.setResizable(false);
    }

    /**
     * 添加组件
     */
    private void addComponent() {
        this.setLayout(null);
        tableLabel.setBounds(265, 20, 70, 25);
        this.add(tableLabel);

        // 表格
        // 列不能动
        table.getTableHeader().setReorderingAllowed(false);
        // 不可拉动表格
        table.getTableHeader().setResizingAllowed(false);
        // 不可更改数据
        table.setEnabled(false);
        tablePanel.setBounds(50, 50, 500, 200);
        // 滚动面板显示表格数据
        tablePanel.setViewportView(table);
        this.add(tablePanel);

        // 字段标题
        numberLabel.setBounds(50, 250, 70, 25);
        nameLabel.setBounds(150, 250, 70, 25);
        priceLabel.setBounds(250, 250, 70, 25);
        unitLabel.setBounds(350, 250, 70, 25);
        this.add(numberLabel);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(unitLabel);

        // 增加组件
        addNumberText.setBounds(50, 280, 80, 25);
        addNameText.setBounds(150, 280, 80, 25);
        addPriceText.setBounds(250, 280, 80, 25);
        addUnitText.setBounds(350, 280, 80, 25);
        addBtn.setBounds(460, 280, 90, 25);
        this.add(addNumberText);
        this.add(addNameText);
        this.add(addPriceText);
        this.add(addUnitText);
        this.add(addBtn);

        // 修改组件
        updateNumberText.setBounds(50, 310, 80, 25);
        updateNameText.setBounds(150, 310, 80, 25);
        updatePriceText.setBounds(250, 310, 80, 25);
        updateUnitText.setBounds(350, 310, 80, 25);
        updateBtn.setBounds(460, 310, 90, 25);
        this.add(updateNumberText);
        this.add(updateNameText);
        this.add(updatePriceText);
        this.add(updateUnitText);
        this.add(updateBtn);

        // 删除组件
        delNumberText.setBounds(50, 340, 80, 25);
        delBtn.setBounds(460, 340, 90, 25);
        this.add(delNumberText);
        this.add(delBtn);
    }

    /**
     * 监听器
     */
    private void addListener() {
        // 添加按钮
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 调用添加方法
                addFruitItem();
            }
        });
        // 修改按钮
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 调用修改方法
                updateFruitItem();
            }
        });
        // 删除按钮
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 调用删除
                delFruitItem();
            }
        });
        // 删除按钮
    }

    public abstract void queryFruitItem();
    public abstract void addFruitItem();
    public abstract void updateFruitItem();
    public abstract void delFruitItem();
}
