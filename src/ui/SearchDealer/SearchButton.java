package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.decode;

public class SearchButton extends MyButton {
    Graphics2D g2;

    public Graphics2D getG2() {
        return g2;
    }

    public SearchButton() {
        super();
        setBackground(Color.cyan);
        setOpaque(false);
        setPreferredSize(new Dimension(55, 55));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         g2= (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#ffffff"));
        g2.setStroke(new BasicStroke(2.f));
        g2.drawOval(2, 1, getWidth() - 4, getHeight() - 4);


        switch (isMouseEntered) {
            case 0:
                setIcon(new ImageIcon("src/Picture3.png"));

                break;
            case 1:
                //g2.setColor(Color.decode("#e6e6e6"));
                setIcon(new ImageIcon("src/Picture2.png"));
                break;
            case 2:

                setIcon(new ImageIcon("src/Picture1.png"));
            case 3:
                // g2.setColor(Color.decode("#e6e6e6"));
                setIcon(new ImageIcon("src/Picture2.png"));

            default:
                break;
        }
        super.paintComponent(g);

    }


}
