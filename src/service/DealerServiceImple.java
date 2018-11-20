package service;

import dao.ManageDealer;
import dao.ManageDealerImple;
import dto.Dealer;

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
    public Dealer getDealerById(String dealerId) {

        return manageDealer.getDealerById(dealerId);
    }

    @Override
    public ArrayList<Dealer> getDealerByLocation(String location) {
        return manageDealer.getDealerByLocation(location);
    }
}
