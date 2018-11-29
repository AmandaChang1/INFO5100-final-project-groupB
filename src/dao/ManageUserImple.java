package dao;

import io.UserIO;
import io.UserIOInterface;

import javax.swing.*;
import java.sql.*;

public class ManageUserImple implements ManageUser {
    private UserIOInterface io;
    public ManageUserImple() {
        io=new UserIO();
    }

    @Override
    public boolean compareD(String name, String password) {
        Connection connection = io.getConnection();
        ResultSet resultSet = null;
        boolean m = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password from dealeraccount WHERE name=" + "'" + name + "'");
            resultSet = preparedStatement.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            if (resultSet.next()) {
                String pa = resultSet.getString(1);
                if (pa.equals(password)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void addD(String name, String password) {
        try {
            Connection connection = io.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dealeraccount (name,password)  VALUES (" + "'" + name + "','" + password + "')");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean compareC(String name, String password) {
        Connection connection = io.getConnection();
        ResultSet resultSet = null;
        boolean m = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password from customeraccount WHERE name=" + "'" + name + "'");
            resultSet = preparedStatement.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            if (resultSet.next()) {
                String pa = resultSet.getString(1);
                if (pa.equals(password)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户名不存在");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void addC(String name, String password) {
        try {
            Connection connection = io.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customeraccount (name,password)  VALUES (" + "'" + name + "','" + password + "')");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
