package service;

import dto.Inventory;
import dto.Vehicle;

import java.text.ParseException;
import java.util.ArrayList;

public interface VehicleService {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    Inventory getInventoryByDealer(String dealerId,int pageNumber) throws ParseException;
    ArrayList<String> getAttributeList(String attribute);
}
