package dao;

import java.util.ArrayList;

import dto.*;

public interface VehicleQuery {

	Inventory queryByFilter(Inventory inventory, FilterContent filterContentSelected);

	Vehicle queryByCarID(String carID, Inventory inventory);

	Inventory queryBySpecialID(String specialID, Inventory inventory);

	FilterContentModel setModel(Inventory inventory);
	
}
