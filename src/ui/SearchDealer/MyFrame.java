package ui.SearchDealer;

import dto.Dealer;
import service.DealerService;
import service.DealerServiceImple;
import ui.DealerSearchUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class MyFrame extends JFrame implements MouseListener, MouseMotionListener {
    JFrame frame;
    Container container;
    int x;
    int y;
    int tempX;
    int tempY;
    int winX;
    int winY;
    int oldX;
    int oldY;
    JPanel panel;
    MyComboBox comboBox1,comboBox2,comboBox3;
    SearchButton searchButton;
    ResetButton resetButton;
    PageButton pageUp,pageDown;
    DealerService dealerService;
    MyPanel panel1,panel2,panel3;
    JPanel searchPanel;
    MyLabel label11,label12,label21,label22,label31,label32;
    ResultPanel resultPanel;

    JLabel label;

    public MyFrame() throws IOException {
        dealerService = new DealerServiceImple();
        init();

    }

    public void init() throws IOException {


        setLayoutAddComponents();
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);

        addListener();

    }

    private void setLayoutAddComponents(){
    frame = this;
    container = frame.getContentPane();
    frame.setBounds(300, 300, 1100, 750);
    container.setBackground(new Color(0, 0, 0));
    container.setLayout(null);
    MyPanel panel = new MyPanel();
    resultPanel=new ResultPanel(frame);
    resetButton=new ResetButton("<");
    resetButton.setBounds(30,30,60,60);
pageUp=new PageButton("<");
        pageUp.setBounds(620,500,30,30);
        pageDown=new PageButton(" >");
        pageDown.setBounds(670,500,30,30);
    BackgroundPanel backgroundPanel = new BackgroundPanel(frame);
    ControlPanel a = new ControlPanel(frame);

    a.add(new MinimizeButton("-", frame));
    a.add(new MaximizeButton("+", frame));
    a.add(new CloseButton("×", frame));

    int width = (int) (frame.getWidth() * 0.7);
    int height = (int) (frame.getHeight() * 0.7);

//    JLabel jLabel = null;
//    try {
//        ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File("src/Road.jpg")));
//        Image image = imageIcon.getImage();
//        image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
//        jLabel = new JLabel(imageIcon);
//        imageIcon.setImage(image);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }

//        ArrayList<Dealer> dealers = dealerService.getDealerByZipcode("98109", 0);
//        resultPanel=new ResultPanel(frame,dealers);


   label = new JLabel("HELLO");
        label.setFont(new Font("Sensa Sans", Font.PLAIN, 70));
        label.setBounds(200, 200, 300, 100);
        label.setForeground(Color.WHITE);





//   SearchButton button = new SearchButton();
//       button.setBounds(950, 600, 50, 50);
//       container.add(button);


        //

        setSearchPanel();

        container.add(pageUp);
        container.add(pageDown);
        pageUp.setVisible(false);
        pageDown.setVisible(false);
        container.add(resetButton);
        container.add(label);
        //container.add(backgroundPanel);
        container.add(a);
        container.add(searchPanel);
        container.add(resultPanel);



}


    public void setSearchPanel(){
        searchPanel=new MyPanel();
        searchButton=new SearchButton();
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

//        MyPanel panel0=new MyPanel();
//        //panel0.setBounds(0,0,200,250);
//        panel0.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

   panel1=new MyPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
       panel2=new MyPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
      panel3=new MyPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT,50,10));



        label11=new  MyLabel("NO.01                            ");
        label11.setFont(new Font("Bauhaus 93",Font.PLAIN,12));
       label12=new  MyLabel("Dealer Name          ");
        label12.setFont(new Font("Calibri",Font.BOLD,15));
        comboBox1=new MyComboBox();


        label21=new MyLabel("NO.02                            ");
        label21.setFont(new Font("Bauhaus 93",Font.PLAIN,12));
        label22=new  MyLabel("Zipcode                 ");
        label22.setFont(new Font("Calibri",Font.BOLD,15));
        comboBox2=new MyComboBox();


       label31=new  MyLabel("NO.03                            ");
        label31.setFont(new Font("Bauhaus 93",Font.PLAIN,12));
       label32=new  MyLabel("Location               ");
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

        searchPanel.add(panel1);
        searchPanel.add(panel2);
        searchPanel.add(panel3);
        searchPanel.add(searchButton);

        searchPanel.setBounds(300,590,800,250);

    }


    private void addItemToCombobox(MyComboBox myComboBox,String attribute){
        myComboBox.addItem(null);
        ArrayList<String> res=dealerService.getAttributeList(attribute);
        for(String a:res)
            myComboBox.addItem(a);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(oldY<50) {
            Point point = e.getPoint();
            Rectangle rec = frame.getBounds();

            winX = (int) rec.getX();
            winY = (int) rec.getY();
            x = (int) point.getX();
            y = (int) point.getY();
            tempX = x - oldX;
            tempY = y - oldY;

            frame.setLocation((int) (winX + tempX), (int) (winY + tempY));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Rectangle rec = frame.getBounds();
        Point point = e.getPoint();
        tempX = (int)point.getX();
        tempY = (int)point.getY();
        oldX = (int)point.getX();
        oldY = (int)point.getY();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
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
        resetListener resetListener=new resetListener();
        resetButton.addActionListener(resetListener);

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


    class resetListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!label.isVisible()){
                container.remove(resultPanel);
                resultPanel=new ResultPanel(frame);

                container.add(resultPanel);
                label.setVisible(true);
                pageUp.setVisible(false);
                pageDown.setVisible(false);
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


            if(resultPanel!=null)
            container.remove(resultPanel);


            //panel.add(new BackgroundPanel(frame));

            resultPanel=new ResultPanel(frame,dealers);

            container.add(resultPanel);
            label.setVisible(false);
            pageUp.setVisible(true);
            pageDown.setVisible(true);

            //setLayoutAddComponents();

        }
    }


}

