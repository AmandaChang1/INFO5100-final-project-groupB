package service;


import dto.Dealer;
import dto.SearchResult;

import java.util.ArrayList;

public interface DealerService {
    void updateDealer(Dealer dealer);
    ArrayList<Dealer> getDealerByName(String dealerName);
    SearchResult<Dealer> getDealerByLocation(String location, int pageNumber);
    SearchResult<Dealer> getDealerByZipcode(String location,int pageNumber);
    ArrayList<String> getAttributeList(String attribute);
}
