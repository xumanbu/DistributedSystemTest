package com.bestxty.db;

/**
 * Created by xty on 2016/9/29.
 * for project: DistributedSystemTest.
 */
public class TableColumn {

    private String columnName;

    private int coulmnType;

    private String columnTypeName;

    private int columnDisplaySize;

    private String catalogName;


    @Override
    public String toString() {
        return "TableColumn{" +
                "columnName='" + columnName + '\'' +
                ", coulmnType=" + coulmnType +
                ", columnTypeName='" + columnTypeName + '\'' +
                ", columnDisplaySize=" + columnDisplaySize +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public int getCoulmnType() {
        return coulmnType;
    }

    public void setCoulmnType(int coulmnType) {
        this.coulmnType = coulmnType;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName == null ? null : columnTypeName.trim();
    }

    public int getColumnDisplaySize() {
        return columnDisplaySize;
    }

    public void setColumnDisplaySize(int columnDisplaySize) {
        this.columnDisplaySize = columnDisplaySize;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }
}
