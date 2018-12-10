package ui.SearchDealer;

import ui.SearchDealer.MyPanel;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends MyPanel {
    public ControlPanel(JFrame frame) {
        super();
        int x=(int)frame.getBounds().getX();
        setBounds(0,0,(int)frame.getBounds().getWidth(),20);
        setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        setBackground(new Color(40,40,40));
        setOpaque(true);
    }
}
