package ui.SearchDealer;

import dto.Dealer;
import service.DealerService;
import service.DealerServiceImple;
import ui.DealerSearchUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class SearchPanel extends MyPanel {

    DealerService dealerService;
    MyComboBox comboBox1,comboBox2,comboBox3;
    SearchButton searchButton,resetButton;

    public SearchPanel() {
        dealerService=new DealerServiceImple();
        setLayoutAddComponents();
        addListener();
    }



    private void setLayoutAddComponents(){

        searchButton=new SearchButton();
        resetButton=new SearchButton();
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

//      MyPanel panel0=new MyPanel();
//      panel0.setBounds(0,0,200,250);
//      panel0.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        resetButton.setLocation(50,50);
        MyPanel panel1=new MyPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
        MyPanel panel2=new MyPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
        MyPanel panel3=new MyPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT,50,10));



        MyLabel label11=new  MyLabel("NO.01                            ");
        label11.setFont(new Font("Bauhaus 93",Font.PLAIN,12));
        MyLabel label12=new  MyLabel("Dealer Name          ");
        label12.setFont(new Font("Calibri",Font.BOLD,15));
        comboBox1=new MyComboBox();


        MyLabel label21=new MyLabel("NO.02                            ");
        label21.setFont(new Font("Bauhaus 93",Font.PLAIN,12));
        MyLabel label22=new  MyLabel("Zipcode                 ");
        label22.setFont(new Font("Calibri",Font.BOLD,15));
        comboBox2=new MyComboBox();


        MyLabel label31=new  MyLabel("NO.03                            ");
        label31.setFont(new Font("Bauhaus 93",Font.PLAIN,12));
        MyLabel label32=new  MyLabel("Location               ");
        label32.setFont(new Font("Calibri",Font.BOLD,15));
        comboBox3=new MyComboBox();

        panel1.add(label11);
        panel1.add(label21);
        panel1.add(label31);

        panel2.add(label12);
        panel2.add(label22);
        panel2.add(label32);

        addItemToCombobox(comboBox1,"dealername");
        addItemToCombobox(comboBox2,"zipcode");
        addItemToCombobox(comboBox3,"location");
        panel3.add(comboBox1);
        panel3.add(comboBox2);
        panel3.add(comboBox3);

        add(panel1);
        add(panel2);
        add(panel3);
        add(searchButton);


        setBounds(300,590,800,250);

    }
    private void addItemToCombobox(MyComboBox myComboBox,String attribute){
        myComboBox.addItem(null);
        ArrayList<String> res=dealerService.getAttributeList(attribute);
        for(String a:res)
            myComboBox.addItem(a);
    }

    private void addListener() {

        ComboBoxListener cbl = new ComboBoxListener();
        comboBox2.addItemListener(cbl);
        comboBox3.addItemListener(cbl);

//        comboBox1.getDocument().addDocumentListener(new DocumentListener() {
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//
//                changed();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//
//                changed();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//
//                changed();
//
//            }
//
//            public void changed(){
//
//                if(dealerNameTF.getText().equals("")) {
//                    search.setEnabled(false);
//                    locationCB.setEnabled(true);
//                    zipcodeCB.setEnabled(true);
//                }
//                else {
//                    locationCB.setEnabled(false);
//                    zipcodeCB.setEnabled(false);
//                    search.setEnabled(true);
//
//                }
//            }
        //});

     ButtonListener buttonClicked = new ButtonListener();
        searchButton.addActionListener(buttonClicked);
    }

    class ComboBoxListener implements ItemListener {

        @Override

        public void itemStateChanged(ItemEvent e) {
            boolean flag=false;
            if(comboBox3.getSelectedItem() == null) {

                comboBox1.setEnabled(true);
                comboBox2.setEnabled(true);
            }
            else {
                comboBox1.setEnabled(false);
                comboBox2.setEnabled(false);
               // search.setEnabled(true);
                flag=true;

            }

            if(flag==false) {
                if (comboBox2.getSelectedItem() == null) {
                    //search.setEnabled(false);

                    comboBox1.setEnabled(true);
                    comboBox3.setEnabled(true);
                } else {
                    comboBox1.setEnabled(false);
                    comboBox3.setEnabled(false);
                    //search.setEnabled(true);
                }
            }

        }
    }


    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Dealer> dealers = new ArrayList<>();

            if (comboBox3.getSelectedItem() != null) {

                String location = (String) comboBox3.getSelectedItem();
                dealers = dealerService.getDealerByLocation(location, 0);

                //new project.ListOfDealersUI(dealers);

            } else if (comboBox2.getSelectedItem() != null) {

                String zipcode = (String) comboBox2.getSelectedItem();
                dealers = dealerService.getDealerByZipcode(zipcode, 0);

                //new project.ListOfDealersUI(dealers);

            } else {

                String dealerName = (String) comboBox1.getSelectedItem();
                ;
                dealers = dealerService.getDealerByName(dealerName);
//                if(dealers.size()==0) {
//                    noDealerID.setVisible(true);
//                }

                //new project.ListOfDealersUI(dealers);

            }


        }
        }
}
