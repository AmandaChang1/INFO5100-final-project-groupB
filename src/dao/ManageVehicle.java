package dao;

import dto.Inventory;
import dto.Vehicle;

import java.util.ArrayList;

public interface ManageVehicle {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
   Inventory getVehicle(String id,int pageNumber);
   ArrayList<String> getAttributeList(String attribute);
}
