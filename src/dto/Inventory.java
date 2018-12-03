package dto;
import java.util.ArrayList;
public class Inventory  {
    private ArrayList<Vehicle> vehicles;

    public Inventory() {
        vehicles=new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    public void add(Vehicle o) {
        vehicles.add(o);
    }

}
