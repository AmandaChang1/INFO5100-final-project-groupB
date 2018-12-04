package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.decode;

public class SearchButton extends MyButton {
    public SearchButton() {
        super();
        setBackground(Color.cyan);
        setOpaque(false);
        setPreferredSize(new Dimension(55, 55));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.decode("#ffffff"));
        g2.setStroke(new BasicStroke(2.f));
        g2.drawOval(2, 1, getWidth() - 4, getHeight() - 4);


        switch (isMouseEntered) {
            case 0:
//                AlphaComposite composite = AlphaComposite.getInstance(
////                        AlphaComposite.SRC_OVER, alpha);
////                g2.setComposite(composite);
////                drawButtonBackground(g2, this, Color.decode("#E0F1FC"), Color.decode("#DEEBFE"),
////                        Color.decode("#D6E5F5"), Color.decode("#FFFFFF"));


                setIcon(new ImageIcon("src/Picture3.png"));

                break;
            case 1:
                //g2.setColor(Color.decode("#e6e6e6"));
                setIcon(new ImageIcon("src/Picture2.png"));
                break;
            case 2:
//                AlphaComposite composite1 = AlphaComposite.getInstance(
//                        AlphaComposite.SRC_OVER, alpha);
//                g2.setComposite(composite1);
////          drawButtonBackground(g2, this, Color.decode("#D6E5F5"), Color.decode("#FFFFFF"),
////                  Color.decode("#FFFFFF"), Color.decode("#D6E5F5"));
//                drawButtonPressBackground(g2, this, Color.decode("#D6E5F5"), Color.decode("#EFF5FE"),
//                        Color.decode("#EFF5FE"), Color.decode("#D6E5F5"));
                //g2.setColor(Color.decode("#cdcdcd"));


                setIcon(new ImageIcon("src/Picture1.png"));
            case 3:
                // g2.setColor(Color.decode("#e6e6e6"));
                setIcon(new ImageIcon("src/Picture2.png"));

            default:
                break;
        }
        super.paintComponent(g);

    }

    private static void drawButtonBackground(Graphics2D g2, MyButton bt,
                                             Color c1, Color c2, Color c3, Color c4) {

        // 使平滑
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // 造一个圆角区域
//        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
//                bt.getWidth() - 1, bt.getHeight() - 1, 10, 10);
//        Shape clip = g2.getClip();
//        g2.clip(r2d);
//        g2.setClip(clip);

        g2.setColor(decode("#afafaf"));
        g2.drawOval(0, 0, bt.getWidth(), bt.getHeight());

        // 渐变背景
//        g2.setPaint(new GradientPaint(2, 2, c1, 1, bt.getHeight() / 3, c2));
//        //g2.fillRoundRect(2, 2, bt.getWidth() - 5, bt.getHeight() / 3, 10, 10);
//        // 渐变二段
//        g2.setPaint(new GradientPaint(1, bt.getHeight() / 3, c3, 1, bt
//                .getHeight(), c4));
//        g2.fillRoundRect(2, bt.getHeight() / 3, bt.getWidth() - 5,
//                bt.getHeight() / 3 * 2 - 1, 10, 10);

//      g2.dispose();

    }
}
