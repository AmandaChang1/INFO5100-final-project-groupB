package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MinimizeButton extends MyButton{

    public MinimizeButton(String buttonText,JFrame frame) {
        super(buttonText);
        setFont(new Font("Courier",Font.BOLD,20));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                    frame.setExtendedState(JFrame.ICONIFIED);

            }
        });

    }


}
