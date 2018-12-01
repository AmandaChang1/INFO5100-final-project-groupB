package dao;

import dto.Inventory;
import dto.Vehicle;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort{
    class SortbyYearAsc implements Comparator<Vehicle> {
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
    class SortbyYearDes implements Comparator<Vehicle> {
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
    class SortbyPriceAsc implements Comparator<Vehicle> {
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
    class SortbyPriceDes implements Comparator<Vehicle> {
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



