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
    	
    	FilterContentModel filterModel = new FilterContentModel();
    	ArrayList<Vehicle> vehicles = inventory.getVehicles();
    	
    	filterModel.setBrand(getBrand(vehicles));
    	filterModel.setModel(getModel(vehicles));
    	filterModel.setTrim(getTrim(vehicles));
    	double[] priceRange = getPriceRange(vehicles);
    	int[] yearRange = getYearRange(vehicles);
    	filterModel.setMaxprice(priceRange[1]);
    	filterModel.setMinprice(priceRange[0]);
    	filterModel.setMaxyear(yearRange[1]);
    	filterModel.setMinyear(yearRange[0]);  
    	
    	return filterModel;
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
    
    private boolean queryPriceRange(double lowPrice, double highPrice, Vehicle v) {
    	double targetPrice = Double.valueOf(v.getPrice());
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
    
	
    private ArrayList<String> getBrand(ArrayList<Vehicle> vehicles) {
    	ArrayList<String> brand = new ArrayList<String>();
    	for (Vehicle v : vehicles) {
    		if (!brand.contains(v.getMake())){
    			brand.add(v.getMake());
    		}
    	}
    	return brand;
    }
	
  
    private ArrayList<String> getModel(ArrayList<Vehicle> vehicles) {
	ArrayList<String> model = new ArrayList<String>();
	for (Vehicle v : vehicles) {
		if (!model.contains(v.getModel())){
			model.add(v.getModel());
		}
	}
	return model;
    }
	
 
    private ArrayList<String> getTrim(ArrayList<Vehicle> vehicles) {
	ArrayList<String> trim = new ArrayList<String>();
	for (Vehicle v : vehicles) {
		if (!trim.contains(v.getTrim())){
			trim.add(v.getTrim());
		}
	}
	return trim;
    }
	
    private double[] getPriceRange(ArrayList<Vehicle> vehicles) {
	double[] range = new double[2];
	double max = 0.0;
	double min = Double.MAX_VALUE;
	for (Vehicle v : vehicles) {
		double price = Double.parseDouble(v.getPrice());
		if (price > max) {
			max = price;
		}

		if (price < min) {
			min = price;
		}
	}
	range[0] = min;
	range[1] = max;
	return range;
    }

    private int[] getYearRange(ArrayList<Vehicle> vehicles) {
	int[] range = new int[2];
	int max = 0;
	int min = Integer.MAX_VALUE;
	for (Vehicle v : vehicles) {
		int year = Integer.parseInt(v.getYear());
		if (year > max) {
			max = year;
		}

		if (year < min) {
			min = year;
		}
	}
	range[0] = min;
	range[1] = max;
	return range;
    }
//    
//    
//    //Test Method
//
//
//    public static void main(String args[]) {
//    	// build up a test filter Content;
//    	FilterContent filter = new FilterContent();
//    	filter.setDealerName("gmps-aj-dohmann");
//    	
//    	//filter.setVehicleID("2844479993");
//    	filter.setVehicleID("vehicleid");
//    	System.out.println("1+" + filter.getVehicleID());
//    	
//    	ArrayList<String> conditions = new ArrayList<>();
//    
//    	conditions.add("new");
//    	//conditions.add("condition");
//    	//conditions.add("used");
//    	//conditions.add("certified");
//    	filter.setCondition(conditions);
//    	System.out.println("2+" + filter.getCondition());
//    	
//    	ArrayList<String> brand = new ArrayList<>();
//    	brand.add("brand");
//    	/*
//    	brand.add("brand");
//    	brand.add("Cadillc");
//    	brand.add("Chevrolet");
//    	brand.add("Toyota");
//    	brand.add("Honda");
//    	*/
//    	filter.setBrand(brand);
//    	System.out.println("3+" + filter.getBrand());
//    	
//    	ArrayList<String> model = new ArrayList<>();
//    	model.add("model");
//    	/*
//    	model.add("ATS Sedan");
//    	model.add("Trax");
//    	model.add("XTS");
//    	model.add("Silverado 1500");
//    	model.add("Civic");
//    	*/
//    	filter.setModel(model);
//    	System.out.println("4+" + filter.getModel());
//    	
//    	ArrayList<String> bodyType = new ArrayList<>();
//    	//bodyType.add("CAR");
//    	bodyType.add("bodyType");
//    	//bodyType.add("CAR");
//    	//bodyType.add("TRUCK");
//    	filter.setBodyType(bodyType);
//    	System.out.println("5+" + filter.getBodyType());
//    
//    	Double lowPrice = 0.0;
//    	Double highPrice = 60000.0;
//    	filter.setLowPrice(lowPrice);
//    	filter.setHighPrice(highPrice);
//    	System.out.println("6+" + lowPrice +" & " + highPrice);
//    	
//    	int lowYear = 2000;
//    	int highYear = 2017;
//    	filter.setLowYear(lowYear);
//    	filter.setHighYear(highYear);
//    	System.out.println("7+" + lowYear +" & " + highYear);
//    	
//    	
//    		  Vehicle v1 = new Vehicle("gmps-aj-dohmann", "new", "2014", "Cadillac", "CTS Seden", "3.6L V6 AWD Luxury", "CAR", "57620.0","1", "0");
//    		  Vehicle v2 = new Vehicle("gmps-aj-dohmann", "new", "2015", "Cadillac", "CTS Seden", "3.6L V6 AWD Luxury", "CAR", "55620.0","1", "0");
//    		  Vehicle v3 = new Vehicle("gmps-aj-dohmann", "used", "2016", "Honda", "Civic", "1.8L V6 RWD Luxury", "CAR", "50.0","1", "10");
//    		  Vehicle v4 = new Vehicle("gmps-aj-dohmann", "certified", "2017", "Honda", "Accord", "2.4L V6 RWD Sports", "CAR", "66666.0","1", "2000");
//    		  Vehicle v5 = new Vehicle("gmps-aj-dohmann", "new", "2014", "Toyota", "Tacoma", "2WD Double Cab Short Bed V6 Automatic PreRunner (GS)", "TRUCK", "27990.0","1", "0");
//    		  Vehicle v6 = new Vehicle("gmps-aj-dohmann", "used", "2015", "Jeep", "Wrangler", "4WD 4dr Unlimited X", "SUV", "38260","1", "0");
//    		  Vehicle v7 = new Vehicle("gmps-aj-dohmann", "used", "2013", "Jeep", "Wrangler", "Unlimited~4WD 4dr Sport", "SUV", "38443","1", "50");
//    		  Vehicle v8 = new Vehicle("gmps-aj-dohmann", "certified", "2004", "Mazda", "Mazda3", "4dr Sdn Auto i Touring", "CAR", "222.03","1", "0");
//    		  Vehicle v9 = new Vehicle("gmps-aj-dohmann", "certified", "2000", "Nissan", "Rogue", "4dr Sdn Auto i Touring", "CAR", "223.03","1", "0");
//    		  Vehicle v10 = new Vehicle("gmps-aj-dohmann", "certified", "1988", "Oldsmobile", "3", " ", "CAR", "0","1", "0");
//    		  
//    		  ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
//    		  vehicles.add(v1);
//    		  vehicles.add(v2);
//    		  vehicles.add(v3);
//    		  vehicles.add(v4);
//    		  vehicles.add(v5);
//    		  vehicles.add(v6);
//    		  vehicles.add(v7);
//    		  vehicles.add(v8);
//    		  vehicles.add(v9);
//    		  vehicles.add(v10);
//    		 
//    		  Inventory inventorytest = new Inventory();
//    		  inventorytest.setVehicles(vehicles);
//    		  
//    		  VehicleQueryImple test = new VehicleQueryImple();
//    		  Inventory result = test.queryByFilter(inventorytest, filter);
//    		  ArrayList<Vehicle> resultList = result.getVehicles();
//    		  System.out.println("7+"+ resultList.size());
//    		  for(int i =0; i<resultList.size(); i++) {
//    			  System.out.println("8");
//    			  System.out.println(resultList.get(i).getPrice());
//    		  }
//    		  
//    		  Sort sort = new Sort();
//    		  SortType priceasc = SortType.YEAR_DSC;
//    		  
//    		  Inventory sortedresult = sort.SortBySelection(priceasc, result);
//    		  ArrayList<Vehicle> sortedresultList = sortedresult.getVehicles();
//    		  System.out.println("9+"+ sortedresultList.size());
//    		  for(int i =0; i<sortedresultList.size(); i++) {
//    			  System.out.println("10");
//    			  System.out.println(sortedresultList.get(i).getYear());
//    		  }
//    	
//    }
//    
    

	
    
    

}
