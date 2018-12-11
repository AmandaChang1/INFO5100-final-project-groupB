package ui;

import javax.swing.*;
import javax.swing.table.*;

import dto.*;
import service.*;
import dao.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Vector;

public class VehicleTable extends JFrame {
    private String dealername;
    JPanel panel = new JPanel();
    Vector<String> dataTitle = new Vector<>();//name of the every row
    Vector<Vector<String>> data = new Vector<>();//data in every cell
    JScrollPane scroll = new JScrollPane();
    JTable table;
    DefaultTableModel tableModel;
    JPanel updateP = new JPanel();
    JButton b1 = new JButton("add");
    JButton b2 = new JButton("delete");
    JButton b3 = new JButton("update");
    JButton b4 = new JButton("shuaxin");
    JButton page = new JButton("page");
    int pageNum = 0;
    VehicleService vehicle = new VehicleServiceImple();
    Inventory inventory;
    Vector v;


    public VehicleTable(String dealername) throws ParseException {//String dealername
        this.dealername = dealername;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inventory = vehicle.getInventoryByDealer(dealername, pageNum);
        tableInit();
        //updateTable();
    }


//    private  void updateTable(){
//        v.add(inventory.getVehicle(table.getSelectedRow()).getPrice());
//        v.add(inventory.getVehicle(table.getSelectedRow()).getType());
//        data.add(v);
//    }
    private void tableInit() {
        setTitle("Vehicle Table List");
        this.createTable();
        tableModel = new DefaultTableModel(data, dataTitle);
        table = new JTable(tableModel);

        //Set table sorter and set the mode as single selection
        table.setRowSorter(new TableRowSorter<TableModel>(tableModel));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.ORANGE);
        scroll.setViewportView(table);
        scroll.setSize(600,600);
        panel.setSize(300,300);
        //getContentPane().setBackground(Color.ORANGE);
        //scroll.setPreferredSize(new Dimension(800,900));


        //add new data to inventory
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddCars ac = new AddCars();
                ac.add();
            }
        });
        panel.add(b1);

        //delete the data of selected row
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = table.getSelectedRow();
                ManageVehicle manageVehicle = new ManageVehicleImple();
                Vehicle vehicle = new Vehicle();

                vehicle.setDealerId(tableModel.getValueAt(row,0).toString());
                vehicle.setId(tableModel.getValueAt(row,1).toString());
                vehicle.setCategory(tableModel.getValueAt(row,2).toString());
                vehicle.setYear(tableModel.getValueAt(row,3).toString());
                vehicle.setMake(tableModel.getValueAt(row,4).toString());
                vehicle.setModel(tableModel.getValueAt(row,5).toString());
                vehicle.setTrim(tableModel.getValueAt(row,6).toString());
                vehicle.setType(tableModel.getValueAt(row,7).toString());
                vehicle.setPrice(tableModel.getValueAt(row,8).toString());
                vehicle.setImages(tableModel.getValueAt(row,9).toString());

                if(row != -1){
                    tableModel.removeRow(row);
                    manageVehicle.deleteVehicle(vehicle);
                }
            }
        });
        panel.add(b2);

        //modify the data of selected row
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = table.getSelectedRow();
                if(row != -1){
                    Modify modify = new Modify(inventory.getVehicle(row),dealername);
//                    inventory=vehicle.getInventoryByDealer("gmps-priority", pageNum);

                }
            }
        });
        panel.add(b3);
        //panel.add(page);

        

        add(scroll, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.pack();
    }



        public void createTable(){
            this.dataTitle.add(("Dealer Id"));
            this.dataTitle.add("Car Id");
            this.dataTitle.add("Category");
            this.dataTitle.add("Year");
            this.dataTitle.add("Make");
            this.dataTitle.add("Model");
            this.dataTitle.add("Trim");
            this.dataTitle.add("Type");
            this.dataTitle.add("Price");
            this.dataTitle.add("Image");


            for (int i = 0; i < inventory.getVehicles().size(); i++) {
                v = new Vector();
                v.add(inventory.getVehicles().get(i).getDealerId());
                v.add(inventory.getVehicles().get(i).getId());
                v.add(inventory.getVehicles().get(i).getCategory());
                v.add(inventory.getVehicles().get(i).getYear());
                v.add(inventory.getVehicles().get(i).getMake());
                v.add(inventory.getVehicles().get(i).getModel());
                v.add(inventory.getVehicles().get(i).getTrim());
                v.add(inventory.getVehicles().get(i).getType());
                v.add(inventory.getVehicles().get(i).getPrice());
                v.add(inventory.getVehicles().get(i).getImages());

                data.add(v);
                }
           // }
//            page.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent actionEvent) {
//
//                    pageNum++;
//                    Inventory inventory = vehicle.getInventoryByDealer("gmps-priority", pageNum);
//                    for (int i = 0; i < inventory.getVehicles().size(); i++) {
//                        Vector v = new Vector();
//                        v.add(inventory.getVehicles().get(i).getDealerId());
//                        v.add(inventory.getVehicles().get(i).getId());
//                        v.add(inventory.getVehicles().get(i).getCategory());
//                        v.add(inventory.getVehicles().get(i).getYear());
//                        v.add(inventory.getVehicles().get(i).getMake());
//                        v.add(inventory.getVehicles().get(i).getModel());
//                        v.add(inventory.getVehicles().get(i).getTrim());
//                        v.add(inventory.getVehicles().get(i).getType());
//                        v.add(inventory.getVehicles().get(i).getPrice());
//                        v.add(inventory.getVehicles().get(i).getImages());
//
//                        data.add(v);
//                    }
//                }
//            });
        }


//    public static void main(String[] args) throws ParseException {
//        VehicleTable table = new VehicleTable();
//
//    }
}

