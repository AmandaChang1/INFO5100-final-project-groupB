package ui.SearchDealer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

class MyButton extends JButton {
    private float alpha = 1f; // 底色的透明度，默认为不透明
    protected int isMouseEntered = 1;// 鼠标是否进入按钮

    public MyButton() {
        initStyle();
init();


    }



    public MyButton(String buttonText) {
        super(buttonText);
       init();

    }

        private void init(){
        setForeground(new Color(130,130,130));
        setFont(new Font("Sensa Sans",Font.PLAIN,30));
        initStyle();
        setPreferredSize(new Dimension(20,20));
        //添加鼠标监听
        MouseAdapter mouseAdapter=new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //当鼠标进入时,鼠标进入状态改为TRUE，并重绘按钮
                isMouseEntered = 0;
                repaint();
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseEntered = 1;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                isMouseEntered = 2;
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                isMouseEntered = 3;
                repaint();
            }

        };
        addMouseListener(mouseAdapter);
    }

    /**
     * 初始化按钮样式
     */
    private void initStyle() {
        //初始化透明按钮
        setOpaque(true);
        setBorder(null);
        setBorderPainted(false);
        setFocusable(false);

        setBackground(null);
//      setFocusPainted(false);
        setContentAreaFilled(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2 = (Graphics2D) g;

        // 绘制渐变底色
        switch (isMouseEntered) {
            case 0:
//                AlphaComposite composite = AlphaComposite.getInstance(
////                        AlphaComposite.SRC_OVER, alpha);
////                g2.setComposite(composite);
////                drawButtonBackground(g2, this, Color.decode("#E0F1FC"), Color.decode("#DEEBFE"),
////                        Color.decode("#D6E5F5"), Color.decode("#FFFFFF"));
                setForeground(new Color(250, 250, 250));
                break;
            case 1:
                setForeground(new Color(130,130,130));
                break;
            case 2:
//                AlphaComposite composite1 = AlphaComposite.getInstance(
//                        AlphaComposite.SRC_OVER, alpha);
//                g2.setComposite(composite1);
////          drawButtonBackground(g2, this, Color.decode("#D6E5F5"), Color.decode("#FFFFFF"),
////                  Color.decode("#FFFFFF"), Color.decode("#D6E5F5"));
//                drawButtonPressBackground(g2, this, Color.decode("#D6E5F5"), Color.decode("#EFF5FE"),
//                        Color.decode("#EFF5FE"), Color.decode("#D6E5F5"));
                setForeground(new Color(205,197,191));
            default:
                break;
        }
        super.paintComponent(g);

    }

//    private static void drawButtonBackground(Graphics2D g2, MyButton bt,
//                                             Color c1, Color c2, Color c3, Color c4) {
//
//        // 使平滑
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // 造一个圆角区域
//        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
//                bt.getWidth() - 1, bt.getHeight() - 1, 10, 10);
//        Shape clip = g2.getClip();
//        g2.clip(r2d);
//        g2.setClip(clip);
//
//        g2.setColor(Color.decode("#afafaf"));
//        g2.drawRoundRect(0, 0, bt.getWidth() - 2, bt.getHeight() - 1, 10, 10);
//
//        // 渐变背景
//        g2.setPaint(new GradientPaint(2, 2, c1, 1, bt.getHeight() / 3, c2));
//        g2.fillRoundRect(2, 2, bt.getWidth() - 5, bt.getHeight() / 3, 10, 10);
//        // 渐变二段
//        g2.setPaint(new GradientPaint(1, bt.getHeight() / 3, c3, 1, bt
//                .getHeight(), c4));
//        g2.fillRoundRect(2, bt.getHeight() / 3, bt.getWidth() - 5,
//                bt.getHeight() / 3 * 2 - 1, 10, 10);
//
////      g2.dispose();
//
//    }

    private static void drawButtonPressBackground(Graphics2D g2, MyButton bt,
                                                  Color c1, Color c2, Color c3, Color c4) {

        // 使平滑
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // 造一个圆角区域
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
                bt.getWidth() - 1, bt.getHeight() - 1, 10, 10);
        Shape clip = g2.getClip();
        g2.clip(r2d);
        g2.setClip(clip);

        // 外边框
        g2.drawRoundRect(0, 0, bt.getWidth() - 2, bt.getHeight() - 1, 10, 10);

        // 渐变背景
        g2.setPaint(new GradientPaint(1, bt.getHeight() / 7, c1, 1, bt.getHeight() / 3, c2));
        g2.fillRect(2, 2, bt.getWidth() - 5, bt.getHeight() / 3);
        // 渐变二段
        g2.setPaint(new GradientPaint(1, bt.getHeight() / 3, c3, 1, bt
                .getHeight(), c4));
        g2.fillRect(2, bt.getHeight() / 3, bt.getWidth() - 5,
                bt.getHeight() / 3 * 2 - 1);

        // 内边框
        g2.setColor(Color.decode("#afafaf"));
        g2.drawRoundRect(1, 1, bt.getWidth() - 3, bt.getHeight() - 2, 9, 9);
        g2.drawRoundRect(2, 2, bt.getWidth() - 4, bt.getHeight() - 3, 8, 8);
        g2.setColor(Color.decode("#cfcfcf"));
        g2.drawRoundRect(2, 3, bt.getWidth() - 4, bt.getHeight() - 4, 8, 7);


    }
}
