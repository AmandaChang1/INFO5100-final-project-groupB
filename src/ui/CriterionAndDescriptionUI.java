package ui;

import ui.selfDefinedUI.MyTextArea;

import javax.swing.*;
import java.awt.*;

public class CriterionAndDescriptionUI extends JFrame {

    JLabel criterionLabel, descriptionLabel;
    MyTextArea criterionTextArea, descriptionTextArea;

    public CriterionAndDescriptionUI() {
        createComponent();
        addComponnet();
        setSize(new Dimension(600, 200));
        setVisible(true);
    }

    public CriterionAndDescriptionUI(String criterion, String description) {
        createComponent();
        addComponnet();
        setSize(new Dimension(600, 200));
        setVisible(true);
        criterionTextArea.setText(criterion);
        descriptionTextArea.setText(description);
        new Close().start();
    }
    class Close extends Thread{

        public void run(){
            for(int i = 0; i < 5; i++){
                try{
                    Thread.sleep(1000);//线程暂停1S
                }catch (InterruptedException e) {
                }
            }
            dispose();
        }
    }

    private void createComponent() {
        criterionLabel = new JLabel("Criterion: ");
        criterionTextArea = new MyTextArea();
        criterionTextArea.setBackground(getBackground());
        descriptionLabel = new JLabel("Description: ");
        descriptionTextArea = new MyTextArea();
        descriptionTextArea.setBackground(getContentPane().getBackground());
    }

    private void addComponnet() {
        Container container = getContentPane();
        container.setBackground(Color.lightGray);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(criterionLabel);
        container.add(panel);
        container.add(criterionTextArea);
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(descriptionLabel);
        container.add(panel);
        container.add(descriptionTextArea);

    }

    public static void main(String[] arg){
        CriterionAndDescriptionUI criterionAndDescriptionUI = new CriterionAndDescriptionUI("test", "testtesttesttest");
    }
}
