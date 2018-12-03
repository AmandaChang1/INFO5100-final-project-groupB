package service;


import dao.VehicleQuery;
import dao.VehicleQueryImple;
import dto.FilterContent;
import dto.FilterContentModel;
import dto.Inventory;
import dto.Vehicle;

public class VehicleQuerySortServiceImple implements VehicleQuerySortService{


	public VehicleQuerySortServiceImple() {

	}

	@Override
	public FilterContentModel setModel(Inventory inventory) {
		VehicleQuery vehicleQuery = new VehicleQueryImple();
		return vehicleQuery.setModel(inventory);
	}

	@Override
	public Inventory Query (Inventory inventory, FilterContent filterContentSelected) {
		VehicleQuery vehicleQuery = new VehicleQueryImple(inventory);
		return vehicleQuery.queryByFilter(inventory, filterContentSelected);
	}

	@Override
	public Vehicle QueryByCarID(String carID, Inventory inventory) {
		VehicleQuery vehicleQuery = new VehicleQueryImple(inventory);
		return vehicleQuery.queryByCarID(carID, inventory);
	}

	@Override
	public Inventory QueryBySpecialID(String specialID, Inventory inventory) {
		VehicleQuery vehicleQuery = new VehicleQueryImple(inventory);
		return vehicleQuery.queryBySpecialID(specialID, inventory);
	}
	/*
	public Inventory Sort(String sortType, Inventory inventory) {

		return ;
	}
	*/
}
