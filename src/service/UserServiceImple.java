package service;

import dao.ManageUser;
import dao.ManageUserImple;

import java.sql.Connection;

public class UserServiceImple implements UserService{

    private ManageUser manageUser;

    public UserServiceImple() {
        manageUser=new ManageUserImple();
    }

    @Override
    public boolean compareD(String name, String password) {
        return manageUser.compareD(name,password);
    }

    @Override
    public void addD(String name, String password) {
        manageUser.addD(name,password);
    }

    @Override
    public boolean compareC(String name, String password) {
        return manageUser.compareC(name,password);
    }

    @Override
    public void addC(String name, String password) {
        manageUser.addC(name,password);
    }
}
