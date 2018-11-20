import java.sql.*;
import java.util.HashMap;

public class BaseDao {
    private Connection connection = null;
    final private HashMap<String,String> map;

    public BaseDao() {
        map=new HashMap<>();
        map.put("dealer","name ,url,location");
        map.put("vehicle","id ,dealername,category,year,make,model,trim,type,price,images");
    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","dfhydgn0327");
            System.out.println("Success");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return connection;
    }

    public void  addVehicletoDealer(String tableName,String data) {
        String[] dataset=data.trim().split("\\s++");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO demo."+tableName+ "("+map.get(tableName)+")"+" VALUES ("+data+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public void insertdealer(Dealers dealer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO demo.dealer (name ,url,location) VALUES (?, ?,?)");
            preparedStatement.setString(1,  dealer.getName());
            preparedStatement.setString(2,  dealer.getLocation());
            preparedStatement.setString(3,  dealer.getUrl());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/

    /*public void insertVehicle(Vehicle vehicle){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO demo.Vehicle (id ,dealername,category,year,make,model,trim,type,price,images) VALUES (?, ?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,  vehicle.getId());
            preparedStatement.setString(2,  vehicle.getDealername());
            preparedStatement.setString(3,  vehicle.getCategory());
            preparedStatement.setString(4,  vehicle.getYear());
            preparedStatement.setString(5,  vehicle.getMake());
            preparedStatement.setString(6,  vehicle.getModel());
            preparedStatement.setString(7,  vehicle.getTrim());
            preparedStatement.setString(8,  vehicle.getType());
            preparedStatement.setString(9,  vehicle.getPrice());
            preparedStatement.setString(10,  vehicle.getImages());


            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }
}
