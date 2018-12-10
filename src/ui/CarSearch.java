package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.ParseException;
import java.util.ArrayList;
import dao.*;
import dto.*;
import service.*;

public class CarSearch extends CarSearchDefination implements ActionListener {
	VehicleQueryImple searchVehicle = new VehicleQueryImple();
	VehicleQuerySortServiceImple vehicleService = new VehicleQuerySortServiceImple();
	Inventory inventory;
	String dealername;

	public CarSearch(String dealername) {
		super();
		this.dealername=dealername;
	}

	public void createLeftPanelComponents() {
		brandFilterLabel = new JLabel("BRAND");
		modelFilterLabel = new JLabel("MODEL");
		bodyTypeFilterLabel = new JLabel("BODY TYPE");
		yearFilterLabel = new JLabel("YEAR");
		minYearFilterLabel = new JLabel("FROM");
		maxYearFilterLabel = new JLabel("To");
		priceFilterLabel = new JLabel("PRICE RANGE");
		minPriceLabel = new JLabel("Min Price");
		maxPriceLabel = new JLabel("Max Price");
		categoryFilterLabel = new JLabel("CATEGORY");
		searchVehicleLabel = new JLabel("Search Cars");
		searchVehicleLabel.setFont(new Font("Times new Roman", Font.BOLD, 20));
		clearFiltersButton = new JButton("CLEAR FILTERS");
		applyFiltersButton = new JButton("APPLY FILTERS");
	}

	// @Override
	public void setLeftPanel() {
		createLeftPanelComponents();
		defineFilters();

		BoxLayout leftPanelLayout = new BoxLayout(leftPanel, BoxLayout.Y_AXIS);
		leftPanel.setLayout(leftPanelLayout);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		leftPanel.add(searchVehicleLabel);
		leftPanel.add(categoryFilterLabel);
		leftPanel.add(categoryFilter1);
		leftPanel.add(categoryFilter2);
		leftPanel.add(categoryFilter3);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		leftPanel.add(brandFilterLabel);
		leftPanel.add(brandFilter);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		leftPanel.add(modelFilterLabel);
		leftPanel.add(modelFilter);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		leftPanel.add(bodyTypeFilterLabel);
		leftPanel.add(bodyTypeFilter);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		leftPanel.add(yearFilterLabel);
		leftPanel.add(minYearFilterLabel);
		leftPanel.add(minYearFilter);
		leftPanel.add(maxYearFilterLabel);
		leftPanel.add(maxYearFilter);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		leftPanel.add(priceFilterLabel);
		leftPanel.add(minPriceLabel);
		leftPanel.add(minPriceFilter);
		leftPanel.add(maxPriceLabel);
		leftPanel.add(maxPriceFilter);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		leftPanel.add(clearFiltersButton);
		leftPanel.add(applyFiltersButton);

		leftPanel.setBorder(BorderFactory.createTitledBorder("Filters"));
		leftPanel.setPreferredSize(new Dimension(400, 800));
		JScrollPane leftscrollPane = new JScrollPane(leftPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		leftscrollPane.getVerticalScrollBar().setUnitIncrement(20);
		container.add(leftscrollPane, BorderLayout.WEST);
		container.setVisible(true);

	}

	private void defineFilters() {


		for (int j=0;j<inventory.getVehicles().size();j++)
		{
		 brandFilterItems.add(inventory.getVehicles().get(j).getMake());
		 modelFilterItems.add(inventory.getVehicles().get(j).getModel());
		 bodyTypeFilterItems.add(inventory.getVehicles().get(j).getType());
		 yearItems.add(inventory.getVehicles().get(j).getYear());
		}

		String[] minPriceFilterItems = new String[] { "1000", "5000", "10000", "15000", "20000", "30000", "40000" };
		String[] maxPriceFilterItems = new String[] { "70000", "60000", "50000", "40000", "30000", "20000", "10000" };

		categoryFilter1 = new JCheckBox("Certified");
		categoryFilter2 = new JCheckBox("New");
		categoryFilter3 = new JCheckBox("Used");

		modelFilter = new JComboBox(modelFilterItems.toArray());
		minPriceFilter = new JComboBox(minPriceFilterItems);
		maxPriceFilter = new JComboBox(maxPriceFilterItems);
		brandFilter = new JComboBox(brandFilterItems.toArray());
		bodyTypeFilter = new JComboBox(bodyTypeFilterItems.toArray());
		minYearFilter = new JComboBox(yearItems.toArray());
		maxYearFilter = new JComboBox(yearItems.toArray());


	}

	public void createTopPanelComponents() {
		topPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon backImage = new ImageIcon("src//ui//Images//carw.png");
				g.drawImage(backImage.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		topPanel.setOpaque(true);
		homeButton = new JButton("HOME");
		searchBar = new JTextField(40);
		searchButton = new JButton("Search");
		sortLabel = new JLabel("SORT:");
		sortLabel.setForeground(Color.WHITE);
		sortComboBox = new JComboBox(
				new String[] { "Year ascending", "Year descending", "Price low to high", "Price high to low" });

	}

	// @Override
	public void setTopPanel() {

		createTopPanelComponents();
		topPanel.setBorder(BorderFactory.createTitledBorder("Dealer Name"));
		// topPanel.setBorder(BorderFactory);
		topPanel.add(Box.createRigidArea(new Dimension(200, 200)));
		topPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		topPanel.add(homeButton);
		topPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		topPanel.add(searchBar);
		topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		topPanel.add(searchButton);
		topPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		topPanel.add(sortLabel);
		topPanel.add(sortComboBox);
		container.add(topPanel, BorderLayout.NORTH);
	}

	public void CallInventory() {

		Inventory inventory = null;
		VehicleService vehicleService = new VehicleServiceImple();
		try {
			this.inventory = vehicleService.getInventoryByDealer(dealername, 0);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		

	}
	public Inventory getFilterValue() {
		
        FilterContent filtercontent= new FilterContent();
        ArrayList<String> category = new ArrayList<>();
		ArrayList<String> brands = new ArrayList<>();
		ArrayList<String> model = new ArrayList<>();
		ArrayList<String> bodytype = new ArrayList<>();
		if(categoryFilter1.isSelected())
		{
			category.add("Cartified");
		}
		else if(categoryFilter2.isSelected())
		{
			category.add("New");
		}
		else if(categoryFilter3.isSelected())
		{
			category.add("Used");
		}
		filtercontent.setCondition(category);
		brands.add((String)brandFilter.getSelectedItem());
		filtercontent.setBrand(brands);
		bodytype.add((String)bodyTypeFilter.getSelectedItem());
	   filtercontent.setBodyType(bodytype);
		model.add((String)modelFilter.getSelectedItem());
		filtercontent.setModel(model);
		filtercontent.setLowPrice(Double.valueOf(minPriceFilter.getSelectedItem().toString()));
		filtercontent.setHighPrice(Double.valueOf(maxPriceFilter.getSelectedItem().toString()));
		
		filtercontent.setLowYear(Integer.valueOf(minYearFilter.getSelectedItem().toString()));
		filtercontent.setHighYear(Integer.valueOf(maxYearFilter.getSelectedItem().toString()));
		//Year filter validation
		if (filtercontent.getHighPrice() < filtercontent.getLowPrice()) {
			String message = "Enter a valid price range";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
			return inventory;
		}
		//Price filter validation
		if (filtercontent.getHighYear() < filtercontent.getLowYear()) {
			String message = "Enter a valid range for year";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
			return inventory;

		}
		
		System.out.println(filtercontent.getCondition()+" " +filtercontent.getBodyType() + " "+filtercontent.getModel()+" "+
		filtercontent.getBrand() +" "+filtercontent.getHighPrice()+" "+filtercontent.getLowPrice() + "  "+filtercontent.getLowYear()+"  "+filtercontent.getHighYear());
		
		System.out.println("get all vehicles" + inventory.getVehicles().size());
		Inventory inventory1=searchVehicle.queryByFilter(inventory,filtercontent);
	
		System.out.println("return result inventory "+ inventory1.getVehicles().size());
		return inventory1;
}


	

	public void setActionListener() {
		if (applyFiltersButton == null)
			System.out.println("BUTTON IS NULL");
		Inventory tmp = getFilterValue();
		if (tmp == null)
			System.out.println("tmp IS NULL");
		clearFiltersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				categoryFilter1.setSelected(false);
				categoryFilter2.setSelected(false);
				categoryFilter3.setSelected(false);
				brandFilter.setSelectedIndex(0);
				modelFilter.setSelectedIndex(0);
				minYearFilter.setSelectedIndex(0);
				maxYearFilter.setSelectedIndex(0);
				bodyTypeFilter.setSelectedIndex(0);
				maxPriceFilter.setSelectedIndex(0);
				minPriceFilter.setSelectedIndex(0);
				setVehicleDetailsPanel(inventory);
				
				
			}
		});

		applyFiltersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Inventory temp = getFilterValue();
				setVehicleDetailsPanel(temp);
				//no matching search found validation
				if (temp.getVehicles().size() == 0) {
					String message = "No matching search found";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		sortComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Inventory sortedinventory = null;
				if (sortComboBox.getSelectedItem().equals("Year ascending")) {
					sortedinventory = vehicleService.Sort(SortType.YEAR_ASC,inventory);
				} else if (sortComboBox.getSelectedItem().equals("Year descending")) {
					sortedinventory = vehicleService.Sort(SortType.YEAR_DSC,inventory);
				} else if (sortComboBox.getSelectedItem().equals("Price low to high")) {
					sortedinventory = vehicleService.Sort(SortType.PRICE_ASC, inventory);
					System.out.println(sortedinventory.getVehicles().size());
				} else if (sortComboBox.getSelectedItem().equals("Price high to low")) {
					sortedinventory = vehicleService.Sort(SortType.PRICE_DSC,inventory);
				}
				System.out.println("New sorted Inventory size: " + sortedinventory.getVehicles().size());
				setVehicleDetailsPanel(sortedinventory);
			}
		});
	}

	public void setVehicleDetailsPanel(Inventory inventory) {
		// clear the vehicleDetailsPane
		vehicleDetailsPane.removeAll();
		vehicleDetailsPane.revalidate(); 
		vehicleDetailsPane.repaint();
		// call the function to return List of; Vehicles
		int length = inventory.getVehicles().size();

		for (int i = 0; i < length; i++) {
			JPanel carPanel = new JPanel();			
			JPanel carItemPanel = new JPanel();
			JPanel carImagePanel = new JPanel();
			
			
			// ImageIcon(inventory.getVehicles().get(i).getImages()));
		
			// ImageIcon("http://inventory-dmg.assets-cdk.com/5/1/7/13411480715x90.jpg"));

			JLabel Picture = new JLabel(new ImageIcon("src//ui//Images//Jaguar.png"));
			JLabel vehicleIdLabel = new JLabel("VEHICLE ID : " + inventory.getVehicles().get(i).getId());
			JLabel brandLabel = new JLabel("BRAND : " + inventory.getVehicles().get(i).getMake());
			JLabel modelLabel = new JLabel("MODEL: " + inventory.getVehicles().get(i).getModel());
			JLabel bodyTypeLabel = new JLabel("BODY TYPE : " + inventory.getVehicles().get(i).getType());
			JLabel priceLabel = new JLabel("PRICE : " + inventory.getVehicles().get(i).getPrice());
			JLabel trimLabel = new JLabel(inventory.getVehicles().get(i).getTrim());
			JLabel yearLabel = new JLabel("YEAR: "+inventory.getVehicles().get(i).getYear());
			JButton moreDetails = new JButton("More Details");
			//moreDetails.setPreferredSize(new Dimension(100,30));
			//carImagePanel.setLayout(new );
			carImagePanel.add(Picture);
			carImagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			
			
			
			
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			carItemPanel.add(yearLabel);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));

			carItemPanel.add(trimLabel);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));

			carItemPanel.add(vehicleIdLabel);
			//carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));

			// carItemPanel.add(Picture);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			carItemPanel.add(brandLabel);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			carItemPanel.add(modelLabel);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			carItemPanel.add(bodyTypeLabel);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			carItemPanel.add(priceLabel);
			carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			carItemPanel.add(moreDetails);
			carItemPanel.setPreferredSize(new Dimension(200,500));
			carItemPanel.setBackground(new Color(225, 225, 0, 0));
			carItemPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			carPanel.setLayout(new FlowLayout());
			carPanel.add(carImagePanel);
			carPanel.add(carItemPanel);
			carPanel.setPreferredSize(new Dimension(400,300));
			carPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			vehicleDetailsPane.add(carPanel);
			vehicleDetailsPane.add(moreDetails);
			vehicleDetailsPane.add(trimLabel);
		}

	}

	// @Override
	public void setLayout() {
	    CallInventory();
		setTopPanel();
		setLeftPanel();
		vehicleDetailsPane = new JPanel();
		BoxLayout layout = new BoxLayout(vehicleDetailsPane, BoxLayout.Y_AXIS);
		vehicleDetailsPane.setLayout(layout);
		vehicleDetailsPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		//BoxLayout layout = new BoxLayout(vehicleDetailsPane, BoxLayout.Y_AXIS);
		//vehicleDetailsPane.setLayout(layout);
		vehicleDetailsPane.setBackground(Color.WHITE);
		vehicleDetailsPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setVehicleDetailsPanel(inventory);
		scrollPane = new JScrollPane(vehicleDetailsPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		container.add(scrollPane);
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
