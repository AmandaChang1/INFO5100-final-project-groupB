package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class SelectionUI extends JFrame {

    private JButton vehicle, special;
    private Container container = getContentPane();
    private JPanel jPanel_up = new JPanel(), jPanel_mid = new JPanel();
    private JLabel title;
    private String dealername;

//    public static void main(String[] args) {
//        SelectionUI selectionUI = new SelectionUI();
//    }
    public SelectionUI(String dealerName){
        this.dealername = dealerName;
        createComponents();
        setLayouts();
        addComponents();
        addBehaviors();
        display();
    }

    private void addBehaviors() {
        vehicle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    new ui.VehicleTable(dealername);
                    dispose();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

        special.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                new SpecialManageUI(dealername);
                dispose();
            }
        });
    }


    private void display() {
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void addComponents() {
        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(50,jPanel_up.getHeight());
        jPanel_up.add("West",jPanel1);
        jPanel_up.add("Center", title);
        JPanel jPanel2 = new JPanel();
        jPanel2.setSize(5,jPanel_up.getHeight());
        jPanel_up.add("East",jPanel2);
        container.add(jPanel_up);

        jPanel_mid.add(new JPanel());
        jPanel_mid.add(vehicle);
        jPanel_mid.add(new JPanel());
        jPanel_mid.add(special);
        jPanel_mid.add(new JPanel());
        container.add(jPanel_mid);

        container.add(new JPanel());

    }

    private void setLayouts() {
        container.setLayout(new GridLayout(3,1));
        jPanel_up.setLayout(new BorderLayout());
        jPanel_mid.setLayout(new GridLayout(1,5));
    }

    private void createComponents() {
        vehicle = new JButton("Vehicle");
        special = new JButton("Special");
        title = new JLabel("          Which one do you want to modify? ");
    }

}
