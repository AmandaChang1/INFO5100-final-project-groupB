package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class VehicleCriterion implements Serializable {
    private String maker;
    private String model;


    private ArrayList<String> category;
    private ArrayList<String> type;

    private String startYear;
    private String endYear;
    private float minPrice;
    private float maxPrice;


    //private String vehicleID;

    public VehicleCriterion() {
        this.category = new ArrayList<>();
        this.type = new ArrayList<>();
    }

    public  VehicleCriterion(VehicleCriterion vc) {
        this.maker = vc.maker;
        this.model = vc.model;

        this.startYear = vc.startYear;
        this.endYear = vc.endYear;
        this.minPrice = vc.minPrice;
        this.maxPrice = vc.maxPrice;

        this.category = new ArrayList<>(vc.category);
        this.type = new ArrayList<>(vc.type);
    }


    public VehicleCriterion(String maker, String model, String startYear, String endYear, float minPrice, float maxPrice) {
        this.maker = maker;
        this.model = model;

        this.startYear = startYear;
        this.endYear = endYear;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;

        this.category = new ArrayList<>();
        this.type = new ArrayList<>();

        //this.vehicleID = null;
    }

    public void reset() {
        maker = null;
        minPrice = 0;
        maxPrice = 0;
        if (category != null)
            category.clear();
        if (type != null)
            type.clear();

        startYear = null;
        endYear = "2018";
    }

    public String getCriterionString(){
        return "Maker: " + maker + "\nModel: " + model + "\nType: " + type + "\nCategory: " + category + "\nStart year: " + startYear +
                "\nEnd year: " + endYear + "\nMin price: " + minPrice + "\nMax price: " + maxPrice;
    }

//    public String getVehicleID() {
//        return vehicleID;
//    }
//
//    public void setVehicleID(String vehicleID) {
//        this.vehicleID = vehicleID;
//    }

    public void addCategory(String item) {
        category.add(item);
    }

    public void addType(String item) {
        type.add(item);
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }
}
