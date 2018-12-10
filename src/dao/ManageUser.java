package dao;

import java.sql.Connection;

public interface ManageUser {
    boolean compareD(String name, String password);
    void addD(String name, String password);
    boolean compareC(String name, String password);
    void addC(String name, String password);
}
