package ui.selfDefinedUI;

import javax.swing.*;

public class MyButton extends JButton {
    public MyButton() {
        super();
        this.setBorderPainted(false);
    }
    public MyButton(Icon icon) {
        super(icon);
        this.setBorderPainted(false);
    }
    public MyButton(String text) {
        super(text);
        this.setBorderPainted(false);
    }
}
