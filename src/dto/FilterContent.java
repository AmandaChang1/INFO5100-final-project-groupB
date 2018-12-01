
package dto;
import java.util.ArrayList;

public class FilterContent {
	private String dealerName;
	private String vehicleID;
	private ArrayList<String> condition;
	private ArrayList<String> brand; 
	private ArrayList<String> model;
	private ArrayList<String> bodyType;
	private int highPrice;
	private int lowPrice; 
	private int highYear;
	private int lowYear;
	
	

	public String getDealerName() {
		return dealerName;
	}
	
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	
	public String getVehicleID() {
		return vehicleID;
	}
	
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	
	public ArrayList<String> getCondition() {
		return condition;
	}

	public void setCondition(ArrayList<String> condition) {
		this.condition = condition;
	}

	public ArrayList<String> getBrand(){
		return brand;
	}
	
	public void setBrand(ArrayList<String> brand) {
		this.brand = brand;
	}
	
	public ArrayList<String> getModel(){
		return model;
	}

	public void setModel(ArrayList<String> model) {
		this.model = model;
	}

	public ArrayList<String> getBodyType(){
		return bodyType;
	}
	
	public void setBodyType(ArrayList<String> bodyType) {
		this.bodyType = bodyType;
	}

	
	public int getHighPrice() {
		return highPrice;
	}
	
	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}
	
	public int getLowPrice() {
		return lowPrice;
	}
	
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	
	public int getHighYear() {
		return highYear;
	}
	
	public void setHighYear(int highYear) {
		this.highYear = highYear;
	}
	
	public int getLowYear() {
		return lowYear;
	}
	
	public void setLowYear(int lowYear) {
		this.lowYear = lowYear;
	}
	
	


}
