package dto;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Special {
    private String id;
    private String dealerName;
    private String startDate, endDate;
    private String title;
    private String description;
    private Discount discount;
    private VehicleCriterion criterion;

    public Special() {
    }

    public Special(Special sp) {
        this.id = null;
        this.dealerName = sp.dealerName;
        this.startDate = sp.startDate;
        this.endDate = sp.endDate;
        this.title = sp.title;
        this.description = sp.description;

        if (sp.discount != null) {
            this.discount = new Discount(sp.discount);
        }

        if (sp.criterion != null) {
            this.criterion = new VehicleCriterion(sp.criterion);
        }

    }

    public Special(String id, String dealerName, String startDate, String endDate, String title, String description, Discount discount, VehicleCriterion criterion) {
        this.id = id;
        this.dealerName = dealerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
        this.discount = discount;
        this.criterion = criterion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // TODO: for yang
    public boolean isExpired() {

        java.util.Date nowdate = new java.util.Date();
        String startDateString = getStartDate();
        String endDateString = getEndDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try{
            Date end = sdf.parse(endDateString);
            Date start = sdf.parse(startDateString);
            ImageIcon validImageIcon = new ImageIcon("resources/icons/valid.png");
            ImageIcon invalidImageIcon = new ImageIcon("resources/icons/invalid.png");
            JLabel validLabel = new JLabel(validImageIcon);
            JLabel invalidLabel = new JLabel(invalidImageIcon);
            validLabel.setOpaque(true);
            invalidLabel.setOpaque(true);
            if(end.after(nowdate) && start.before(nowdate)) return false;
            else return true;
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return false;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerId) {
        this.dealerName = dealerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public VehicleCriterion getCriterion() {
        return criterion;
    }

    public void setCriterion(VehicleCriterion criterion) {
        this.criterion = criterion;
    }

    public String getCriterionString(){
        return criterion.getCriterionString();
    }

    public String toString() {
        VehicleCriterion vc = this.getCriterion();
        String searchStr = "";
        if (vc != null)
            searchStr += vc.getCriterionString();

        return this.getDescription() + this.getTitle() + searchStr;
    }
}
