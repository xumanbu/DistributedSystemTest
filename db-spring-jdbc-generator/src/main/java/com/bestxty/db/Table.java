package com.bestxty.db;

import java.util.List;

/**
 * Created by xty on 2016/9/29.
 * for project: DistributedSystemTest.
 */
public class Table {

    private String tableName;


    private int columnCount;


    private List<TableColumn> columns;

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append(tableName)
                .append("\n");

        for (TableColumn column : columns) {
            str.append(column.getColumnName())
                    .append("\t")
                    .append(column.getColumnTypeName())
                    .append("\t")
                    .append(column.getColumnDisplaySize())
                    .append("\n");
        }

        return str.toString();
    }

    public String getTableName() {

        String table = "";
        if (tableName.contains("_")) {
            String[] arr = tableName.split("_");


            for (String subStr : arr) {
                table += captureName(subStr);
            }
        }


        return table.equals("") ? tableName : table;
    }

    //首字母大写
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);

    }


    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }
}
