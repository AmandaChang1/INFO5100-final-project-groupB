package service;

import dao.ManageDealer;
import dao.ManageDealerImple;
import dto.Dealer;
import dto.SearchResult;

import java.util.ArrayList;

public class DealerServiceImple implements DealerService{
    private ManageDealer manageDealer;
    public DealerServiceImple() {
        manageDealer=new ManageDealerImple();
    }

    @Override
    public void updateDealer(Dealer dealer) {
        manageDealer.updateDealer(dealer);

    }

    @Override
    public ArrayList<Dealer> getDealerByName(String dealerName) {

        return manageDealer.getDealerByName(dealerName);
    }

    @Override
    public SearchResult<Dealer> getDealerByZipcode(String zipcode, int pageNumber) {
        return manageDealer.getDealerByZipcode(zipcode,pageNumber);
    }

    @Override
    public SearchResult<Dealer> getDealerByLocation(String location, int pageNumber) {
        return manageDealer.getDealerByLocation(location,pageNumber);
    }

    @Override
    public ArrayList<String> getAttributeList(String attribute) {
        ArrayList<String> typeList=manageDealer.getAttributeList(attribute);
        return typeList;
    }
}
