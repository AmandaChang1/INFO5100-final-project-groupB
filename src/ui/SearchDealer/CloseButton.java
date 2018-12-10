package ui.SearchDealer;

import ui.SearchDealer.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CloseButton extends MyButton {
    public CloseButton(String buttonText, JFrame frame) {
        super(buttonText);
        setFont(new Font("Courier",Font.BOLD,20));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                System.exit(0);

            }
        });

    }
}
