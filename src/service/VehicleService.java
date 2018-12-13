package service;

import dto.Inventory;
import dto.Vehicle;

public interface VehicleService {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    Inventory getInventoryByDealer(String dealerId);
}
