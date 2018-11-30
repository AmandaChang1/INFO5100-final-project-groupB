package dao;

import dto.Dealer;

import java.util.ArrayList;

public interface ManageDealer {
    void updateDealer(Dealer dealer);
    ArrayList<Dealer> getDealerByName(String dealerIdName);
    ArrayList<Dealer> getDealerByZipcode(String zipcode,int pageNumber);
    ArrayList<Dealer> getDealerByLocation(String location,int pageNumber);
    ArrayList<String> getAttributeList(String attribute);

}
