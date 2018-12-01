package dao;

import java.util.ArrayList;
import java.util.List;

import dto.FilterContent;
import dto.FilterContentModel;
import dto.Inventory;
import dto.Vehicle;

public class VehicleQueryImple implements VehicleQuery{
	//private FilterContentModel filterContentModel;
	private Inventory inventory;
	//private ArrayList<Vehicle> vehicles;
	//private String dealername;
	//private int pageCount;
	
	public VehicleQueryImple() {
    	
    	
    }
    public VehicleQueryImple(Inventory inventory) {
    	
    	this.inventory = inventory;
    }
    
    @Override
    public FilterContentModel setModel(Inventory inventory) {
    	FilterContentModel model = new FilterContentModel();
    	
    	return model;
    }
    
    @Override
    public Inventory queryByFilter (Inventory inventory, FilterContent filterContentSelected) {
    	
    	
    	ArrayList<Vehicle> vehicles = inventory.getVehicles();
    	ArrayList<Vehicle> result = new ArrayList<>();
    	
    	for(Vehicle v : vehicles) {
    		if(		queryCondition(filterContentSelected.getCondition(), v) &&
    				queryBrand(filterContentSelected.getBrand(), v) &&
    				queryBodyType(filterContentSelected.getBodyType(), v) && 
    				queryCarModel(filterContentSelected.getModel(),v) &&
    				queryPriceRange(filterContentSelected.getLowPrice(), filterContentSelected.getHighPrice(), v) &&
    				queryYearRange(filterContentSelected.getLowYear(), filterContentSelected.getHighYear(), v)
    				) {
    			result.add(v);
    		}
    		
    	}
    	
    	Inventory results = new Inventory();
    	results.setVehicles(result);
    	return results;
    }
    
    private boolean queryCondition(List<String> conditions, Vehicle v) {
    	String targetContition = v.getCategory();
    	for(String condition : conditions) {
    		if(condition == "condition") 
    			return true;
    		else if(targetContition == condition) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean queryBrand(List<String> brands, Vehicle v) {
    	String targetBrand = v.getMake();
    	for(String brand : brands) {
    		if(brand == "brand") 
    			return true;
    		else if(targetBrand == brand) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean queryCarModel(List<String> models, Vehicle v) {
    	String targetmodel = v.getModel();
		for(String model : models) {
			if(model == "model") 
				return true;
			else if(targetmodel == model) 
				return true;
		}
		return false;
	}
    
    private boolean queryBodyType(List<String> bodyTypes, Vehicle v) {
    	String targetBodyType = v.getType();
    	for(String bodyType : bodyTypes) {
    		if(bodyType == "bodyType")
    			return true;
    		else if(targetBodyType == bodyType)
    			return true;
    	}
    	return false;
    }
    
    private boolean queryPriceRange(int lowPrice, int highPrice, Vehicle v) {
    	int targetPrice = Integer.valueOf(v.getPrice());
    	if(targetPrice >= lowPrice && targetPrice <= highPrice) 
    		return true;
    	return false;
    }
    
    private boolean queryYearRange(int lowYear, int highYear, Vehicle v) {
    	int targetYear = Integer.valueOf(v.getYear());
    	if(targetYear >= lowYear && targetYear <= highYear)
    		return true;
    	return false;
    }
    
    @Override
    public Vehicle queryByCarID(String carID, Inventory inventory) {
    	ArrayList<Vehicle> vehicles = inventory.getVehicles();
    	for(int i = 0; i < vehicles.size(); i ++) {
    		if(carID == vehicles.get(i).getId()) {
    			return vehicles.get(i);
    		}
    	}
    	return null;
    }
    	 
    @Override
    public Inventory queryBySpecialID(String specialID, Inventory inventory){
    	ArrayList<Vehicle> vehicles = inventory.getVehicles();
    	Inventory results = new Inventory();
    	ArrayList<Vehicle> result = new ArrayList<Vehicle>();
    	for(int i = 0; i < vehicles.size(); i ++) {
    		if(specialID == vehicles.get(i).getSpecialId()) {
    			result.add(vehicles.get(i));
    		}
    	}
    	results.setVehicles(result);
    	return results;
    }
    
    /*
    public void test() {
    	FilterContent filter = new FilterContent();
    	
    }

*/

	
    
    

}
