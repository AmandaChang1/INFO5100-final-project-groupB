package ui.SearchDealer;

import com.sun.tools.internal.ws.util.xml.XmlUtil;
import sun.java2d.xr.XRUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class MyComboBox extends JComboBox {

    public MyComboBox(){
        super();
        init();
    }
    public MyComboBox(ComboBoxModel model){
        super(model);
        init();
    }
    public MyComboBox(Object[] items){
        super(items);
        init();
    }
    public MyComboBox(Vector<?> items){
        super(items);
        init();
    }
    private void init(){
        setBackground(new Color(54,54,54));
        setOpaque(true);

        setUI(new IComboBoxUI());
        setRenderer(new IComboBoxRenderer());
        setPreferredSize(new Dimension(150, 20));

    }
    public Dimension getPreferredSize(){
        return super.getPreferredSize();
    }
}

class IComboBoxRenderer implements ListCellRenderer {

    private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

    public IComboBoxRenderer() {
        super();
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {

        JLabel renderer = (JLabel)defaultCellRenderer.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        if(isSelected){
            renderer.setBackground(Color.black);
            renderer.setForeground(Color.WHITE);
        }else{
            renderer.setBackground(Color.WHITE);
            renderer.setForeground(Color.BLACK);
        }
        list.setSelectionBackground(new Color(65, 63, 65));
        list.setSelectionForeground(new Color(200, 196, 190));
        list.setBorder(null);
        //renderer.setFont(new F);
        renderer.setHorizontalAlignment(JLabel.CENTER);
        return renderer;
    }
}
class IComboBoxUI extends BasicComboBoxUI {

    private JButton arrow;
    private boolean boundsLight = false;
    private static final int ARCWIDTH = 15;
    private static final int ARCHEIGHT = 15;



    public IComboBoxUI() {
        super();


    }

    protected JButton createArrowButton() {
        arrow = new JButton();
        FileOutputStream fos = null;
        arrow.setIcon(new ImageIcon("src/xiala.png"));
        arrow.setRolloverEnabled(true);

        arrow.setIcon(new ImageIcon("src/xiala.png"));
        arrow.setRolloverEnabled(true);

            arrow.setIcon(new ImageIcon("src/xiala.png"));

        arrow.setBorder(null);
        arrow.setBackground(null);
        arrow.setOpaque(false);
        arrow.setContentAreaFilled(false);
        return arrow;
    }



    public void paint(Graphics g, JComponent c) {
        hasFocus = comboBox.hasFocus();
        Graphics2D g2 = (Graphics2D)g;
        if (!comboBox.isEditable()) {
            Rectangle r = rectangleForCurrentValue();
            //重点:JComboBox的textfield 的绘制 并不是靠Renderer来控制 这点让我很吃惊.
            //它会通过paintCurrentValueBackground来绘制背景
            //然后通过paintCurrentValue();去绘制JComboBox里显示的值
            paintCurrentValueBackground(g2, r, hasFocus);
            paintCurrentValue(g2, r, hasFocus);
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int width = (int) this.getPreferredSize(c).getWidth()
                + arrow.getWidth() - 2;
        int height = 0;
        int heightOffset = 0;

        if (comboBox.isPopupVisible()) {
            heightOffset = 5;
            height = 150;

                arrow.setIcon(new ImageIcon("src/xiala.png"));

        } else {
            heightOffset = 0;
            height = 150;
            try {
                arrow.setIcon(new ImageIcon(ImageIO.read(new File("src/xiala.png"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (comboBox.isFocusable()) {
            g2.setColor(new Color(130,130,130));
        }
        g2.drawRect(0,0,150, height + heightOffset);
        //g2.drawRoundRect(0, 0, width, height + heightOffset,3,3);
    }

    public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
        Font oldFont = comboBox.getFont();
        //comboBox.setFont(XUtil.defaultComboBoxFont);

        super.paintCurrentValue(g, bounds, hasFocus);
        comboBox.setFont(oldFont);
    }

    public Dimension getPreferredSize(JComponent c) {
        return super.getPreferredSize(c);
    }

    public boolean isBoundsLight() {
        return boundsLight;
    }

    public void setBoundsLight(boolean boundsLight) {
        this.boundsLight = boundsLight;
    }

    protected ComboPopup createPopup() {
        ComboPopup popup = new BasicComboPopup(comboBox) {
            protected JScrollPane createScroller() {
               JScrollPane sp = new JScrollPane(list,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
              //sp.setHorizontalScrollBar();


                return sp;
            }

            //重载paintBorder方法 来画出我们想要的边框..
            public void paintBorder(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(130,130,130));
                g2.drawRect(0,-arrow.getHeight(),getWidth()-1,getHeight()+arrow.getHeight()-1);
                int i=0;
            }
        };
        return popup;
    }
}

class IScrollBarUI extends BasicScrollBarUI {
    public IScrollBarUI(){
        super();
    }

    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int width = thumbBounds.width;
        int height = thumbBounds.height;
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.translate(thumbBounds.x, thumbBounds.y);
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(1,1,width-2, height-2,5,5);

        g2.setColor(Color.ORANGE);
        g2.drawLine(3,height/2,width-4,height/2);
        g2.drawLine(3,height/2+3,width-4,height/2+3);
        g2.translate(-thumbBounds.x, -thumbBounds.y);
    }

    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(Color.WHITE);
        int x = trackBounds.x;
        int y = trackBounds.y;
        int width = trackBounds.width;
        int height = trackBounds.height;
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite
                .getInstance(AlphaComposite.SRC_OVER, 0.1f));

        g2.fill3DRect(x, y, width, height, true);
        g2.setComposite(AlphaComposite
                .getInstance(AlphaComposite.SRC_OVER, 1f));
        g2.setColor(Color.GRAY.brighter());
        g2.fill3DRect(x, y, 1, height+1, true);
        if(trackHighlight == DECREASE_HIGHLIGHT) {
            paintDecreaseHighlight(g);
        }
        else if(trackHighlight == INCREASE_HIGHLIGHT)  {
            paintIncreaseHighlight(g);
        }
    }

    protected JButton createIncreaseButton(int orientation) {
        JButton button = new BasicArrowButton(orientation){
            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLACK);
                g2.drawLine(0,0,0,getHeight());
                g2.drawLine(0,0,getWidth(),0-1);
                try {
                    g2.drawImage((new ImageIcon(ImageIO.read(new File("src/xiala.png")))).getImage(),-1,0,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        button.setOpaque(false);
        return button;
    }

    protected JButton createDecreaseButton(int orientation) {


        JButton button = new BasicArrowButton(orientation){
            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.BLACK);
                g2.drawLine(0,0,0,getHeight());
                g2.drawLine(0,getHeight()-1,getWidth(),getHeight());
                try {
                    g2.drawImage((new ImageIcon(ImageIO.read(new File("src/xiala.png")))).getImage(),-1,0,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        button.setOpaque(false);
        return button;
    }
}


