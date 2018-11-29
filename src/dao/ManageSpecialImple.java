package dao;


import dto.Special;
import dto.Special.*;
import dto.Specials;
import io.UserIO;
import io.UserIOInterface;

import dto.Inventory;
import dto.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class ManageSpecialImple implements ManageSpecial{
    private UserIOInterface io;
    public ManageSpecialImple() {
        io=new UserIO();
    }

    @Override
    public void addSpecial(Special special) {
        String data="";

        data="'"+special.getId()+"','"+special.getDealerId()+"','"+special.getStartDate()+"','"+special.getEndDate()+"','"+special.getTitle()+"','"+special.getDescription()+"','"+special.getDisclaimer()+"','"+special.getValue()+"','"+ special.getCriterion().getMaker()+"','"+special.getCriterion().getModel()+"','"+special.getCriterion().getStartYear()+"','"+special.getCriterion().getEndYear()+"','"+special.getCriterion().getMinPrice()+"','"+special.getCriterion().getMaxPrice()+"'";
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

        data="'"+special.getId()+"','"+special.getDealerId()+"','"+special.getStartDate()+"','"+special.getEndDate()+"','"+special.getTitle()+"','"+special.getDescription()+"','"+special.getDisclaimer()+"','"+special.getValue()+"','"+ special.getCriterion().getMaker()+"','"+special.getCriterion().getModel()+"','"+special.getCriterion().getStartYear()+"','"+special.getCriterion().getEndYear()+"','"+special.getCriterion().getMinPrice()+"','"+special.getCriterion().getMaxPrice()+"'";
        String id=special.getId();
        io.updateData("special",id,data);
    }

    @Override
    public Specials getSpecialsByDealer(String dealerId,int pageNumber) {
        ArrayList<String> set = new ArrayList<>();
        if(pageNumber > 0){
            set=io.getData("SELECT * FROM cloud.special where dealername='"+dealerId+"'"+"limit "+(pageNumber-1)*10+", 10");
        }else{
            set=io.getData("SELECT * FROM cloud.special where dealername='"+dealerId+"'");
        }
        Specials specials=new Specials();
        constructSpeicals(set, specials);
        return specials;
    }



    public void constructSpeicals(ArrayList<String> set, Specials specials) {
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
            criterion.setMaker(res[8]);
            criterion.setModel(res[9]);
            criterion.setStartYear(res[10]);
            criterion.setEndYear(res[11]);
            if(res[12].equals("null"))
                criterion.setMaxPrice(0);
            else
            criterion.setMinPrice(Float.parseFloat(res[12]));
            if(res[13].equals("null"))
                criterion.setMaxPrice(0);
            else
                criterion.setMaxPrice(Float.parseFloat(res[13]));
            special.setCriterion(criterion);
            specials.addSpecials(special);
        }
    }

//    @Override
//    public void addVehiclesSpecial(Special special) {
////        ArrayList<String> vehicles=io.getData("SELECT * FROM cloud.vehicle WHERE (make='"+special.getCriterion().getMaker()+"'" + "OR " + "model='"+special.getCriterion().getModel()+"'" + "OR " + "year='"+special.getCriterion().getYear()+"'" + "OR " + "price BETWEEN '"+special.getCriterion().getMinPrice()+"'" + "and" + "'"+special.getCriterion().getMaxPrice()+"'" + ")AND " + "dealername = '" + special.getDealerId() + "'");
//        String sql = "SELECT * FROM cloud.vehicle WHERE dealername='" +special.getDealerId()+"'";
//        if(!special.getCriterion().getMaker().equals("null")){
//            sql += " and make = '" + special.getCriterion().getMaker() + "'";
//        }
//        if(!special.getCriterion().getModel().equals("null")){
//            sql += " and model = '" + special.getCriterion().getModel() + "'";
//        }
//        if(!special.getCriterion().getYear().equals("null")){
//            sql += " and year = '" + special.getCriterion().getYear() + "'";
//        }
//        if(special.getCriterion().getMinPrice() != 0 && special.getCriterion().getMaxPrice() != 0){
//            sql += " and price BETWEEN '" + special.getCriterion().getMinPrice() + "'" + "and" + "'" + special.getCriterion().getMaxPrice() +"'";
//        }
//        ArrayList<String> vehicles=io.getData(sql);
//        Inventory inventory=new Inventory();
//        constructInventory(vehicles, inventory);
//        for(Vehicle vehicle:inventory.getVehicles()){
//            if(Float.parseFloat(vehicle.getDiscountprice()) > Float.parseFloat((vehicle.getPrice())) * special.getValue()){
//                vehicle.setDiscountprice(Float.parseFloat((vehicle.getPrice())) * special.getValue()+"");
//                vehicle.setSpecialId(special.getId());
//                ManageVehicleImple manageVehicleImple = new ManageVehicleImple();
//                manageVehicleImple.updateVehicle(vehicle);
//            }
//        }
//
//    }

    public void constructInventory(ArrayList<String> vehicles, Inventory inventory) {
        for(String a:vehicles) {
            String[] res = a.trim().split("~");
            Vehicle vehicle = new Vehicle();
            vehicle.setId(res[0]);
            vehicle.setDealerId(res[1]);
            vehicle.setCategory(res[2]);
            vehicle.setYear(res[3]);
            vehicle.setMake(res[4]);
            vehicle.setModel(res[5]);
            vehicle.setTrim(res[6]);
            vehicle.setType(res[7]);
            vehicle.setPrice(res[8]);
            vehicle.setImages(res[9]);
            vehicle.setSpecialId(res[10]);
            vehicle.setDiscountprice(res[11]);
            inventory.add(vehicle);
        }
    }

//    @Override
//    public void updateVehiclesSpecial(Special special) {
//        String sql = "SELECT * FROM cloud.vehicle WHERE dealername='" +special.getDealerId()+"'";
//        if(!special.getCriterion().getMaker().equals("null")){
//            sql += " and make = '" + special.getCriterion().getMaker() + "'";
//        }
//        if(!special.getCriterion().getModel().equals("null")){
//            sql += " and model = '" + special.getCriterion().getModel() + "'";
//        }
//        if(!special.getCriterion().getYear().equals("null")){
//            sql += " and year = '" + special.getCriterion().getYear() + "'";
//        }
//        if(special.getCriterion().getMinPrice() != 0 && special.getCriterion().getMaxPrice() != 0){
//            sql += " and price BETWEEN '" + special.getCriterion().getMinPrice() + "'" + "and" + "'" + special.getCriterion().getMaxPrice() +"'";
//        }
//        ArrayList<String> vehicles=io.getData(sql);
//        Inventory inventory=new Inventory();
//        constructInventory(vehicles, inventory);
//        for(Vehicle vehicle:inventory.getVehicles()){
//            vehicle.setDiscountprice(vehicle.getPrice());
//            ManageVehicleImple manageVehicleImple = new ManageVehicleImple();
//            manageVehicleImple.updateVehicle(vehicle);
//            Specials specials = getSpecialsByDealer(vehicle.getDealerId(),0);
//            for (int i = 0; i < specials.getSpecials().size(); i++) {
//                addVehiclesSpecial(specials.getSpecials().get(i));
//            }
//        }
//    }

    @Override
    public Inventory assocaiteSpecials(Inventory inventory) {
        HashMap<String,Specials> map = new HashMap<>();
        for(Vehicle vehicle:inventory.getVehicles()){
            if(!map.containsKey(vehicle.getDealerId())){
                Specials specials = getSpecialsByDealer(vehicle.getDealerId(),0);
                map.put(vehicle.getDealerId(),specials);
            }
            Specials specials = map.get(vehicle.getDealerId());
            for (int i = 0; i < specials.getSpecials().size(); i++) {
                    if(Float.parseFloat(vehicle.getDiscountprice()) > Float.parseFloat((vehicle.getPrice())) * specials.getSpecials().get(i).getValue()){
                    vehicle.setDiscountprice(Float.parseFloat((vehicle.getPrice())) * specials.getSpecials().get(i).getValue()+"");
                }
            }
        }
        return inventory;
    }

}


