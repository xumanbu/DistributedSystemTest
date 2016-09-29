package com.bestxty;

import com.bestxty.db.Table;

public interface DataBaseTableReverse {


    boolean open(String url, String username, String password);


    void close();


    Table getTable(String tableName);


}
