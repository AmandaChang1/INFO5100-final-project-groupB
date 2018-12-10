package ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.Inventory;
import dto.Vehicle;
import service.VehicleService;
import service.VehicleServiceImple;

public class Controller extends CarSearchDefination implements ActionListener{
	
	
	@Override
	public void actionPerformed(ActionEvent e ) {
		
    	 JFrame vehicleDetailFrame;
    	 JPanel imagePanel;
    	 JPanel Specifications;
    	 JLabel imageLabel;

    	 JLabel specification, brand, model, year, category, price;

    	 ImageIcon carImage;

		vehicleDetailFrame = new JFrame("Vehicle Details");

		vehicleDetailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vehicleDetailFrame.setSize(400,400);
		imagePanel = new JPanel();
		Specifications = new JPanel();
		imageLabel = new JLabel("Picture");

		vehicleDetailFrame.setLayout(new GridLayout(1,2));
		Specifications.setLayout(new GridBagLayout());
        imageLabel = new JLabel(new ImageIcon("src//ui//Images//jaguar.png"));
        VehicleService vehicleService=new VehicleServiceImple();
        Inventory inventory = null;
        try {
            inventory = vehicleService.getInventoryByDealer("gmps-aj-dohmann",0);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        int length = inventory.getVehicles().size();



        specification = new JLabel("Specification:" );
		brand = new JLabel("Brand: ");
		model = new JLabel("Model:");
		year = new JLabel("Year:");
		category = new JLabel("Category:");
		price = new JLabel("Price:");
        
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
		

	
	


