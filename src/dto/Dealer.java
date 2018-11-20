package dto;



public class Dealer  {
    private String name;
    private String url;
    private String location;

    public Dealer(String name, String url, String location) {
        this.name = name;
        this.url = url;
        this.location = location;
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
}
