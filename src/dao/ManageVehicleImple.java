package dao;
import dto.Inventory;
import io.*;
import dto.Vehicle;

import java.util.ArrayList;


public class ManageVehicleImple implements ManageVehicle{
    private UserIOInterface io;
    public ManageVehicleImple() {
        io=new UserIO();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        String data="";

        data="'"+vehicle.getId()+"','"+vehicle.getDealerId()+"','"+vehicle.getCategory()+"','"+
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
    public Inventory getVehicle(String dealerId,int pageNumber) {

       ArrayList<String> set=io.getData("SELECT * FROM cloud.vehicle where dealername='"+dealerId+"'"+"limit "+(pageNumber-1)*30+", 30");

       Inventory inventory=new Inventory();
       for(String a:set) {
           String[] res = a.trim().split("~");
           Vehicle vehicle = new Vehicle();
           vehicle.setId(res[0]);
           vehicle.setDealerId(res[1]);
           vehicle.setCategory(res[2]);
           vehicle.setYear(res[3]);
           vehicle.setMake(res[4]);
           vehicle.setModel(res[5]);
           vehicle.setTrim(res[6]);
           vehicle.setType(res[7]);
           vehicle.setPrice(res[8]);
           vehicle.setImages(res[9]);
           vehicle.setSpecialId(res[10]);
           inventory.add(vehicle);
       }
       return inventory;
    }

    @Override
    public ArrayList<String> getAttributeList(String attribute) {
        ArrayList<String> set=io.getData("select distinct("+attribute+") from vehicle;");

            set.remove("null");

        return set;
    }
}
