package ui.SearchDealer;

import java.awt.*;

public class PageButton extends ResetButton{

    private MyFont font;
    public PageButton(String text) {
        super(text);
        font=new MyFont();

        setPreferredSize(new Dimension(30, 30));
        setFont(font.loadCALIBRIBFont(20));

    }


}
