package dao;

import dto.Dealer;

import java.util.ArrayList;

public interface ManageDealer {
    void updateDealer(Dealer dealer);
    Dealer getDealerById(String dealerId);
    ArrayList<Dealer> getDealerByLocation(String location);
}
