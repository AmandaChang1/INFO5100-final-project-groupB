package ui.SearchDealer;

import dto.Dealer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
    }



    class ResPanel extends JPanel{
        MyLabel name,zipcode,location,address;
        SearchButton searchButton;
        public ResPanel(Dealer dealer) {

            super();
            JPanel panelname,panelzipcode,panellocation,paneladdress,spacepanel;
            panelname=new MyPanel();
            panelzipcode=new MyPanel();
            panellocation=new MyPanel();
            paneladdress=new MyPanel();
            spacepanel=new MyPanel();
            panelname.setPreferredSize(new Dimension(200,150));
            spacepanel.setPreferredSize(new Dimension(200,50));
            panelzipcode.setPreferredSize(new Dimension(200,20));
            //panellocation.setPreferredSize(new Dimension(200,10));
            paneladdress.setPreferredSize(new Dimension(200,20));
            panelname.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelzipcode.setLayout(new FlowLayout(FlowLayout.LEFT));
            panellocation.setLayout(new FlowLayout(FlowLayout.LEFT));
            paneladdress.setLayout(new FlowLayout(FlowLayout.LEFT));
            name=new MyLabel(dealer.getName());
            zipcode=new MyLabel(dealer.getZipcode()+","+dealer.getLocation());

            address=new MyLabel(dealer.getAddress());
            setLayout(new FlowLayout(FlowLayout.LEFT,15,0));
            setPreferredSize(new Dimension(200,300));
            setBackground(Color.BLACK);
            name.setFont(new Font("HeadLineA",Font.PLAIN,25));
            name.setForeground(Color.decode("#8B7355"));
            zipcode.setFont(new Font("Heiti SC",Font.PLAIN,12));
            //location.setFont(new Font("Heiti SC",Font.PLAIN,12));
            address.setFont(new Font("Heiti SC",Font.PLAIN,12));

            panelname.add(name);
            panelzipcode.add(zipcode);

            paneladdress.add(address);
            add(spacepanel);
            add(panelname);
            add(panelzipcode);

            add(paneladdress);
            WebButton searchButton=new WebButton("W");


            searchButton.addActionListener(new ActionListener() {

                public void actionPerformed(final ActionEvent arg0) {



//Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe　http://www.baidu.com"); 　//绝对路径

                        Desktop desktop = Desktop.getDesktop();

                        try {
                            try {
                                desktop.browse(new URI("http://"+dealer.getUrl()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }


                }
            });

                    add(searchButton);
        }
    }
}
