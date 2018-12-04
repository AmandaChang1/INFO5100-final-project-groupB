package ui.SearchDealer;

import java.awt.*;

public class PageButton extends ResetButton{

    public PageButton(String text) {
        super(text);
        setPreferredSize(new Dimension(30, 30));
        setFont(new Font("Chalkboard",Font.BOLD,20));
    }
}
