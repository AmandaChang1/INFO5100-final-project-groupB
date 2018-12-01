package dto;
import java.util.ArrayList;


public class FilterContentModel {
	private ArrayList<String> vehicalId;
	private ArrayList<String> brand; 
	private ArrayList<String> model; 
	private ArrayList<String> trim; 
	private int maxprice;
	private int minprice;
	private int maxyear;
	private int minyear;
	
	
	public ArrayList<String> getVehicalId() {
		return vehicalId;
	}
	
	public void setVehicalId(ArrayList<String> vehicalId) {
		this.vehicalId = vehicalId;
	}
	
	public ArrayList<String> getBrand() {
		return brand;
	}
	
	public void setBrand(ArrayList<String> brand) {
		this.brand = brand;
	}
	
	public ArrayList<String> getModel() {
		return model;
	}
	
	public void setModel(ArrayList<String> model) {
		this.model = model;
	}
	
	public ArrayList<String> getTrim() {
		return trim;
	}
	
	public void setTrim(ArrayList<String> trim) {
		this.trim = trim;
	}
	
	public int getMaxprice() {
		return maxprice;
	}
	
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	
	public int getMinprice() {
		return minprice;
	}
	
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	
	public int getMaxyear() {
		return maxyear;
	}
	
	public void setMaxyear(int maxyear) {
		this.maxyear = maxyear;
	}
	
	public int getMinyear() {
		return minyear;
	}
	 
	public void setMinyear(int minyear) {
		this.minyear = minyear;
	}
	
	
	


}
