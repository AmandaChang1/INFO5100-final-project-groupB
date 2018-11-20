package dao;

import dto.Inventory;
import dto.Special;
import dto.Specials;
import dto.Vehicle;

public interface ManageSpecial {
    void addSpecial(Special special);
    void deleteSpecial(Special special);
    void updateSpecial(Special special);
    Specials getSpecialsByDealer(String dealerId);
}
