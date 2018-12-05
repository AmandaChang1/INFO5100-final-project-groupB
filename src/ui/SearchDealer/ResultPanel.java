package ui.SearchDealer;

import dto.Dealer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ResultPanel extends MyPanel{

    ImageIcon icon;
    Image img;
    public ResultPanel(JFrame frame) {
        super();
        init(frame);
    }

    public ResultPanel(JFrame frame, ArrayList<Dealer> dealers) {
        super();

        init(frame);
        //ResPanel[] res=new ResPanel[3];
        MyPanel panel=new MyPanel();
        panel.setBounds(20,50,800,600);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,125));
        for(int i=0;i<dealers.size();i++){
           ResPanel res=new ResPanel(dealers.get(i));
           panel.add(res);

        }
        add(panel);


    }
        //  /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
    @Override

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
    }


    public void init(JFrame frame){
        try {
            icon=new ImageIcon(ImageIO.read(new File("src/Road.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        img=icon.getImage();

        int width=(int) (frame.getBounds().getWidth()*0.3);
        int height=(int)(frame.getBounds().getHeight()*0.7);
        setBounds(270,15,900,550);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
//      setLayout(null);
//      JLabel jLabel= null;
//      try {
//            jLabel = new JLabel();
//            ImageIcon imageIcon=new ImageIcon(ImageIO.read(new File("src/Road.jpg")));
//            Image image=imageIcon.getImage();
//            // image.getScaledInstance(width,height,Image.SCALE_DEFAULT);
//            imageIcon.setImage(image);
//            jLabel.setIcon(imageIcon);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//      panel.add(jLabel);
//      add(jLabel);
    }



    class ResPanel extends JPanel{
        MyLabel name,zipcode,location,address;
        SearchButton searchButton;
        public ResPanel(Dealer dealer) {

            super();
            JPanel panelname,panelzipcode,panellocation,paneladdress;
            panelname=new MyPanel();
            panelzipcode=new MyPanel();
            panellocation=new MyPanel();
            paneladdress=new MyPanel();
            panelname.setPreferredSize(new Dimension(200,30));
            panelzipcode.setPreferredSize(new Dimension(200,30));
            panellocation.setPreferredSize(new Dimension(200,30));
            paneladdress.setPreferredSize(new Dimension(200,30));
            panelname.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelzipcode.setLayout(new FlowLayout(FlowLayout.LEFT));
            panellocation.setLayout(new FlowLayout(FlowLayout.LEFT));
            paneladdress.setLayout(new FlowLayout(FlowLayout.LEFT));
            name=new MyLabel(dealer.getName());
            zipcode=new MyLabel(dealer.getZipcode());
            location=new MyLabel(dealer.getLocation());
            address=new MyLabel(dealer.getAddress());
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            setPreferredSize(new Dimension(200,300));
            setBackground(Color.BLACK);
            name.setFont(new Font("Bauhaus 93",Font.PLAIN,20));
            name.setForeground(Color.decode("#8B7355"));
            zipcode.setFont(new Font("Bauhaus 93",Font.PLAIN,18));
            location.setFont(new Font("Bauhaus 93",Font.PLAIN,18));
            address.setFont(new Font("Bauhaus 93",Font.PLAIN,18));
            panelname.add(name);
            panelzipcode.add(zipcode);
            panellocation.add(location);
            paneladdress.add(address);
            add(panelname);
            add(panelzipcode);
            add(panellocation);
            add(paneladdress);
        }



    }
}
