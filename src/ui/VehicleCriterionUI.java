package ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.jidesoft.swing.RangeSlider;
import dto.VehicleCriterion;


public class VehicleCriterionUI extends JFrame{
    private JButton regression;
    private JButton clear;
    private JLabel label_model, label_maker, label_price, label_category, label_type, label_year;
    private JComboBox comboBox_maker;
    private JLabel label_othermaker, label_othermodel;
    private JTextField field_othermaker, field_othermodel;
    private JComboBox comboBox_model;
    private Map<String, ArrayList> map;
    private JTextField field_sp, field_ep;
    private JRadioButton category_new, category_used, category_all;
    private ButtonGroup bg;
    private JCheckBox type_car, type_suv, type_truck, type_cargovan;
    private JLabel info_sy, info_ey;
    private RangeSlider slider_year;
    private JButton btn_submit;
    private Font font1, font2, font3;

    VehicleCriterion criterion;
    VCEventListener listener;

    public void addListener(VCEventListener source) {
        listener = source;
    }
    
    public VehicleCriterion getVehicleCriterion() {
    	return criterion;
    }

    public VehicleCriterionUI() {
        setMap();
    	criterion = new VehicleCriterion();
        this.setTitle("Vehicle Criterion");
        setFont();
        componentClear();
        componentMaker();
        componentModel();
        componentPrice();
        componentCategory();
        componentType();
        componentYear();
        componentSubmit();
        setLayout();
        addBehaviors();
        display();
    }

    public VehicleCriterionUI(VehicleCriterion vc) {

        setMap();
        criterion = new VehicleCriterion();
        this.setTitle("Vehicle Criterion");
        setFont();
        componentClear();
        componentMaker();
        componentModel();
        componentPrice();
        componentCategory();
        componentType();
        componentYear();
        componentSubmit();
        setLayout();
        paint(vc);
        addBehaviors();
        display();
    }

    public void paint(VehicleCriterion vc) {
        // field_ID.setText(vc.getVehicleID());
        if (map.containsKey(vc.getMaker())) {
            comboBox_maker.setSelectedItem(vc.getMaker());
            ArrayList<String> list = map.get(vc.getMaker());
            comboBox_model.removeAllItems();
            for (String s : list) {
                comboBox_model.addItem(s);
            }
            field_othermaker.setBackground(Color.lightGray);
        } else {
            comboBox_maker.setSelectedItem("Other");
            field_othermaker.setEditable(true);
            field_othermaker.setText(vc.getMaker());
            ArrayList<String> list = map.get("Other");
            comboBox_model.removeAllItems();
            for (String s : list) {
                comboBox_model.addItem(s);
            }
        }
        if( !map.containsKey(vc.getMaker()) || !map.get(vc.getMaker()).contains(vc.getModel()) ) {
            comboBox_model.setSelectedItem("Other");
            //           comboBox_model.setSelectedItem((String)map.get("Other").get(1));
//            System.out.println(map.get("Other").get(0));
//            System.out.println(map.get("Other").get(1));
            field_othermodel.setEditable(true);
            field_othermodel.setText(vc.getModel());
            field_othermodel.setBackground(Color.lightGray);
        } else {
            comboBox_model.setSelectedItem(vc.getModel());
        }
        field_sp.setText(String.valueOf(vc.getMinPrice()));
        field_ep.setText(String.valueOf(vc.getMaxPrice()));
        if( vc.getCategory() == null || vc.getCategory().size() == 0 || (vc.getCategory().contains("new") && vc.getCategory().contains("used")) ) {
            category_all.setSelected(true);
            category_all.setIcon(new ImageIcon("resources/icons/right.png"));
        }else if(vc.getCategory().contains("new")) {
            category_new.setSelected(true);
            category_new.setIcon(new ImageIcon("resources/icons/right.png"));
        }
        else if(vc.getCategory().contains("used")) {
            category_used.setSelected(true);
            category_used.setIcon(new ImageIcon("resources/icons/right.png"));
        }
        if(vc.getType().contains("SUV")) {
            type_suv.setSelected(true);
            type_suv.setIcon(new ImageIcon("resources/icons/right.png"));
        }
        if(vc.getType().contains("CAR")) {
            type_car.setSelected(true);
            type_car.setIcon(new ImageIcon("resources/icons/right.png"));
        }
        if(vc.getType().contains("TRUCK")) {
            type_truck.setSelected(true);
            type_truck.setIcon(new ImageIcon("resources/icons/right.png"));
        }
        if(vc.getType().contains("CARGO VAN")){
            type_cargovan.setSelected(true);
            type_cargovan.setIcon(new ImageIcon("resources/icons/right.png"));
        }
        slider_year.setLowValue(Integer.parseInt(vc.getStartYear()));
        slider_year.setHighValue(Integer.parseInt(vc.getEndYear()));
        info_sy.setText("Start Year: " + Integer.parseInt(vc.getStartYear()));
        info_ey.setText("End Year: " + Integer.parseInt(vc.getEndYear()));
    }

//    class RegressionListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            criterion.reset();
//            paint(e.getSource().getValue(vc));
//        }
//    }

    class SubmitListener implements ActionListener {
    	@Override
		public void actionPerformed(ActionEvent e) {
    	    criterion.reset();
    		if((String)comboBox_maker.getSelectedItem() != "Other")
			    criterion.setMaker((String)comboBox_maker.getSelectedItem());
    		else
                criterion.setMaker(field_othermaker.getText());
    		if((String)comboBox_maker.getSelectedItem() == "All") {
    		    criterion.setModel("All");
            } else if((String)comboBox_model.getSelectedItem() != "Other") {
                criterion.setModel((String)comboBox_model.getSelectedItem());
            } else {
                criterion.setModel(field_othermodel.getText());
            }
			if(field_sp.getText() != null && field_sp.getText().length() > 0)
			    criterion.setMinPrice(Float.parseFloat(field_sp.getText()));
			else
                criterion.setMinPrice((float)0.0);
            if(field_ep.getText() != null && field_ep.getText().length() > 0)
			    criterion.setMaxPrice(Float.parseFloat(field_ep.getText()));
            else
                criterion.setMaxPrice((float)Double.MAX_VALUE);
            if(category_all.isSelected()) {
                criterion.addCategory("new");
                criterion.addCategory("used");
            }else if(category_new.isSelected()) criterion.addCategory(category_new.getText());
			else if(category_used.isSelected()) criterion.addCategory(category_used.getText());
			else {
                criterion.addCategory("new");
                criterion.addCategory("used");
            }
			if(type_car.isSelected()) criterion.addType(type_car.getText());
			if(type_suv.isSelected()) criterion.addType(type_suv.getText());
			if(type_truck.isSelected()) criterion.addType(type_truck.getText());
			if(type_cargovan.isSelected()) criterion.addType(type_cargovan.getText());
			criterion.setStartYear(String.valueOf(slider_year.getLowValue()));
            criterion.setEndYear(String.valueOf(slider_year.getHighValue()));
			if (listener != null)
			    listener.closeUpdateVC(criterion);

            dispose();
		}
    }
    class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            comboBox_maker.setSelectedItem(null);
            comboBox_model.setSelectedItem(null);
			field_othermaker.setText("");
			field_othermaker.setEditable(false);
			field_othermaker.setBackground(Color.lightGray);
            field_othermodel.setText("");
            field_othermodel.setEditable(false);
            field_othermodel.setBackground(Color.lightGray);
			field_sp.setText("");
			field_ep.setText("");
            bg.clearSelection();
			type_car.setSelected(false);
			type_suv.setSelected(false);
			type_truck.setSelected(false);
			type_cargovan.setSelected(false);
			slider_year.setLowValue(1988);
            slider_year.setHighValue(2018);
		}	
	}

	class MakerListener  implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String key = (String)e.getItem();
            if(key == "Other") {
                field_othermaker.setEditable(true);
                field_othermodel.setEditable(true);
                field_othermaker.setBackground(Color.white);
                field_othermodel.setBackground(Color.white);
                comboBox_model.setSelectedItem("Other");
            } else if (key == "ALL") {
                comboBox_model.setSelectedItem("All");
                field_othermaker.setEditable(false);
                field_othermodel.setEditable(false);
                field_othermaker.setBackground(Color.lightGray);
                field_othermodel.setBackground(Color.lightGray);
            } else {
                field_othermaker.setText("");
                field_othermodel.setText("");
                field_othermaker.setEditable(false);
                field_othermodel.setEditable(false);
                field_othermaker.setBackground(Color.lightGray);
                field_othermodel.setBackground(Color.lightGray);
            }
            ArrayList<String> list = map.get(key);
            comboBox_model.removeAllItems();
            for (String s : list) {
                comboBox_model.addItem(s);
            }
        }
    }

    class ModelListener  implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String value = (String)e.getItem();
            if(value == "Other")  {
                field_othermodel.setEditable(true);
                field_othermodel.setBackground(Color.white);
            } else {
                field_othermodel.setText("");
                field_othermodel.setEditable(false);
                field_othermodel.setBackground(Color.lightGray);
            }
        }
    }

    class CategoryListener implements ItemListener
    {
       private String right = "resources/icons/right.png";

        public void itemStateChanged(ItemEvent e)
        {
            JRadioButton jrb = (JRadioButton) e.getItem();
            if (jrb.isSelected())
            {
                jrb.setIcon(new ImageIcon(right));
            } else
            {
                jrb.setIcon(null);
            }
        }
    }

    class TypeListener implements ItemListener
    {
        private String right = "resources/icons/right.png";

        public void itemStateChanged(ItemEvent e)
        {
            JCheckBox jcb = (JCheckBox) e.getItem();
            if (jcb.isSelected())
            {
                jcb.setIcon(new ImageIcon(right));
            } else
            {
                jcb.setIcon(null);
            }
        }
    }

    class YearListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

                info_sy.setText("Start Year: " + slider_year.getLowValue() );

                info_ey.setText("End Year: " + slider_year.getHighValue() );
        }
    }

    public void addBehaviors() {
    	ClearListener cl = new ClearListener();
		clear.addActionListener(cl);
		SubmitListener sl = new SubmitListener();
        btn_submit.addActionListener(sl);
        MakerListener makerl = new MakerListener();
        comboBox_maker.addItemListener(makerl);
        ModelListener modell = new ModelListener();
        comboBox_model.addItemListener(modell);
        CategoryListener categoryl = new CategoryListener();
        category_all.addItemListener(categoryl);
        category_new.addItemListener(categoryl);
        category_used.addItemListener(categoryl);
        TypeListener typel = new TypeListener();
        type_car.addItemListener(typel);
        type_suv.addItemListener(typel);
        type_truck.addItemListener(typel);
        type_cargovan.addItemListener(typel);

        YearListener yearl = new YearListener();
        slider_year.addChangeListener(yearl);

//        RegressionListener regressionl = new RegressionListener();
//        regression.addActionListener(regressionl);
    }

    public void setMap() {
        map = new HashMap<>();
//        ArrayList<String> list_null = new ArrayList<String>();
//        list_null.add("No model criterion");
//        map.put("No maker criterion", list_null);

        ArrayList<String> list_all = new ArrayList<String>();
        list_all.add("All");
        map.put("All", list_all);

        ArrayList<String> list_bmw = new ArrayList<String>();
        list_bmw.add("All");
        list_bmw.add("535i");
        list_bmw.add("Other");
        map.put("BMW", list_bmw);


        ArrayList<String> list_cadillac = new ArrayList<String>();
        list_cadillac.add("All");
        list_cadillac.add("CTS Sedan");
        list_cadillac.add("ATS Sedan");
        list_cadillac.add("XTS");
        list_cadillac.add("CT6 Sedan");
        list_cadillac.add("Escalade");
        list_cadillac.add("Other");
        map.put("Cadillac", list_cadillac);

        ArrayList<String> list_chevrolet = new ArrayList<String>();
        list_chevrolet.add("All");
        list_chevrolet.add("Camaro");
        list_chevrolet.add("Cruze");
        list_chevrolet.add("Malibu");
        list_chevrolet.add("Silverado");
        list_chevrolet.add("Sonic");
        list_chevrolet.add("Trax");
        list_chevrolet.add("Covette");
        list_chevrolet.add("City Express Cargo Van");
        list_chevrolet.add("Other");
        map.put("Chevrolet",list_chevrolet);

        ArrayList<String> list_other = new ArrayList<String>();
        list_other.add("All");
        list_other.add("Other");
        map.put("Other", list_other);
    }

    public void setFont() {
        font1 =  new Font("TimesRoman", Font.BOLD, 17);
        font2 =  new Font("TimesRoman", Font.PLAIN, 17);
        font3 =  new Font("TimesRoman", Font.PLAIN, 16);
    }

//    public void componentRegression() {
//        regression = new JButton("regression");
//        regression.setFont(font2);
//        regression.setBounds(430, 20, 100, 30);
//        this.add(regression);
//    }

    public void componentClear() {
        ImageIcon imageIcon1 = new ImageIcon("resources/icons/clear.jpg");
        Image image1 = imageIcon1.getImage();
        Image smallImage1 = image1.getScaledInstance(20, 20,Image.SCALE_FAST);
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);

        clear = new JButton("clear", smallIcon1);
        clear.setFont(font2);
        clear.setBounds(430, 20, 100, 30);
        this.add(clear);
    }

    public void componentMaker() {
        label_maker = new JLabel("Maker");
        label_maker.setFont(font1);
        label_maker.setBounds(20, 70 , 200, 30);
        this.add(label_maker);

        comboBox_maker =new JComboBox();
        for(String key : map.keySet()) {
            comboBox_maker.addItem(key);
        }
        comboBox_maker.setBounds(20, 100 , 200, 30);
        comboBox_maker.setSelectedItem(null);
        this.add(comboBox_maker);

        label_othermaker = new JLabel("Other");
        label_othermaker.setFont(font2);
        label_othermaker.setBounds(280, 100 , 200, 30);
        this.add(label_othermaker);

        field_othermaker = new JTextField();
        field_othermaker.setBounds(330, 100 , 200, 30);
        this.add(field_othermaker);
        field_othermaker.setEditable(false);
        field_othermaker.setBackground(Color.lightGray);

    }

    public void componentModel(){
        label_model = new JLabel("Model");
        label_model.setFont(font1);
        label_model.setBounds(20, 150 , 200, 30);
        this.add(label_model);

        comboBox_model = new JComboBox();
//        comboBox_model.addItem("All");
//        comboBox_model.setSelectedItem("All");

        comboBox_model.setBounds(20, 180, 200, 30);
        comboBox_model.setSelectedItem(null);
        this.add(comboBox_model);

        label_othermodel = new JLabel("Other");
        label_othermodel.setFont(font2);
        label_othermodel.setBounds(280, 180 , 200, 30);
        this.add(label_othermodel);

        field_othermodel = new JTextField();
        field_othermodel.setBounds(330, 180 , 200, 30);
        this.add(field_othermodel);
        field_othermodel.setEditable(false);
        field_othermodel.setBackground(Color.lightGray);
    }

    public void componentPrice() {
        label_price = new JLabel("Price");
        label_price.setFont(font1);
        label_price.setBounds(20, 230 , 200, 30);
        this.add(label_price);

        field_sp = new JTextField();
        field_sp.setBounds(20, 260, 200, 30);
        this.add(field_sp);

        field_sp.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

                }else{
                    e.consume();
                }
            }
        });

        field_ep = new JTextField();
        field_ep.setBounds(330, 260, 200, 30);
        this.add(field_ep);

        field_ep.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

                }else{
                    e.consume();
                }
            }
        });

    }

    public void componentCategory() {
        label_category = new JLabel("Category");
        label_category.setFont(font1);
        label_category.setBounds(20, 305 , 200, 30);
        this.add(label_category);

        category_new = new JRadioButton("new", false);
        category_new.setBounds(20, 330 ,200,70);
        category_new.setFont(font2);
        this.add(category_new);

        category_used = new JRadioButton("used",false);
        category_used.setBounds(250, 330 , 200, 70);
        category_used.setFont(font2);
        this.add(category_used);

        category_all = new JRadioButton("all",false);
        category_all.setBounds(480, 330 , 200, 70);
        category_all.setFont(font2);
        this.add(category_all);

        bg = new ButtonGroup();
        bg.add(category_all);
        bg.add(category_new);
        bg.add(category_used);

    }

    public void componentType() {

        label_type = new JLabel("Type");
        label_type.setFont(font1);
        label_type.setBounds(20, 390 , 200, 30);
        this.add(label_type);

//        ImageIcon imageIcon3 = new ImageIcon("resources/icons/SUV.png");
//        Image image3 = imageIcon3.getImage();
//        Image smallImage3 = image3.getScaledInstance(70, 40,Image.SCALE_FAST);
//        ImageIcon smallIcon3 = new ImageIcon(smallImage3);

        //type_suv = new JCheckBox("SUV", smallIcon3);
        type_suv = new JCheckBox("SUV");
        type_suv.setBounds(20, 415 , 200, 30);
        type_suv.setFont(font2);
        this.add(type_suv);

        type_car = new JCheckBox("CAR");
        type_car.setBounds(380, 415 , 200, 30);
        type_car.setFont(font2);
        this.add(type_car);

        type_truck = new JCheckBox("TRUCK");
        type_truck.setBounds(20, 440 , 200, 30);
        type_truck.setFont(font2);
        this.add(type_truck);

        type_cargovan = new JCheckBox("CARGO VAN");
        type_cargovan.setBounds(380, 440 , 200, 30);
        type_cargovan.setFont(font2);
        this.add(type_cargovan);
    }

    public void componentYear() {
        label_year = new JLabel("Year");
        label_year.setFont(font1);
        label_year.setBounds(20, 480 , 200, 30);
        this.add(label_year);

        slider_year = new RangeSlider(1988, 2018, 1988,2018);
        slider_year.setMinorTickSpacing(1);
        slider_year.setMajorTickSpacing(5);
        slider_year.setPaintTicks(true);
        slider_year.setPaintLabels(true);
        slider_year.setBounds(20, 520, 510, 50);

        this.add(slider_year);

        info_sy = new JLabel("Start Year: 1988");
        info_ey = new JLabel("End Year: 2018");
        info_sy.setFont(font3);
        this.add(info_sy);
        info_ey.setFont(font3);
        this.add(info_ey);
//        info_sy.setText();
//        info_ey.setText();
        info_sy.setBounds(20,580, 200, 30);
        info_ey.setBounds(407,580, 200, 30);
    }

    public void componentSubmit() {
        ImageIcon imageIcon2 = new ImageIcon("resources/icons/submit.jpg");
        Image image2 = imageIcon2.getImage();
        Image smallImage2 = image2.getScaledInstance(20, 20,Image.SCALE_FAST);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        btn_submit = new JButton("submit", smallIcon2);
        btn_submit.setFont(font2);
        btn_submit.setBounds(410, 630, 120, 30);
        this.add(btn_submit);
    }

    public void setLayout() {
        setLayout(null);
    }

    public void display() {
        setSize(560, 720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {

        VehicleCriterionUI VehicleCriterionUI = new VehicleCriterionUI();
    }
}


