package ui.selfDefinedUI;

import javax.swing.*;

public class MyTextArea extends JTextArea {
    public MyTextArea(){
        super();
        setOpaque(true);
        setBorder(new RoundBorder());
    }

    public MyTextArea(String s){
        super(s);
        setOpaque(true);
        setBorder(new RoundBorder());
    }
}
