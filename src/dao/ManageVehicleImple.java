package dao;
import dto.Inventory;
import io.*;
import dto.Vehicle;

import java.text.ParseException;
import java.util.ArrayList;


public class ManageVehicleImple implements ManageVehicle{
    private UserIOInterface io;
    public ManageVehicleImple() {
        io=new UserIO();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        String data="";

        data="'"+vehicle.getDealerId()+"','"+vehicle.getCategory()+"','"+
                vehicle.getYear()+"','"+vehicle.getMake()+"','"+vehicle.getModel()+"','"+
                vehicle.getTrim()+"','"+vehicle.getType()+"','"+vehicle.getPrice()+"','"+
                vehicle.getImages()+"','"+vehicle.getSpecialId()+"','"+vehicle.getDiscountprice()+"'";
        io.addData("vehicle",data);

    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        String data="";
        data=vehicle.getId();


        io.deleteData("vehicle",data);

    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        String data="";

        data="'"+vehicle.getId()+"','"+vehicle.getDealerId()+"','"+vehicle.getCategory()+"','"+
                vehicle.getYear()+"','"+vehicle.getMake()+"','"+vehicle.getModel()+"','"+
                vehicle.getTrim()+"','"+vehicle.getType()+"','"+vehicle.getPrice()+"','"+
                vehicle.getImages()+"','"+vehicle.getSpecialId()+"','"+vehicle.getDiscountprice()+"'";
        String id=vehicle.getId();
        io.updateData("vehicle",id,data);

    }

    @Override
    public Inventory getVehicle(String dealerId,int pageNumber) throws ParseException {
        ArrayList<String> set = new ArrayList<>();
        if(pageNumber > 0){
            set=io.getData("SELECT * FROM cloud.vehicle where dealername='"+dealerId+"'"+"limit "+(pageNumber-1)*30+", 30");
        }else{
            set=io.getData("SELECT * FROM cloud.vehicle where dealername='"+dealerId+"'");
        }
       Inventory inventory=new Inventory();
       ManageSpecial manageSpecial = new ManageSpecialImple();
       ((ManageSpecialImple) manageSpecial).constructInventory(set,inventory);
       inventory = manageSpecial.assocaiteSpecials(inventory);
       return inventory;
    }

    @Override
    public ArrayList<String> getAttributeList(String attribute) {
        ArrayList<String> set=io.getData("select distinct("+attribute+") from vehicle;");

            set.remove("null");

        return set;
    }
}
