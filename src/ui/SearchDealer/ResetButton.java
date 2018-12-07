package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.decode;

public class ResetButton extends MyButton{
    Graphics2D g2;
    public ResetButton(String text) {
        super(text);
        setFont(new Font("Chalkboard",Font.BOLD,50));
        setBackground(Color.cyan);
        setOpaque(false);
        setPreferredSize(new Dimension(60, 60));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         g2= (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#ffffff"));
        g2.setStroke(new BasicStroke(2.f));
        g2.drawOval(8, 8, getWidth()-10, getHeight()-10);


        switch (isMouseEntered) {
            case 0:

                setForeground(Color.decode("#ffffff"));

                break;
            case 1:
                setForeground(Color.decode("#cdcdcd"));
                break;
            case 2:

                setForeground(Color.decode("#e6e6e6"));
            case 3:

                setForeground(Color.decode("#ffffff"));

            default:
                break;
        }
        super.paintComponent(g);

    }


}
