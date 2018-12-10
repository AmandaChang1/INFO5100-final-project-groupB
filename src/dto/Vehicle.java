package dto;


public class Vehicle {
    private String id;
    private String specialId;
    private String dealerId;
    private String category;
    private String year;
    private String make;
    private String model;
    private String trim;
    private String type;
    private String price;
    private String images;
    private String discountPrice;

    public Vehicle() {
    	
    }
    public Vehicle(String dealerId, String category, String year, String make, String model, String trim, String type, String price, String images,String discountPrice) {

        this.dealerId = dealerId;
        this.category = category;
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.type = type;
        this.price = price;
        this.images = images;

        this.discountPrice=discountPrice;

    }

    //getter
    public String getId() {
        return id;
    }

    public String getSpecialId() {
        return specialId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getCategory() {
        return category;
    }

    public String getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getImages() {
        return images;
    }


    public String getDiscountprice() {
        return discountPrice;
    }


    //setter

    public void setId(String id) {
        this.id = id;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImages(String images) {
        this.images = images;
    }


    public void setDiscountprice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

}

