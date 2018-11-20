package io;

import java.sql.Connection;
import java.util.ArrayList;

public interface UserIOInterface {

    Connection getConnection();

    void addData(String tableName, String data);
    void deleteData(String tableName, String data);
    void updateData(String tableName, String id, String data);
    ArrayList<String> getData(String sql);




}
