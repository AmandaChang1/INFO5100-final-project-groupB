package ui;

import ui.VehicleTable;
import dao.*;
import dto.Inventory;
import dto.Vehicle;
import service.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

import service.*;
public class Modify extends JFrame {

//	public static void main(String[] args) {
//		UpdateLayout ul = new UpdateLayout();
//		ul.go();
//	}

    private Vehicle vehicle;
    JTextField fieldDealerID;
    JTextField fieldID;
    JTextField fieldCategory;
    JTextField fieldYear;
    JTextField fieldMake;
    JTextField fieldModel;
    JTextField fieldTrim;
    JTextField fieldType;
    JTextField fieldPrice;
    JButton uploadButton;
    JPanel updateP;
    private ManageVehicle mc;
    private String dealerName;

    public Modify(){
        setContentPane(updateP);
        setSize(800, 600);
        go();
        setLocationRelativeTo(null);
        //frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Modify(Vehicle vehicle,String dealerName){
        this.mc = new ManageVehicleImple();
        mc.updateVehicle(vehicle);
        this.vehicle = vehicle;
//        System.out.println(vehicle.getId());
        go();
        setContentPane(updateP);
        setSize(800, 600);
        setLocationRelativeTo(null);
        //frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setTextFields();
        this.dealerName = dealerName;
    }



    public void go() {
        this.setTitle("Modify Inventory");

		updateP = new JPanel();

		updateP.setLayout(new GridLayout(11, 2, 30, 10));

        JLabel labelDealerID = new JLabel("Dealer ID: ");
        fieldDealerID = new JTextField("gmps-priority");

        JLabel labelID = new JLabel("ID: ");
        fieldID = new JTextField(20);
        JLabel labelCategory = new JLabel("Category: ");
        fieldCategory = new JTextField(20);
        JLabel labelYear = new JLabel("Year: ");
        fieldYear = new JTextField(20);
        JLabel labelMake = new JLabel("Make: ");
        fieldMake = new JTextField(20);
        JLabel labelModel = new JLabel("Model: ");
        fieldModel = new JTextField(20);
        JLabel labelTrim = new JLabel("Trim: ");
        fieldTrim = new JTextField(20);
        JLabel labelType = new JLabel("Type: ");
        fieldType = new JTextField(20);
        JLabel labelPrice = new JLabel("Price: ");
        fieldPrice = new JTextField(20);
        JLabel labelImages = new JLabel("Images: ");
        uploadButton = new JButton("upload");
        JButton updateButton = new JButton("update");
        JButton clearButton = new JButton("clear");
        fieldDealerID.setEditable(false);



        uploadButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                showFileOpenDialog(updateP);
            }
        });

        updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				vehicle.setDealerId(fieldDealerID.getText());
				vehicle.setId(fieldID.getText());
				vehicle.setCategory(fieldCategory.getText());
				vehicle.setYear(fieldYear.getText());
				vehicle.setMake(fieldMake.getText());
				vehicle.setModel(fieldModel.getText());
				vehicle.setTrim(fieldTrim.getText());
				vehicle.setType(fieldType.getText());
				vehicle.setPrice(fieldPrice.getText());
				vehicle.setImages(uploadButton.getText());
				mc.updateVehicle(vehicle);

                VehicleTable table = null;
                try {
                    table = new VehicleTable(dealerName);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                table.invalidate();
			}
		});

        clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fieldID.setText(null);
	            fieldCategory.setText(null);
	            fieldYear.setText(null);
	            fieldMake.setText(null);
	            fieldModel.setText(null);
	            fieldTrim.setText(null);
	            fieldType.setText(null);
	            fieldPrice.setText(null);
			}
		});


        updateP.add(labelDealerID);
        updateP.add(fieldDealerID);
        updateP.add(labelID);
        updateP.add(fieldID);
        updateP.add(labelCategory);
        updateP.add(fieldCategory);
        updateP.add(labelYear);
        updateP.add(fieldYear);
        updateP.add(labelMake);
        updateP.add(fieldMake);
        updateP.add(labelModel);
        updateP.add(fieldModel);
        updateP.add(labelTrim);
        updateP.add(fieldTrim);
        updateP.add(labelType);
        updateP.add(fieldType);
        updateP.add(labelPrice);
        updateP.add(fieldPrice);
        updateP.add(labelImages);
        updateP.add(uploadButton);
        updateP.add(updateButton);
        updateP.add(clearButton);


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
//	        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));
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

    public void setTextFields(){
        fieldID.setText(vehicle.getId() +"");
        fieldCategory.setText(vehicle.getCategory()+"");
        fieldMake.setText(vehicle.getMake()+"");
        fieldModel.setText(vehicle.getModel()+"");
        fieldYear.setText(vehicle.getYear()+"");
        fieldPrice.setText(vehicle.getPrice()+"");
        fieldTrim.setText(vehicle.getTrim()+"");
        fieldType.setText(vehicle.getType()+"");

    }
}
