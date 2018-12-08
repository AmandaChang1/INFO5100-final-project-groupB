package ui.SearchDealer;

import dto.Dealer;
import dto.SearchResult;
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
    int curpage=1;
    int totalpage;
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


    JLabel label,result;

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
    resetButton.setBounds(30,42,60,60);
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

   label = new JLabel("HELLO");
        label.setFont(new Font("Sensa Sans", Font.PLAIN, 70));
        label.setBounds(200, 200, 300, 100);
        label.setForeground(Color.WHITE);

        result=new JLabel("Search Result");
        result.setFont(new Font("Nanum Brush Script", Font.BOLD,  90));
        result.setBounds(280,90,500,100);
        result.setForeground(Color.WHITE);




//   SearchButton button = new SearchButton();
//       button.setBounds(950, 600, 50, 50);
//       container.add(button);


        //

        setSearchPanel();

        container.add(pageUp);
        container.add(pageDown);
        container.add(result);
        result.setVisible(false);
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
        comboBox1.addItemListener(cbl);

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
        PageUpListener pageUpListener=new PageUpListener();
        PageDownListener pageDownListener=new PageDownListener();
        pageUp.addActionListener(pageUpListener);
        pageDown.addActionListener(pageDownListener);

    }

    class ComboBoxListener implements ItemListener {

        @Override

        public void itemStateChanged(ItemEvent e) {
            boolean flag=false;
            if(comboBox1.getSelectedItem()==null&&comboBox2.getSelectedItem()==null&&comboBox3.getSelectedItem()==null){
                comboBox1.setEnabled(true);
                comboBox2.setEnabled(true);
                comboBox3.setEnabled(true);

            }
            else if(comboBox1.getSelectedItem()!=null){
                comboBox2.setEnabled(false);
                comboBox3.setEnabled(false);
            }
            else if(comboBox2.getSelectedItem()!=null){
                comboBox1.setEnabled(false);
                comboBox3.setEnabled(false);
            }
            else {
                comboBox1.setEnabled(false);
                comboBox2.setEnabled(false);
            }
//

        }
    }


    class resetListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!label.isVisible()){
                container.remove(resultPanel);
                resultPanel=new ResultPanel(frame);

                container.add(resultPanel);
                resultPanel.updateUI();
                label.setVisible(true);
                pageUp.setVisible(false);
                pageDown.setVisible(false);
                result.setVisible(false);

            }

        }

    }

    class PageUpListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            SearchResult<Dealer> searchResult = new SearchResult<>();
            ArrayList<Dealer> dealers=new ArrayList<>();

            if (comboBox3.getSelectedItem() != null) {


                String location = (String) comboBox3.getSelectedItem();
                searchResult = dealerService.getDealerByLocation(location, curpage-1);
                dealers=searchResult.getResultSet();
                curpage--;
                if(!pageDown.isEnabled())
                    pageDown.setEnabled(true);
                if(curpage==1)
                    pageUp.setEnabled(false);
                else
                    pageUp.setEnabled(true);

                //new project.ListOfDealersUI(dealers);

            }
            if(comboBox2.getSelectedItem() != null){
                String zipcode = (String) comboBox2.getSelectedItem();
                searchResult = dealerService.getDealerByZipcode(zipcode, curpage-1);
                dealers=searchResult.getResultSet();
                curpage--;
                if(!pageDown.isEnabled())
                    pageDown.setEnabled(true);
                if(curpage==1)
                    pageUp.setEnabled(false);
                else
                    pageUp.setEnabled(true);
            }


                container.remove(resultPanel);


            //panel.add(new BackgroundPanel(frame));

            resultPanel=new ResultPanel(frame,dealers);

            container.add(resultPanel);
            label.setVisible(false);
            pageUp.setVisible(true);
            pageDown.setVisible(true);
            resultPanel.updateUI();

            //setLayoutAddComponents();

        }

    }

    private
    class PageDownListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            SearchResult<Dealer> searchResult;
            ArrayList<Dealer> dealers=new ArrayList<>();

            if (comboBox3.getSelectedItem() != null) {


                String location = (String) comboBox3.getSelectedItem();

                searchResult = dealerService.getDealerByLocation(location, curpage+1);
                dealers=searchResult.getResultSet();
                curpage++;
                if(!pageUp.isEnabled())
                    pageUp.setEnabled(true);
                if(curpage==totalpage)
                    pageDown.setEnabled(false);
                else
                    pageDown.setEnabled(true);

                //new project.ListOfDealersUI(dealers);

            }
            if (comboBox2.getSelectedItem() != null) {


                String zipcode = (String) comboBox2.getSelectedItem();

                searchResult = dealerService.getDealerByZipcode(zipcode, curpage+1);
                dealers=searchResult.getResultSet();
                curpage++;
                if(!pageUp.isEnabled())
                    pageUp.setEnabled(true);
                if(curpage==totalpage)
                    pageDown.setEnabled(false);
                else
                    pageDown.setEnabled(true);

                //new project.ListOfDealersUI(dealers);

            }


            container.remove(resultPanel);


            //panel.add(new BackgroundPanel(frame));

            resultPanel=new ResultPanel(frame,dealers);

            container.add(resultPanel);
            label.setVisible(false);
            pageUp.setVisible(true);
            pageDown.setVisible(true);
            resultPanel.updateUI();

            //setLayoutAddComponents();

        }
    }
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            curpage=1;
            SearchResult<Dealer> searchResult = new SearchResult<>();
            ArrayList<Dealer> dealers=new ArrayList<>();

            if (comboBox3.getSelectedItem() != null) {

                String location = (String) comboBox3.getSelectedItem();
                searchResult = dealerService.getDealerByLocation(location, 1);
                dealers=searchResult.getResultSet();
                totalpage=searchResult.getPage();
                pageUp.setEnabled(false);
                pageDown.setEnabled(true);

                //new project.ListOfDealersUI(dealers);

            } else if (comboBox2.getSelectedItem() != null) {

                String zipcode = (String) comboBox2.getSelectedItem();
                searchResult = dealerService.getDealerByZipcode(zipcode, 1);
                dealers=searchResult.getResultSet();
                totalpage=searchResult.getPage();
                pageUp.setEnabled(false);
                pageDown.setEnabled(true);


                //new project.ListOfDealersUI(dealers);

            } else {

                String dealerName = (String) comboBox1.getSelectedItem();
                ;
                dealers = dealerService.getDealerByName(dealerName);
                pageDown.setEnabled(false);
                pageUp.setEnabled(false);
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
            if(curpage==totalpage)
                pageDown.setEnabled(false);
            label.setVisible(false);
            pageUp.setVisible(true);
            pageDown.setVisible(true);
            result.setVisible(true);

            //setLayoutAddComponents();

        }
    }


}

