package dao;

import dto.Dealer;
import dto.SearchResult;

import java.util.ArrayList;

public interface ManageDealer {
    void updateDealer(Dealer dealer);
    ArrayList<Dealer> getDealerByName(String dealerIdName);
    SearchResult<Dealer> getDealerByZipcode(String zipcode,int pageNumber);
    SearchResult<Dealer> getDealerByLocation(String location, int pageNumber);
    ArrayList<String> getAttributeList(String attribute);

}
