package dao;

import dto.Inventory;
import dto.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort{
    public Inventory SortBySelection(SortType sortType, Inventory inventory){
        ArrayList<Vehicle> vehicles = inventory.getVehicles();
        Inventory output = new Inventory();
        //ArrayList<Vehicle> out = new ArrayList<Vehicle>();
        switch (sortType){
            case YEAR_ASC:
                Collections.sort(vehicles,new SortByYearAsc());break;
            case YEAR_DSC:
                Collections.sort(vehicles,new SortByYearDes());break;
            case PRICE_ASC:
                Collections.sort(vehicles,new SortByPriceAsc());break;
            case PRICE_DSC:
                Collections.sort(vehicles,new SortByPriceDes());break;
        }
        output.setVehicles(vehicles);
        return output;
    }
    class SortByYearAsc implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Integer.valueOf(v1.getYear()).compareTo(Integer.valueOf(v2.getYear())); //年份升序
            if (i > 0){
                return 1;
            }
            else if (i < 0){
                return -1;
            }
            else
                return 0;
        }
    }
    class SortByYearDes implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Integer.valueOf(v1.getYear()).compareTo(Integer.valueOf(v2.getYear())); //年份降序
            if (i < 0){
                return 1;
            }
            else if (i > 0){
                return -1;
            }
            else
                return 0;
        }
    }
    class SortByPriceAsc implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Double.valueOf(v1.getPrice()).compareTo(Double.valueOf(v2.getDiscountprice())); //价格升序
            if (i > 0){
                return 1;
            }
            else if (i < 0){
                return -1;
            }
            else
                return 0;
        }
    }
    class SortByPriceDes implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Double.valueOf(v1.getPrice()).compareTo(Double.valueOf(v2.getDiscountprice())); //价格降序
            if (i < 0){
                return 1;
            }
            else if (i > 0){
                return -1;
            }
            else
                return 0;
        }
    }



}

