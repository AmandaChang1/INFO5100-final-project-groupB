package ui.selfDefinedUI;

import javax.swing.*;
import java.awt.*;

public class MyTextArea extends JTextArea {

    Font font;
    public MyTextArea(){
        super();
        font = new Font("Baskerville", Font.PLAIN,15);
        setFont(font);
        setOpaque(true);
        setBorder(new RoundBorder());
    }

    public MyTextArea(String s){
        super(s);
        font = new Font("Baskerville", Font.PLAIN,15);
        setFont(font);
        setOpaque(true);
        setBorder(new RoundBorder());
    }
}
