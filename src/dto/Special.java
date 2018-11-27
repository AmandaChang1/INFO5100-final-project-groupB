package dto;



public class Special {
    private String id;
    private String dealerId;
    private String startDate, endDate;
    private String title;
    private String description;
    private String disclaimer;
    private float value;
    private VehicleCriterion criterion;


   public static class VehicleCriterion{

        private String maker;
        private String model;
        private String year;
        private float minPrice;
        private float maxPrice;

       public VehicleCriterion() {
       }

       public String getMaker() {

            return maker;
        }
        public void setMaker(String make) {
            this.maker = make;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public String getYear() {
            return year;
        }
        public void setYear(String year) {
            this.year = year;
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


        public VehicleCriterion(String maker, String model, String year, float minPrice, float maxPrice) {
            super();
            this.maker = maker;
            this.model = model;
            this.year = year;
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
        }
        public void setMaxPrice(float maxPrice) {
            this.maxPrice = maxPrice;
        }

    }

    public Special() {

    }

    public Special(String id,float value,String dealerId,String maker) {
        this.id = id;
        this.value = value;
        this.dealerId = dealerId;
        VehicleCriterion vehicleCriterion = new VehicleCriterion();
        this.criterion = vehicleCriterion;
        this.criterion.maker = maker;
    }

    public Special(String id, String dealerid, String startDate, String endDate, String title, String description, String disclaimer, float value, VehicleCriterion criterion) {
        this.id = id;
        this.dealerId = dealerid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
        this.disclaimer = disclaimer;
        this.value = value;
        this.criterion = criterion;
    }

    //getter

    public String getId(){
        return id;
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public float getValue() {
        return value;
    }

    public VehicleCriterion getCriterion() {
        return criterion;
    }

    //setter


    public void setId(String id) {
        this.id = id;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setCriterion(VehicleCriterion criterion) {
        this.criterion = criterion;
    }
}
