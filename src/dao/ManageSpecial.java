package dao;

import dto.Inventory;
import dto.Special;
import dto.Specials;
import dto.Vehicle;

import java.text.ParseException;
import java.util.ArrayList;

public interface ManageSpecial {
    void addSpecial(Special special);
    void deleteSpecial(Special special);
    void updateSpecial(Special special);
    Specials getSpecialsByDealer(String dealerId,int pageNumber);
    Inventory assocaiteSpecials(Inventory inventory) throws ParseException;
}
