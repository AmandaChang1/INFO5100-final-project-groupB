package dto;



public class Dealer  {
    private String name;
    private String url;
    private String location;
    private String zipcode;
    private String address;

    public Dealer(String name, String url, String location, String zipcode, String address) {
        this.name = name;
        this.url = url;
        this.location = location;
        this.zipcode = zipcode;
        this.address = address;
    }


    //getter

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return location;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getAddress() {
        return address;
    }

    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
