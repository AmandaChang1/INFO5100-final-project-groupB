package main;


import dao.ManageVehicle;
import dao.ManageVehicleImple;
import dto.*;
import service.*;


public class app {

    public static void main(String[] args) throws Exception {


        //test Vehicle

//        VehicleService service=new VehicleServiceImple();
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
        Special.VehicleCriterion criterion=new Special.VehicleCriterion("Ford","Mustang","CAR","2000","2003",10000,20000);
        Special.Discount discount = new Special.Discount(true,1.5f);
        Special special=new Special("38","gmps-tincher-london1","2018-12-1","2018-12-12","1","1","1",criterion,discount);
        SpecialService specialService=new SpecialServiceImpl();
        specialService.deleteSpecial(special);
//        VehicleService vehicleService=new VehicleServiceImple();
//        Inventory inventory = vehicleService.getInventoryByDealer("gmps-tincher-london1",0);
//        System.out.println(inventory);
//        ManageVehicle manageVehicle = new ManageVehicleImple();
//        Inventory inventory = manageVehicle.getVehicle("gmps-goldstein1",0);
//        System.out.println(inventory);
//        SpecialServiceImple specialServiceImple = new SpecialServiceImple();
//
////        Special special = new Special("31","gmps-goldstein","2018-12-1","2018-12-31","WinterDiscount","Discount for Winter Holiday","disclaimer",0.5f,new Special.VehicleCriterion("GMC1","Yukon XL","2016",60000f,70000f));
//        Special special = new Special("14","gmps-goldstein","2018-12-1","2018-12-31","WinterDiscount","Discount for Winter Holiday","disclaimer",0.1f,new Special.VehicleCriterion("GMC1","Yukon XL","2016",60000f,70000f));
//        specialServiceImple.updateSpecial(special);
//        manageSpecial.addSpecial(special);
//        Specials specials = manageSpecial.getSpecialsByDealer("gmps-goldstein",1);
//        manageSpecial.addVehiclesSpecial(specials.getSpecials().get(0));
//        manageSpecial.addVehiclesSpecial(specials.getSpecials().get(1));

//        manageSpecial.deleteSpecial(specials.getSpecials().get(1));





        //        manageSpecial.addVehiclesSpecial(specials);
        //test Special
      /*
        SpecialService specialService=new SpecialServiceImple();

       Special.VehicleCriterion criterion=new Special.VehicleCriterion("1","1","1",1,1);
        Special special=new Special("1","1","1","1","1","1","1",1,criterion);
        specialService.addSpecial(special);
        special=new Special("1","1","22","1","1","1","1",1,criterion);
        specialService.updateSpecial(special);
        specialService.deleteSpecial(special);

        Specials specials=specialService.getSpecialsByDealer("gmps-davis-chevrolet");
        if(specials==null)
            System.out.println("not found");

        else{
            for(Special a:specials.getSpecials()){
                System.out.println(a.getDealerId());
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
