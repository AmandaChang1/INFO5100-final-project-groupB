package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VehicleDetailFrame extends CarSearchDefination{

	protected JFrame vehicleDetailFrame;
	protected JPanel imagePanel;
	protected JPanel Specifications;
	protected JLabel imageLabel;

	protected JLabel specification, brand, model, year, category, price;

	protected ImageIcon carImage;
	//GridBagLayout gbl;
	//GridBagConstraints gbc;

	public void VehicleDetailFrame(){
		createComponents();
		addComponents();
	}

	void createComponents(){
		vehicleDetailFrame = new JFrame("Vehicle Details");
		vehicleDetailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vehicleDetailFrame.setSize(400,400);
		imagePanel = new JPanel();
		Specifications = new JPanel();
		imageLabel = new JLabel("Picture");
		//gbl = new GridBagLayout();
		//gbc = new GridBagConstraints();

		vehicleDetailFrame.setLayout(new GridLayout(1,2));
		Specifications.setLayout(new GridBagLayout());
        imageLabel = new JLabel(new ImageIcon("src//ui//Images//jaguar.png"));
        
        specification = new JLabel("Specification: ");
		brand = new JLabel("Brand: ");
		model = new JLabel("Model: ");
		year = new JLabel("Year: ");
		category = new JLabel("Category: ");
		price = new JLabel("Price: ");

	}


	void addComponents(){ 
		GridBagConstraints gbc = new GridBagConstraints();
		vehicleDetailFrame.getContentPane();


		//vehicleDetailFrame.add(Image);
		imagePanel.setLayout(new BorderLayout());

		imagePanel.add(imageLabel, BorderLayout.CENTER);
        vehicleDetailFrame.add(imagePanel);
        
		vehicleDetailFrame.add(Specifications);


		gbc.gridx = 0;
		gbc.gridy = 0;
		Specifications.add(specification, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		Specifications.add(brand, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		Specifications.add(model, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		Specifications.add(year, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		Specifications.add(category, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		Specifications.add(price, gbc);

		Specifications.setVisible(true);
		imagePanel.setVisible(true);
		vehicleDetailFrame.setVisible(true);
	}
	}
