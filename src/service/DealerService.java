package service;


import dto.Dealer;

import java.util.ArrayList;

public interface DealerService {
    void updateDealer(Dealer dealer);
    Dealer getDealerById(String dealerId);
    ArrayList<Dealer> getDealerByLocation(String location,int pageNumber);
}
