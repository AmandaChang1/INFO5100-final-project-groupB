package ui;


import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.*;
import dto.Inventory;
import dto.Vehicle;

public class MainLayout extends JFrame {
	
//	public static void main(String[] args) {
//		MainLayout mm = new MainLayout();
//		mm.go();
//		
//	}
	
//	public void go() {
//		JFrame frame2 = new JFrame("Modify Inventory");
//		JPanel mainP = new JPanel();
//
//		JButton addB = new JButton();
//		JButton searchB = new JButton();
//		addB.setBounds(0, 0, 360, 360);
//		searchB.setBounds(0, 0, 360, 360);
//
//		ImageIcon ic1 = new ImageIcon("add.png");
//		ImageIcon ic2 = new ImageIcon("search.png");
//
//		addB.setIcon(ic1);
//		searchB.setIcon(ic2);
//
//
//		addB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame2.dispose();
//				AddCars ac = new AddCars();
//				ac.add();
//			}
//		});
//
//
//		mainP.add(addB);
//		mainP.add(searchB);
//
//
//		frame2.setContentPane(mainP);
//		frame2.setSize(500, 250);
//        frame2.setLocationRelativeTo(null);
//        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame2.setVisible(true);
//	}
}


class AddCars extends JFrame{
	
	public void add(String dealerName) {
		JFrame frame3 = new JFrame("Add New Inventory");
		JPanel addP = new JPanel();
		
		addP.setLayout(new GridLayout(11, 2, 30, 10));

        JLabel labelDealerID = new JLabel("Dealer ID: ");
        JTextField fieldDealerID = new JTextField(dealerName);
        fieldDealerID.setEditable(false);
//        JLabel labelID = new JLabel("Car ID: ");
//        JTextField fieldID = new JTextField(20);
        JLabel labelCategory = new JLabel("Category: ");
        JTextField fieldCategory = new JTextField(20);
        JLabel labelYear = new JLabel("Year: ");
        JTextField fieldYear = new JTextField(20);
        JLabel labelMake = new JLabel("Make: ");
        JTextField fieldMake = new JTextField(20);
        JLabel labelModel = new JLabel("Model: ");
        JTextField fieldModel = new JTextField(20);
        JLabel labelTrim = new JLabel("Trim: ");
        JTextField fieldTrim = new JTextField(20);
        JLabel labelType = new JLabel("Type: ");
        JComboBox type = new JComboBox();
        type.addItem("CAR");
        type.addItem("SUV");
        type.addItem("TRUCK");
        type.addItem("VAN");
        JLabel labelPrice = new JLabel("Price: ");
        JTextField fieldPrice = new JTextField(20);
        JLabel labelImages = new JLabel("Images: ");
        JButton uploadButton = new JButton("upload");
        JButton addButton = new JButton("add");
        JButton exitButton = new JButton("exit");
        
        uploadButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                showFileOpenDialog(frame3);
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	frame3.dispose();
//            	MainLayout ml = new MainLayout();
//				ml.go();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Vehicle vehicle = new Vehicle();

                vehicle.setDealerId(fieldDealerID.getText());
                //vehicle.setId(fieldID.getText());
                vehicle.setCategory(fieldCategory.getText());
                vehicle.setYear(fieldYear.getText());
                vehicle.setMake(fieldMake.getText());
                vehicle.setModel(fieldModel.getText());
                vehicle.setTrim(fieldTrim.getText());
                vehicle.setType((String) type.getSelectedItem());
                vehicle.setPrice(fieldPrice.getText());
                vehicle.setImages(uploadButton.getText());

                ManageVehicle manageVehicle = new ManageVehicleImple();
                manageVehicle.addVehicle(vehicle);
                frame3.dispose();
            }
        });



        addP.add(labelDealerID);
        addP.add(fieldDealerID);
//        addP.add(labelID);
//        addP.add(fieldID);
        addP.add(labelCategory);
        addP.add(fieldCategory);
        addP.add(labelYear);
        addP.add(fieldYear);
        addP.add(labelMake);
        addP.add(fieldMake);
        addP.add(labelModel);
        addP.add(fieldModel);
        addP.add(labelTrim);
        addP.add(fieldTrim);
        addP.add(labelType);
        addP.add(type);
        addP.add(labelPrice);
        addP.add(fieldPrice);
        addP.add(labelImages);
        addP.add(uploadButton);
        addP.add(addButton);
        addP.add(exitButton);

		frame3.setContentPane(addP);
		frame3.setSize(800, 600);
        frame3.setLocationRelativeTo(null);
        //frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame3.setVisible(true);


	}

	//从本地选择照片上传
	private static void showFileOpenDialog(Component parent) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();

        // 设置默认显示的文件夹为当前文件夹
        fileChooser.setCurrentDirectory(new File("."));

        // 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 设置是否允许多选
        fileChooser.setMultiSelectionEnabled(true);

        // 添加可用的文件过滤器（FileNameExtensionFilter 的第一个参数是描述, 后面是需要过滤的文件扩展名 可变参数）
//        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));

        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            File file = fileChooser.getSelectedFile();

            // 如果允许选择多个文件, 则通过下面方法获取选择的所有文件
            // File[] files = fileChooser.getSelectedFiles();

        }
    }



}



