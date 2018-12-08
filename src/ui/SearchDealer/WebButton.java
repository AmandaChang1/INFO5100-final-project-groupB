package ui.SearchDealer;

import java.awt.*;

public class WebButton extends MyButton{
    public WebButton(String text) {
        super(text);
        setBackground(Color.cyan);
        setOpaque(false);
        setPreferredSize(new Dimension(30, 30));
        setFont(new Font("Chalkboard",Font.BOLD,20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#8B7355"));
        g2.setStroke(new BasicStroke(2.f));
        g2.drawOval(8, 8, getWidth()-10, getHeight()-10);


        switch (isMouseEntered) {
            case 0:
                setForeground(Color.decode("#ffffff"));
                break;
            case 1:
                //g2.setColor(Color.decode("#e6e6e6"));
                setForeground(Color.decode("#cdcdcd"));
                break;
            case 2:
                setForeground(Color.decode("#e6e6e6"));
            case 3:
                // g2.setColor(Color.decode("#e6e6e6"));
                setForeground(Color.decode("#ffffff"));

            default:
                break;
        }
        super.paintComponent(g);

    }
}

