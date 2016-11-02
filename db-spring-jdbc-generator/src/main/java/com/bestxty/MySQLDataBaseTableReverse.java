package com.bestxty;

import com.bestxty.db.Table;
import com.bestxty.db.TableColumn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xty on 2016/9/29.
 * for project: DistributedSystemTest.
 */
public class MySQLDataBaseTableReverse implements DataBaseTableReverse {

    private Connection mConnection;

    private Statement mStatement;

    @Override
    public boolean open(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.mConnection = DriverManager.getConnection(url, username, password);
            this.mStatement = this.mConnection.createStatement();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public void close() {
        try {
            if (mConnection != null && !mConnection.isClosed()) {
                mConnection.close();
            }
        } catch (Exception e) {
            //ignore
            e.printStackTrace();
        }
    }

    @Override
    public Table getTable(String tableName) {
        try {
            Table table = new Table();

            ResultSet rst = mConnection.getMetaData().getPrimaryKeys("wechat_device", null, tableName);

            if (!rst.isAfterLast()) {

                rst.next();

                System.out.println(rst.getString("TABLE_NAME") + " " + rst.getString("COLUMN_NAME"));

                table.setTablePk(rst.getString("COLUMN_NAME"));

            }

            ResultSetMetaData metaData = getMetaDataFromTable(tableName);


            table.setTableName(metaData.getTableName(1));

            table.setColumnCount(metaData.getColumnCount());

            List<TableColumn> columnList = new ArrayList<>();


            for (int i = 0; i < metaData.getColumnCount(); i++) {

                TableColumn column = new TableColumn();
                column.setCatalogName(metaData.getCatalogName(i + 1));
                column.setColumnDisplaySize(metaData.getColumnDisplaySize(i + 1));
                column.setColumnName(metaData.getColumnName(i + 1));
                column.setColumnTypeName(metaData.getColumnTypeName(i + 1));
                column.setCoulmnType(metaData.getColumnType(i + 1));

                columnList.add(column);
            }

            table.setColumns(columnList);

            return table;
        } catch (Exception e) {
            //ignore
            e.printStackTrace();
        }

        return null;
    }

    private ResultSetMetaData getMetaDataFromTable(String tableName) throws Exception {
        String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE 1 != 1";
        ResultSet rs = this.mStatement.executeQuery(sql);
        return rs.getMetaData();
    }


}
