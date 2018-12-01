package dao;

import dto.Inventory;
import dto.Vehicle;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    class SortbyYear implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle v1 = (Vehicle) o1;
            Vehicle v2 = (Vehicle) o2;
            if (Integer.valueOf(v1.getYear()).equals(Integer.valueOf(v2.getYear()))) {
                return 0;
            } else if (Integer.valueOf(v1.getYear())>(Integer.valueOf(v2.getYear()))) {
                return 1;
            } else if (Integer.valueOf(v1.getYear())<(Integer.valueOf(v2.getYear()))) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    ;


    class SortByPrice implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle v1 = (Vehicle) o1;
            Vehicle v2 = (Vehicle) o2;
            if (Integer.valueOf(v1.getPrice()).equals(Integer.valueOf(v2.getPrice()))) {
                return 0;
            } else if (Integer.valueOf(v1.getPrice())>(Integer.valueOf(v2.getPrice()))) {
                return 1;
            } else if (Integer.valueOf(v1.getPrice())<(Integer.valueOf(v2.getPrice()))) {
                return -1;
            } else {
                return 0;
            }
        }
    }

  /*  public static void main(String args[]) {
        Vehicle v1 = new Vehicle("a", "b", "1993", "d",
                "e", "f", "g", "1800", "i", "j");
        Vehicle v2 = new Vehicle("a", "b", "1994", "d",
                "e", "f", "g", "1900", "i", "j");
        Vehicle v3 = new Vehicle("a", "b", "1995", "d",
                "e", "f", "g", "10000", "i", "j");
        Inventory inventory = new Inventory();
        inventory.add(v1);
        inventory.add(v2);
        inventory.add(v3);
        Collections.sort(inventory, new SortByPrice());
    }*/
}

