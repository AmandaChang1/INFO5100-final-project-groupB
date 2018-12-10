package service;

import dto.FilterContent;
import dto.FilterContentModel;
import dto.Inventory;
import dto.Vehicle;

public interface VehicleQuerySortService {
	
	FilterContentModel setModel(Inventory inventory);
	
	Inventory Query (Inventory inventory, FilterContent filterContentSelected);
	
	Vehicle QueryByCarID(String carID, Inventory inventory);
	
	Inventory QueryBySpecialID(String specialID, Inventory inventory);
	
}
