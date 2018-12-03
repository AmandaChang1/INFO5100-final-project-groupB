package service;

import dto.Inventory;
import dto.Vehicle;
import dao.*;

import java.text.ParseException;
import java.util.ArrayList;

public class VehicleServiceImple implements VehicleService{
    private ManageVehicle manageVehicle;
    public VehicleServiceImple() {
       manageVehicle=new ManageVehicleImple();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
     manageVehicle.addVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        manageVehicle.deleteVehicle(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        manageVehicle.updateVehicle(vehicle);
    }

    @Override
    public Inventory getInventoryByDealer(String dealerId,int pageNumber) throws ParseException {
        Inventory vehicles=manageVehicle.getVehicle(dealerId,pageNumber);
        return vehicles;
    }

    @Override
    public ArrayList<String> getAttributeList(String attribute) {
        ArrayList<String> typeList=manageVehicle.getAttributeList(attribute);
        return typeList;
    }
}
