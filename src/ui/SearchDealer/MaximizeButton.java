package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MaximizeButton extends MyButton{
    private boolean time=false;
    public MaximizeButton(String buttonText,JFrame frame) {
        super(buttonText);
        setFont(new Font("Courier",Font.BOLD,20));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(!time) {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    time=true;
                }
                else{
                    frame.setExtendedState(JFrame.DO_NOTHING_ON_CLOSE);
                    time=false;
                }
            }
        });
    }
}
