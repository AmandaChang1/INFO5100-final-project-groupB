package ui.selfDefinedUI;

import java.awt.*;

import javax.swing.border.Border;

public class RoundBorder implements Border{
    private Color color;
    private float[] dash;
    private BasicStroke basicStroke;

    public RoundBorder(){
        this.color = Color.lightGray;
        dash = new float[]{5.0f};
        basicStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
    }
    public RoundBorder(Color color){
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(color);

            g.drawRoundRect(0,0,c.getWidth() - 1, c.getHeight() - 1, 15,15);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}