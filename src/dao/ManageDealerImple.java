package dao;

import dto.Dealer;
import io.UserIO;
import io.UserIOInterface;

import java.util.ArrayList;

public class ManageDealerImple implements ManageDealer{
    private UserIOInterface io;

    public ManageDealerImple() {
        io=new UserIO();
    }

    @Override
    public void updateDealer(Dealer dealer) {
        String data="";
        data="'"+dealer.getName()+"'"+","+"'"+dealer.getUrl()+"'"+","+"'"+dealer.getLocation()+"'";
        io.updateData("dealer",dealer.getName(),data);

    }

    @Override
    public Dealer getDealerById(String dealerId) {
        ArrayList<String> res=io.getData("SELECT * FROM cloud.dealer WHERE dealername='"+dealerId+"'");
        String[] a=res.get(0).trim().split("~");

        Dealer dealer=new Dealer(a[0],a[1],a[2]);
        return dealer;
    }

    @Override
    public ArrayList<Dealer> getDealerByLocation(String location) {
        ArrayList<String> resset=io.getData("SELECT * FROM cloud.dealer WHERE location='"+location+"'");
        ArrayList<Dealer> dealers=new ArrayList<>();
        for(String res:resset){
            String[] a=res.trim().split("~");
            Dealer dealer=new Dealer(a[0],a[1],a[2]);
            dealers.add(dealer);
        }
        return dealers;
    }
}
