package service;


import dto.Dealer;

import java.util.ArrayList;

public interface DealerService {
    void updateDealer(Dealer dealer);
    ArrayList<Dealer> getDealerByName(String dealerName);
    ArrayList<Dealer> getDealerByLocation(String location,int pageNumber);
    ArrayList<Dealer> getDealerByZipcode(String location,int pageNumber);
    ArrayList<String> getAttributeList(String attribute);
}
