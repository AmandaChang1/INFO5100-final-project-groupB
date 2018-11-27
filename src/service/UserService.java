package service;

import java.sql.Connection;

public interface UserService {

    boolean compareD(String name, String password);
    void addD(String name, String password);
    boolean compareC(String name, String password);
    void addC(String name, String password);
}
