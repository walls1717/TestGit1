package com.cj.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 *
 * @author CJ
 */
public class TableInfo {
    /**
     * 表名
     */
    private String tname;

    /**
     * 所有字段的信息
     */
    private Map<String, ColumnInfo> columns;

    /**
     * 唯一主键(目前我们只能处理表中有且只有一个主键)
     */
    private ColumnInfo onlyPrikey;

    /**
     * 如果联合主键，则在这里储存
     */
    private List<ColumnInfo> prikeys;

    public TableInfo(){}

    public TableInfo(String tname, List<ColumnInfo> prikeys, Map<String, ColumnInfo> columns) {
        this.tname = tname;
        this.columns = columns;
        this.prikeys = prikeys;
    }

    public List<ColumnInfo> getPrikeys() {
        return prikeys;
    }

    public void setPrikeys(List<ColumnInfo> prikeys) {
        this.prikeys = prikeys;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getOnlyPrikey() {
        return onlyPrikey;
    }

    public void setOnlyPrikey(ColumnInfo onlyPrikey) {
        this.onlyPrikey = onlyPrikey;
    }
}
