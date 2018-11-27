package dao;

import dto.Inventory;
import dto.Vehicle;

public interface ManageVehicle {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
   Inventory getVehicle(String id,int pageNumber);
}
