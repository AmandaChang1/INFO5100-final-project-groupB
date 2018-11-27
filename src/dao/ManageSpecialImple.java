package dao;


import dto.Special;
import dto.Special.*;
import dto.Specials;
import io.UserIO;
import io.UserIOInterface;

import dto.Inventory;
import dto.Special;
import dto.Special.*;
import dto.Specials;
import dto.Vehicle;
import io.UserIO;
import io.UserIOInterface;

import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;

public class ManageSpecialImple implements ManageSpecial{
    private UserIOInterface io;
    public ManageSpecialImple() {
        io=new UserIO();
    }

    @Override
    public void addSpecial(Special special) {

        String data="";

        data=special.getId()+","+special.getDealerId()+","+special.getStartDate()+","+special.getEndDate()+","+special.getTitle()+","+special.getDescription()+","+special.getDisclaimer()+","+special.getValue()+","+
                special.getCriterion().getMaker()+","+special.getCriterion().getModel()+","+special.getCriterion().getYear()+","+special.getCriterion().getMinPrice()+","+special.getCriterion().getMaxPrice();
        io.addData("special",data);
    }

    @Override
    public void deleteSpecial(Special special) {
        String data="";
        data=special.getId();
        io.deleteData("special",data);

    }

    @Override
    public void updateSpecial(Special special) {
        String data="";

        data=special.getId()+","+special.getDealerId()+","+special.getStartDate()+","+special.getEndDate()+","+special.getTitle()+","+special.getDescription()+","+special.getDisclaimer()+","+special.getValue()+","+
                special.getCriterion().getMaker()+","+special.getCriterion().getModel()+","+special.getCriterion().getYear()+","+special.getCriterion().getMinPrice()+","+special.getCriterion().getMaxPrice();
        String id=special.getId();
        io.updateData("special",id,data);
    }

    @Override
    public Specials getSpecialsByDealer(String dealerId,int pageNumber) {

        ArrayList<String> set=io.getData("SELECT * FROM cloud.special where dealername='"+dealerId+"'"+"limit "+(pageNumber-1)*10+", 10");
        Specials specials=new Specials();
        for(String a:set) {
            String[] res = a.trim().split("~");
            Special special = new Special();
            special.setId(res[0]);
            special.setDealerId(res[1]);
           special.setStartDate(res[2]);
            special.setEndDate(res[3]);
            special.setTitle(res[4]);
            special.setDescription(res[5]);
            special.setDisclaimer(res[6]);
            if(res[7].equals("null"))
                special.setValue(0);
            else
                special.setValue(Float.parseFloat(res[7]));
            VehicleCriterion criterion=new VehicleCriterion();
            criterion.setMaker(res[7]);
            criterion.setModel(res[8]);
            criterion.setYear(res[9]);
            if(res[10].equals("null"))
                criterion.setMaxPrice(0);
            else
            criterion.setMinPrice(Float.parseFloat(res[10]));
            if(res[11].equals("null"))
                criterion.setMaxPrice(0);
            else
                criterion.setMaxPrice(Float.parseFloat(res[11]));
            special.setCriterion(criterion);
            specials.addSpecials(special);
        }
        return specials;
    }


}


