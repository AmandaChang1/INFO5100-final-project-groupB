package main;

import dao.ManageSpecial;
import dao.ManageSpecialImple;


import dto.*;
import service.SpecialService;
import service.SpecialServiceImple;
import service.VehicleService;
import service.VehicleServiceImple;

import java.util.ArrayList;


public class app {

    public static void main(String[] args) throws Exception {



        //test Vehicle


       VehicleService service=new VehicleServiceImple();
       ArrayList<String > a=service.getAttributeList("type");


//        Vehicle vehicle=new Vehicle("1","1","1","1","1","1","1","1","1","1","1");
//        service.addVehicle(vehicle);
//       vehicle=new Vehicle("1","1","2 2","1","1","1","1","1","1","1","1");
//        service.updateVehicle(vehicle);
//        service.deleteVehicle(vehicle);
//
//
//        Inventory inventory =service.getInventoryByDealer("gmps-aj-dohmann",1);
//        if(inventory==null){
//            System.out.println("not found");
//        }
//        else{
//            for(Vehicle a:inventory.getVehicles()){
//                System.out.println(a.getId());
//            }
//        }

//        VehicleService service=new VehicleServiceImple();
//        /*Vehicle vehicle=new Vehicle("1","1","1","1","1","1","1","1","1","1");
//        service.addVehicle(vehicle);
//       vehicle=new Vehicle("1","1","22","1","1","1","1","1","1","1");
//        service.updateVehicle(vehicle);
//        service.deleteVehicle(vehicle);
//*/
//
//        Inventory inventory =service.getInventoryByDealer("gmps-aj-dohmann",1);
//        if(inventory==null){
//            System.out.println("not found");
//
//        else{
//            for(Vehicle a:inventory.getVehicles()){
//                System.out.println(a.getId());
//            }
//        }

       //
//        manageSpecial.addVehiclesSpecial(specials);
        //test Special

        SpecialService specialService=new SpecialServiceImple();

       Special.VehicleCriterion criterion=new Special.VehicleCriterion("1","1","1","1",1,1);
        Special special=new Special("1","1","1","1","1","1","1",1,criterion);
        specialService.addSpecial(special);
        special=new Special("1","1","22","1","1","1","1",1,criterion);
        specialService.updateSpecial(special);
        specialService.deleteSpecial(special);

        Specials specials=specialService.getSpecialsByDealer("gmps-davis-chevrolet",1);
        if(specials==null)
            System.out.println("not found");

        else{
            for(Special b:specials.getSpecials()){
                System.out.println(b.getDealerId());
            }
        }


        //test getDealer
/*


        Dealer dealer=dealerService.getDealerById("gmps-davis-chevrolet");
        if(dealer==null)
            System.out.println("not found");

        else{

                System.out.println(dealer.getName());

        }

        DealerService dealerService=new DealerServiceImple();
        ArrayList<Dealer> dealers=dealerService.getDealerByLocation("en_US",1);
        if(dealers==null)
            System.out.println("not found");

        else{

            for(Dealer a:dealers){
                System.out.println(a.getName());
            }

        }


        dealer.setLocation("1");
        dealerService.updateDealer(dealer);
        */




    }
}
