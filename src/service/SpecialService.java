package service;

import dto.Special;
import dto.Specials;

public interface SpecialService {
    void addSpecial(Special special);
    void deleteSpecial(Special special);
    void updateSpecial(Special special);
    Specials getSpecialsByDealer(String dealerId, int pageNumber);
}
