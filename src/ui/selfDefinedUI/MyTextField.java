package ui.selfDefinedUI;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField{

    Font font;
    public MyTextField() {
        super();
        font = new Font("Baskerville", Font.PLAIN,18);
        setFont(font);
        setOpaque(true);
        setBorder(new RoundBorder());
    }

}
