package dao;

import dto.Inventory;
import dto.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort{
    public void SortBySelection(SortType sortType, Inventory inventory){
        ArrayList<Vehicle> vehicles = inventory.getVehicles();
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
    }
    class SortByYearAsc implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Integer.valueOf(v1.getYear()).compareTo(Integer.valueOf(v2.getYear())); //比较名字字符串
            if (i > 0){
                return 1;
            }
            if (i < 0){
                return -1;
            }else
            return 0;
        }
    }
    class SortByYearDes implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Integer.valueOf(v1.getYear()).compareTo(Integer.valueOf(v2.getYear())); //比较名字字符串
            if (i < 0){
                return 1;
            }
            if (i > 0){
                return -1;
            }else
                return 0;
        }
    }
    class SortByPriceAsc implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Integer.valueOf(v1.getPrice()).compareTo(Integer.valueOf(v2.getPrice())); //比较名字字符串
            if (i > 0){
                return 1;
            }
            if (i < 0){
                return -1;
            }else
                return 0;
        }
    }
    class SortByPriceDes implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle v1, Vehicle v2) {
            int i = Integer.valueOf(v1.getPrice()).compareTo(Integer.valueOf(v2.getPrice())); //比较名字字符串
            if (i < 0){
                return 1;
            }
            if (i > 0){
                return -1;
            }else
                return 0;
        }
    }



}



