package service;

import dto.Inventory;
import dto.Vehicle;
import dao.*;

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
    public Inventory getInventoryByDealer(String dealerId) {
        Inventory vehicles=manageVehicle.getVehicle(dealerId);
        return vehicles;
    }
}
