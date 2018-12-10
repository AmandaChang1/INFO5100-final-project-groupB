package ui;


import dto.Discount;
import dto.Special;
import dto.VehicleCriterion;
import ui.Calendar.DateChooser;
import ui.selfDefinedUI.MyTextArea;
import ui.selfDefinedUI.MyTextField;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SpecialManagerEdit extends JFrame implements VCEventListener {
    private  Special special;
    private VehicleCriterion vehicleCriterion;
    private boolean isAddSpecial, isCopy;

    private JScrollPane scrollPane, scrollPane1, scrollPane2;
    private Label l_startDate, l_endDate, l_title, l_description, l_discountType, l_D_description, l_D_criterion, l_discountInfo;
    private JFormattedTextField jftf_startDate, jftf_endDate;
    private JButton jb_save, jb_clear, jb_cancel, jb_edit;
    private JRadioButton jrb_cashBack, jrb_percentageOff;
    private JSlider js_discountOff;
    private MyTextField jtf_title;
    private MyTextArea jta_description,jta_descriptionDisplay, jta_criterionDisplay;
    private ButtonGroup btg_discountType;
    //For text font
    private Font font1 = new Font("TimesRoman", Font.BOLD,20);
    //For button font
    private Font font2 = new Font("TimesRoman", Font.PLAIN,18);


    //For null layout
    public final int labelLength = 140;
    public final int singleLineHeight = 30;
    public final int gapHeight = 20;
    public final int gapWidth = 10;
    public final int dateFieldLength =100;
    public final int buttonWidth = 75;

    SPEditEventListener listener;

    public static void main(String[] args) {
        SpecialManagerEdit specialManagerEdit = new SpecialManagerEdit(null,false);

    }
    //initialize
    public void addListener(SPEditEventListener listener) {
        this.listener = listener;
    }

    public SpecialManagerEdit(Special special, boolean isCopy){
        this.special = special;
        this.isCopy = isCopy;

        this.isAddSpecial = isCopy || (this.special == null);
        if (this.special == null)
            this.special = new Special();

        if (isCopy)
            this.special = new Special(special);

        createComponents();
        setLayouts();
        addComponents();
        addBehaviors();
        if (special != null)
            initiateTextfields();
        display();
    }

    private void initiateTextfields() {
        jftf_startDate.setText(special.getStartDate());
        jftf_endDate.setText(special.getEndDate());
        jtf_title.setText(special.getTitle());
        jta_description.setText(special.getDescription());

        if (special.getDiscount().getCashBack()){
            jrb_cashBack.setSelected(true);
            System.out.println((int)special.getDiscount().getValue());
            js_discountOff.setMaximum(5000);
            js_discountOff.setMinimum(0);
            js_discountOff.setMinorTickSpacing(100);
            js_discountOff.setMajorTickSpacing(1000);
            js_discountOff.setSnapToTicks(true);
            js_discountOff.setPaintTrack(true);
            js_discountOff.setPaintLabels(false);
            js_discountOff.setValue((int)special.getDiscount().getValue());
        }
        if (!special.getDiscount().getCashBack()){
            jrb_percentageOff.setSelected(true);
            float discount = special.getDiscount().getValue()*100;
            js_discountOff.setValue((int)discount);
        }
        if (!jta_description.getText().equals(""))
            jta_descriptionDisplay.setText(special.getDescription());
        vehicleCriterion = special.getCriterion();
        jta_criterionDisplay.setText(special.getCriterionString());
    }

    private void setSliderFormat(JSlider jSlider,int max, int min, int minTrack, int majorTrack, boolean isSnaped, boolean ispaintTrack, boolean ispaintLabel){
        jSlider.setMaximum(max);
        jSlider.setMinimum(min);
        jSlider.setMinorTickSpacing(minTrack);
        jSlider.setMajorTickSpacing(majorTrack);
        jSlider.setSnapToTicks(isSnaped);
        jSlider.setPaintTrack(ispaintTrack);
        jSlider.setPaintLabels(ispaintLabel);
    }

    class DiscountTypeSelectListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            if (jrb_cashBack.isSelected()){
                l_discountInfo.setText("CB: $ " + js_discountOff.getValue() + " OFF");
                setSliderFormat(js_discountOff,5000,0,100,1000,true,true,false);
            }else {
                l_discountInfo.setText("PF: " + js_discountOff.getValue() + "% OFF");
                setSliderFormat(js_discountOff,100,0,5,20,false,true,true);
            }
        }
    }

    class sliderListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            if (jrb_cashBack.isSelected()){
                l_discountInfo.setText("CB: $ " + js_discountOff.getValue() + " OFF");
            }
            if (jrb_percentageOff.isSelected())
                l_discountInfo.setText("PF: " + js_discountOff.getValue() + "% OFF");
        }
    }

    private void dateChooseCheck(JFormattedTextField startDate, JFormattedTextField endDate, JFormattedTextField choosenField){
        DateChooser dateChooser_start=new DateChooser(choosenField);
        Point p = choosenField.getLocationOnScreen();
        p.y = p.y + 30;
        dateChooser_start.showDateChooser(p);
        System.out.println(startDate.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = startDate.getText();
        String endDateString = endDate.getText();
        try{
            Date startdate = null;
            Date enddate = null;
            if (!startDate.getText().equals("")){
                startdate = sdf.parse(startDateString);
            }
            if (!endDate.getText().equals("")){
                enddate = sdf.parse(endDateString);
            }
            if (startdate != null && enddate != null && startdate.after(enddate)){
                JOptionPane.showMessageDialog(null,"Start Date should before end date!", "Choose Error",JOptionPane.ERROR_MESSAGE);
            }
//            if (startdate != null && enddate != null && enddate.before(startdate)){
//                JOptionPane.showMessageDialog(null,"End date should AFTER start Date!", "Choose Error",JOptionPane.ERROR_MESSAGE);
//            }
        } catch (ParseException e){

        }
    }

    private void addBehaviors() {
        jftf_startDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                dateChooseCheck(jftf_startDate,jftf_endDate,jftf_startDate);
            }
        });

        jftf_endDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                dateChooseCheck(jftf_startDate,jftf_endDate,jftf_endDate);
            }
        });

        jb_clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                jftf_startDate.setText("");
                jftf_endDate.setText("");
                jtf_title.setText("");
                jta_description.setText("");
                jrb_cashBack.setSelected(true);
                js_discountOff.setValue(0);
            }
        });

        jb_cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                dispose();
            }
        });


        DiscountTypeSelectListener dtsListener = new DiscountTypeSelectListener();
        jrb_cashBack.addChangeListener(dtsListener);
        jrb_percentageOff.addChangeListener(dtsListener);

        js_discountOff.addChangeListener(new sliderListener());

        //listener for change of Description text field
        jta_description.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jta_descriptionDisplay.setText(jta_description.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jta_descriptionDisplay.setText(jta_description.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jta_descriptionDisplay.setText(jta_description.getText());
            }
        });

        SpecialManagerEdit frame = this;
        //Add edit button listen to link to critrion UI
        jb_edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

                VehicleCriterionUI  vehicleCriterionUI = null;

                if (special.getCriterion() == null)
                    vehicleCriterionUI = new VehicleCriterionUI();
                else
                    vehicleCriterionUI = new VehicleCriterionUI(special.getCriterion());

                vehicleCriterionUI.addListener(frame);
            }
        });

        //Add save button listen to link the Special main UI
        jb_save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // add close event
                if (jftf_startDate.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Start date shouldn't be null", "Save Error",JOptionPane.INFORMATION_MESSAGE);
                else if (jftf_endDate.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"End date shouldn't be null", "Save Error",JOptionPane.INFORMATION_MESSAGE);
                else if (jtf_title.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Title shouldn't be null", "Save Error",JOptionPane.INFORMATION_MESSAGE);
                else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String startDateString = jftf_startDate.getText();
                    String endDateString = jftf_endDate.getText();
                    Date startDate = null;
                    Date endDate = null;
                    try {
                        startDate = sdf.parse(startDateString);
                        endDate = sdf.parse(endDateString);
                    } catch (ParseException ep) {
                        ep.printStackTrace();
                    }
                    if (!startDate.before(endDate))
                        JOptionPane.showMessageDialog(null, "Start Date should before end date!", "Choose Error", JOptionPane.ERROR_MESSAGE);
                    else {
                        updateSpecial();
                        listener.closeUpdateSpecial(special, isAddSpecial);
                        dispose();
                    }
                }
            }
        });

    }


    public void closeUpdateVC(VehicleCriterion vc) {
        this.vehicleCriterion = vc;
        special.setCriterion(vc);
        jta_criterionDisplay.setText(vc.getCriterionString());
    }

    private void display() {
        setSize(630,680);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private void addComponents() {
        Container container = getContentPane();
        int x_startPoint = 40;
        int y_startPoint = 40;

        //Add components and set those position
        container.add(l_startDate);
        l_startDate.setBounds(x_startPoint,y_startPoint,labelLength,singleLineHeight);
        container.add(l_title);
        l_title.setBounds(x_startPoint,l_startDate.getY()+ gapHeight + l_startDate.getHeight(),labelLength,singleLineHeight);
        container.add(l_description);
        l_description.setBounds(x_startPoint,l_title.getY() + gapHeight + l_title.getHeight(),labelLength,singleLineHeight);

        container.add(jftf_startDate);
        jftf_startDate.setSize(dateFieldLength,singleLineHeight);
        jftf_startDate.setEditable(false);
        jftf_startDate.setBounds(l_startDate.getX() + l_startDate.getWidth() + gapWidth,y_startPoint -3,dateFieldLength,singleLineHeight);

        container.add(l_discountType);
        l_discountType.setBounds(x_startPoint,l_description.getY() + gapHeight + singleLineHeight*4, labelLength, singleLineHeight);

        btg_discountType = new ButtonGroup();
        btg_discountType.add(jrb_cashBack);
        btg_discountType.add(jrb_percentageOff);

        container.add(l_endDate);
        l_endDate.setBounds(jftf_startDate.getX() + 50 + jftf_startDate.getWidth(), jftf_startDate.getY(), labelLength, singleLineHeight);

        container.add(jftf_endDate);
        jftf_endDate.setEditable(false);
        jftf_endDate.setBounds(l_endDate.getX() + l_endDate.getWidth() + gapWidth, l_endDate.getY() -3, jftf_startDate.getWidth(), singleLineHeight);

        container.add(jtf_title);
        jtf_title.setBounds(l_title.getX() + l_title.getWidth() + gapWidth, l_title.getY() -3, jftf_endDate.getX() -
                jftf_startDate.getX() + jftf_endDate.getWidth(), singleLineHeight);

        scrollPane = new JScrollPane(jta_description);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(jta_description);
//        jta_description.setBackground(getContentPane().getBackground());
//        scrollPane.getViewport().setBackground(getContentPane().getBackground());
        scrollPane.setBounds(l_description.getX() + l_description.getWidth() + gapWidth, l_description.getY(), jtf_title.getWidth(), l_discountType.getY() - l_description.getY()- gapHeight);
        jta_description.setLineWrap(true);
        container.add(scrollPane);

        container.add(jrb_cashBack);
        jrb_cashBack.setBounds(l_description.getX() + l_description.getWidth() + gapWidth, l_discountType.getY(), labelLength, singleLineHeight);

        container.add(jrb_percentageOff);
        jrb_percentageOff.setBounds(jrb_cashBack.getX() + gapWidth + jrb_cashBack.getWidth(),jrb_cashBack.getY(),labelLength, singleLineHeight);

        js_discountOff.setBounds(l_discountType.getX() + l_discountType.getWidth() + gapWidth,l_discountType.getY() + singleLineHeight +gapHeight, jtf_title.getWidth(),singleLineHeight+5);
        container.add(js_discountOff);

//        js_cashBack.setBounds(l_discountType.getX() + l_discountType.getWidth() + gapWidth,l_discountType.getY() + singleLineHeight +gapHeight, jtf_title.getWidth(),singleLineHeight+5);
//        container.add(js_cashBack);

        container.add(jb_save);
        jb_save.setBounds(js_discountOff.getX(), js_discountOff.getY() + js_discountOff.getHeight() + gapHeight,buttonWidth,singleLineHeight);

        container.add(jb_clear);
        jb_clear.setBounds(jtf_title.getWidth() /3 + jb_save.getX() + buttonWidth/2, jb_save.getY(), buttonWidth,singleLineHeight);

        container.add(jb_cancel);
        jb_cancel.setBounds(jtf_title.getWidth() + jtf_title.getX() - buttonWidth,jb_save.getY(),buttonWidth,singleLineHeight);

        container.add(l_discountInfo);
        l_discountInfo.setBounds(l_discountType.getX()+10, js_discountOff.getY(),l_discountType.getWidth(),singleLineHeight);

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(1,2);
        gridLayout.setHgap(gapWidth*2);
        panel.setLayout(gridLayout);

        panel.setBorder(BorderFactory.createTitledBorder("Detail Information"));
        panel.setPreferredSize(new Dimension(jb_cancel.getX()- l_startDate.getX() + jb_cancel.getWidth(),scrollPane.getHeight()*2 -30));
        panel.setMaximumSize(new Dimension(jb_cancel.getX()- l_startDate.getX() + jb_cancel.getWidth(),scrollPane.getHeight()*2 -30));
        panel.setMinimumSize(new Dimension(jb_cancel.getX()- l_startDate.getX() + jb_cancel.getWidth(),scrollPane.getHeight()*2 -30));
        panel.setBounds(l_startDate.getX(),jb_save.getY()+ gapHeight * 2,jb_cancel.getX()- l_startDate.getX() + jb_cancel.getWidth(),scrollPane.getHeight()*2 -30);

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BorderLayout());
        panelLeft.setSize(panel.getWidth()/2,panel.getHeight());
        panelLeft.add("North",l_D_description);
        scrollPane1 = new JScrollPane(jta_descriptionDisplay);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setViewportView(jta_descriptionDisplay);
        jta_descriptionDisplay.setBackground(getContentPane().getBackground());
        scrollPane1.getViewport().setBackground(getContentPane().getBackground());
        scrollPane1.setBorder(BorderFactory.createLineBorder(getContentPane().getBackground()));
        panelLeft.add("Center",scrollPane1);
        jta_descriptionDisplay.setOpaque(false);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BorderLayout());
        panelRight.setSize(panel.getWidth()/2,panel.getHeight());
        JPanel panelLeftUp = new JPanel();
        panelLeftUp.setLayout(new GridLayout(1,2));
        panelLeftUp.add(l_D_criterion);
        panelLeftUp.add(jb_edit);
        panelRight.add("North",panelLeftUp);
        scrollPane2 = new JScrollPane(jta_criterionDisplay);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jta_criterionDisplay.setBackground(getContentPane().getBackground());
        scrollPane2.getViewport().setBackground(getContentPane().getBackground());
        scrollPane2.setBorder(BorderFactory.createLineBorder(getContentPane().getBackground()));
        panelRight.add("Center",scrollPane2);
        jta_criterionDisplay.setOpaque(false);

        panel.add(panelLeft);
        panel.add(panelRight);

        container.add(panel);
    }

    private void setLayouts() {
        Container container = getContentPane();
        container.setLayout(null);
        container.setBounds(100,100,250,150);
    }

    private void createComponents() {
        l_startDate = new Label("Start Date: ");
        l_startDate.setFont(font1);
        l_endDate = new Label("End Date: ");
        l_endDate.setFont(font1);
        l_title = new Label("Title: ");
        l_title.setFont(font1);
        l_description = new Label("Description: ");
        l_description.setFont(font1);
        l_discountType = new Label("Discount Type: ");
        l_discountType.setFont(font1);
        l_D_description = new Label("Description: ");
        l_D_description.setFont(font1);
        l_D_criterion = new Label("Criterion: ");
        l_D_criterion.setFont(font1);
        l_discountInfo = new Label("CB: $ 10K OFF");
        l_discountInfo.setFont(font2);


        jftf_startDate = new JFormattedTextField();
        jftf_endDate = new JFormattedTextField();

        jb_save = new JButton("Save");
        jb_save.setFont(font2);
        jb_cancel = new JButton("Cancel");
        jb_cancel.setFont(font2);
        jb_clear = new JButton("Clear");
        jb_clear.setFont(font2);
        jb_edit = new JButton("Edit");
        jb_edit.setFont(font2);

        jrb_cashBack = new JRadioButton("Cash back",true);
        jrb_percentageOff = new JRadioButton("Percentage Off", false);

        js_discountOff = new JSlider(JSlider.HORIZONTAL,0,100,10);
        js_discountOff.setMinorTickSpacing(2);
        js_discountOff.setMajorTickSpacing(20);
        js_discountOff.setPaintTicks(true);
        js_discountOff.setPaintLabels(true);

        jtf_title = new MyTextField();

        jta_description = new MyTextArea();
        jta_descriptionDisplay = new MyTextArea("");
        jta_descriptionDisplay.setEditable(false);
        jta_descriptionDisplay.setLineWrap(true);

        jta_criterionDisplay = new MyTextArea();
        jta_criterionDisplay.setEditable(false);
        jta_criterionDisplay = new MyTextArea("");
        jta_descriptionDisplay.setLineWrap(true);
    }

    private void updateSpecial() {

        Discount discount = new Discount();
        if (jrb_cashBack.isSelected()) {
            discount.setCashBack(true);
            discount.setValue((int) js_discountOff.getValue());
        }
        else{
            discount.setCashBack(false);
            discount.setValue((float) js_discountOff.getValue()/100);
        }


        if (special.getId() == null) {
            Random ran = new Random();
            special.setId(""+ Math.abs(ran.nextInt()));
        }


        special.setDescription(jta_description.getText());
        special.setDiscount(discount);
        special.setTitle(jtf_title.getText());
        special.setStartDate(jftf_startDate.getText());
        special.setEndDate(jftf_endDate.getText());
        special.setCriterion(vehicleCriterion);
    }
}
