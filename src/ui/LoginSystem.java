package ui;

import service.UserService;
import service.UserServiceImple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Administrator
 *
 */
public class LoginSystem {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        JFrame f=new JFrame();
        f.setTitle("系统登录界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);

//设置窗口的大小和位置
        f.setSize(400,400);
        f.setLocation(200,200);


        Container con=f.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7,1));

        JPanel pan1=new JPanel();//生成一个新的版面
        JLabel title=new JLabel("欢迎登陆本系统");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);
//最上面的登陆文字

        JPanel pan2=new JPanel();//生成一个新的版面
        JLabel name=new JLabel("用户名");
        pan2.add(name);
        TextField tf_name=new TextField(20);
//        tf_name.setText("请在此处输入用户名");
        pan2.add(tf_name);
        con.add(pan2);
//用户名及其文本框放置在第二个版面上


        JPanel pan3=new JPanel();//生成一个新的版面
        JLabel pass = new JLabel("密码");
        pan3.add(pass);
        JPasswordField password=new JPasswordField(15);
        password.setEchoChar('*');
        pan3.add(password);
        con.add(pan3);
//密码及其密码域放在第三个版面上


        JPanel contentPane=new JPanel();
        JLabel label=new JLabel("我是:");
        contentPane.add(label);
        JComboBox comboBox=new JComboBox();
        comboBox.addItem("顾客");
        comboBox.addItem("卖家");
        contentPane.add(comboBox);
        con.add(contentPane);



        JPanel pan4 = new JPanel();
        JButton b_log=new JButton("登陆");
        pan4.add(b_log);
        JButton b_exit=new JButton("注册");
        pan4.add(b_exit);
        con.add(pan4);
        b_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取到的事件源就是按钮本身
                // JButton btn = (JButton) e.getSource();
                UserService userService = new UserServiceImple();
                if(comboBox.getSelectedItem() == "卖家"){

                    userService.addD(tf_name.getText(),String.valueOf(password.getPassword()));
                    JOptionPane.showMessageDialog(null,"成功！");
                }else{
                    userService.addC(tf_name.getText(),String.valueOf(password.getPassword()));
                    JOptionPane.showMessageDialog(null,"成功!");
                }
            }
        });
        b_log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserService userService = new UserServiceImple();
                if(comboBox.getSelectedItem() == "卖家"){
                    if(userService.compareD(tf_name.getText(),String.valueOf(password.getPassword()))){
                        JOptionPane.showMessageDialog(null,"成功！");
                    }
                }else{
                    if(userService.compareC(tf_name.getText(),String.valueOf(password.getPassword()))){
                        JOptionPane.showMessageDialog(null,"成功！");
                    }
                }
            }
        });
//登陆和退出这两个按钮放在第四个版面上

//空白版面
    }

}