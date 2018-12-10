package dto;
import java.util.ArrayList;


public class FilterContentModel {
	private ArrayList<String> vehicalId;
	private ArrayList<String> brand; 
	private ArrayList<String> model; 
	private ArrayList<String> trim; 
	private double maxprice;
	private double minprice;
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
	
	public double getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}

	public double getMinprice() {
		return minprice;
	}

	public void setMinprice(double minprice) {
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
