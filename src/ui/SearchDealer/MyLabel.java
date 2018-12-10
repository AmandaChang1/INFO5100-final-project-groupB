package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    MyLabel(String Text) {
        super(Text);
        setForeground(Color.decode("#ffffff"));
        setBackground(Color.cyan);
        setOpaque(false);
    }

    public MyLabel() {

    }
}
