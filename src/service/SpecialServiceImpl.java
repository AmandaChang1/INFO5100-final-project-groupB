package service;

import dao.ManageSpecial;
import dao.ManageSpecialImple;
import dto.Special;
import dto.Specials;

public class SpecialServiceImpl implements SpecialService{
    private ManageSpecial manageSpecial;
    public SpecialServiceImpl() {
        manageSpecial=new ManageSpecialImple();
    }

    @Override
    public void addSpecial(Special special) {
        manageSpecial.addSpecial(special);
    }

    @Override
    public void deleteSpecial(Special special) {
manageSpecial.deleteSpecial(special);
    }

    @Override
    public void updateSpecial(Special special) {
manageSpecial.updateSpecial(special);
    }

    @Override
    public Specials getSpecialsByDealer(String dealerId, int pageNumber) {
        Specials specials=manageSpecial.getSpecialsByDealer(dealerId,pageNumber);
        return  specials;
    }
}
