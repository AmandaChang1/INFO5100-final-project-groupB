package ui.SearchDealer;

import ui.SearchDealer.MyPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends MyPanel {
    public BackgroundPanel(JFrame frame) {
        super();
        int width=(int) (frame.getBounds().getWidth()*0.3);
        int height=(int)(frame.getBounds().getHeight()*0.7);
        setBounds(0,20,(int)frame.getBounds().getWidth(),height);
       setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
       //JPanel panel=new JPanel();

       //panel. setBounds(0,(int)frame.getBounds().getWidth()-width,width,height);
//       JLabel jLabel=new JLabel();
//       ImageIcon imageIcon=new ImageIcon("scr/road.jpg");
//       Image image=imageIcon.getImage();
//       image.getScaledInstance(width,height,Image.SCALE_DEFAULT);
//       imageIcon.setImage(image);
//       jLabel.setIcon(imageIcon);
        JLabel jLabel= null;
        try {
            jLabel = new JLabel();
            ImageIcon imageIcon=new ImageIcon(ImageIO.read(new File("src/Road.jpg")));
            Image image=imageIcon.getImage();
           // image.getScaledInstance(width,height,Image.SCALE_DEFAULT);
            imageIcon.setImage(image);
            jLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //panel.add(jLabel);
       add(jLabel);

    }
}
