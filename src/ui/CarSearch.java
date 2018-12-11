package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import dao.*;
import dto.*;
import service.*;
import ui.SearchDealer.MyFrame;

public class CarSearch extends CarSearchDefination implements ActionListener {
	VehicleQueryImple searchVehicle = new VehicleQueryImple();
	VehicleQuerySortServiceImple vehicleService = new VehicleQuerySortServiceImple();
	Inventory inventory;
	String dealerName;

	public CarSearch(String dealerName) {
		super();
		this.dealerName = dealerName;
		this.setTitle(dealerName);
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

	@SuppressWarnings("unchecked")
	private void defineFilters() {

		for (int j=0;j<inventory.getVehicles().size();j++) {
			brandFilterItems.add(inventory.getVehicles().get(j).getMake());
			modelFilterItems.add(inventory.getVehicles().get(j).getModel());
			bodyTypeFilterItems.add(inventory.getVehicles().get(j).getType());
			yearItems.add(inventory.getVehicles().get(j).getYear());

		}
		String[] minPriceFilterItems = new String[] { "1000", "5000", "10000", "15000", "20000", "30000", "40000","50000","60000","70000" };
		String[] maxPriceFilterItems = new String[] { "120000","100000","90000","80000","70000", "60000", "50000", "40000", "30000", "20000", "10000" };

		categoryFilter1 = new JCheckBox("Certified");
		categoryFilter2 = new JCheckBox("New");
		categoryFilter2.setSelected(true);
		categoryFilter3 = new JCheckBox("Used");

		modelFilter = new JComboBox(modelFilterItems.toArray());
		minPriceFilter = new JComboBox(minPriceFilterItems);
		maxPriceFilter = new JComboBox(maxPriceFilterItems);
		brandFilter = new JComboBox(brandFilterItems.toArray());
		bodyTypeFilter = new JComboBox(bodyTypeFilterItems.toArray());
		minYearFilter = new JComboBox(yearItems.toArray());
		maxYearFilter = new JComboBox(yearItems.toArray());
		brandFilter.addItem("brand");
	    modelFilter.addItem("model");
	    bodyTypeFilter.addItem("bodytype");
		setFilterIndex();

	}
	public void setFilterIndex() {
		 brandFilter.setSelectedIndex(brandFilter.getItemCount()-1);
		 modelFilter.setSelectedIndex(modelFilter.getItemCount()-1);
		 bodyTypeFilter.setSelectedIndex(bodyTypeFilter.getItemCount()-1);
		 maxYearFilter.setSelectedIndex(maxYearFilter.getItemCount()-1);
		 minYearFilter.setSelectedIndex(1);
		 maxPriceFilter.setSelectedIndex(maxPriceFilter.getItemCount()-1);
		 minPriceFilter.setSelectedIndex(1);
		 categoryFilter1.setSelected(false);
		 categoryFilter2.setSelected(true);
		 categoryFilter3.setSelected(false);
		 
		
	}


	public void createTopPanelComponents() {
		topPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon backImage = new ImageIcon("src//ui//Images//carw.png");
				g.drawImage(backImage.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		topPanel.setOpaque(true);
		homeButton = new JButton("Home");
		searchBar = new JTextField(40);
		searchButton = new JButton("Search");
		sortLabel = new JLabel("Sort:");
		sortLabel.setForeground(Color.WHITE);
		sortComboBox = new JComboBox(new String[] { "Year ascending", "Year descending", "Price low to high", "Price high to low" });
	}

	// @Override
	public void setTopPanel() {

		createTopPanelComponents();
		topPanel.setBorder(BorderFactory.createTitledBorder("Dealer Name"));
		topPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		topPanel.add(Box.createRigidArea(new Dimension(200, 200)));
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

	public void callInventory() {

		VehicleService vehicleService = new VehicleServiceImple();
		try {
			this.inventory = vehicleService.getInventoryByDealer(this.dealerName, 0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

	public Inventory getFilterValue() {

		FilterContent filtercontent = new FilterContent();
		ArrayList<String> category = new ArrayList<>();
		ArrayList<String> brands = new ArrayList<>();
		ArrayList<String> model = new ArrayList<>();
		ArrayList<String> bodytype = new ArrayList<>();
		while (true) {
			if (categoryFilter1.isSelected()) {
				category.add("certified");
			} else if (categoryFilter2.isSelected()) {
				category.add("new");
			} else if (categoryFilter3.isSelected()) {
				category.add("used");
			}
			filtercontent.setCondition(category);
			brands.add((String) brandFilter.getSelectedItem());
			filtercontent.setBrand(brands);
			bodytype.add((String) bodyTypeFilter.getSelectedItem());
			filtercontent.setBodyType(bodytype);
			model.add((String) modelFilter.getSelectedItem());
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
			Inventory inventory1 = searchVehicle.queryByFilter(inventory, filtercontent); 
			return inventory1;
		}
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
				setFilterIndex();
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
					sortedinventory = vehicleService.Sort(SortType.YEAR_ASC, inventory);
				} else if (sortComboBox.getSelectedItem().equals("Year descending")) {
					sortedinventory = vehicleService.Sort(SortType.YEAR_DSC, inventory);
				} else if (sortComboBox.getSelectedItem().equals("Price low to high")) {
					sortedinventory = vehicleService.Sort(SortType.PRICE_ASC, inventory);
					System.out.println(sortedinventory.getVehicles().size());
				} else if (sortComboBox.getSelectedItem().equals("Price high to low")) {
					sortedinventory = vehicleService.Sort(SortType.PRICE_DSC, inventory);
				}

				setVehicleDetailsPanel(sortedinventory);
			}
		});

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new MyFrame().setVisible(true);
				} catch (IOException e1) {
					System.out.println("Error in Going to Home");
					e1.printStackTrace();
				}
				dispose();
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
			setCarDetailList(inventory, i);
		}

	}
	void setCarDetailList(Inventory inventory, int i) {
		JPanel carPanel = new JPanel();
		carPanel.setLayout(new BorderLayout());
		JPanel carItemPanel = new JPanel();
		JPanel carImagePanel = new JPanel();
		JPanel trimPanel = new JPanel();
		carItemPanel.setLayout(new BoxLayout(carItemPanel, BoxLayout.Y_AXIS));
		JLabel Picture = new JLabel(new ImageIcon("src//ui//Images//Jaguar.png"));

		JLabel vehicleIdLabel = new JLabel("VEHICLE ID : " + inventory.getVehicles().get(i).getId());
		JLabel brandLabel = new JLabel("BRAND : " + inventory.getVehicles().get(i).getMake());
		JLabel modelLabel = new JLabel("MODEL: " + inventory.getVehicles().get(i).getModel());
		JLabel bodyTypeLabel = new JLabel("BODY TYPE : " + inventory.getVehicles().get(i).getType());
		JLabel priceLabel = new JLabel("PRICE : " + inventory.getVehicles().get(i).getPrice());
		JLabel trimLabel = new JLabel(inventory.getVehicles().get(i).getTrim());
		JLabel yearLabel = new JLabel("YEAR: " + inventory.getVehicles().get(i).getYear());
		JLabel discountedPriceLable = new JLabel("DISCOUNTED PRICE: " + inventory.getVehicles().get(i).getDiscountprice());
		Color redColor = new Color(225,0,0);
		discountedPriceLable.setForeground(redColor);
		JPanel discountedPricePanel = new JPanel();
		discountedPricePanel.add(discountedPriceLable);

		JButton moreDetails = new JButton("More Details");
		moreDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("more details button pressed");
				setCarDetailsFrame(inventory, i);


			}
		});

		carImagePanel.add(Picture);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(yearLabel);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));

		trimLabel.setFont(new Font("Courier New", Font.BOLD, 18));

		trimPanel.add(trimLabel , FlowLayout.LEFT);
		trimPanel.setBackground(Color.GRAY);
		trimPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

		carItemPanel.add(vehicleIdLabel);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(brandLabel);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(modelLabel);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(bodyTypeLabel);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(priceLabel);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(discountedPriceLable);
		carItemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		carItemPanel.add(moreDetails);
		carItemPanel.setPreferredSize(new Dimension(400, 180));
		carItemPanel.setBackground(new Color(225, 225, 0, 0));

		carPanel.add(carImagePanel, BorderLayout.CENTER);
		carPanel.add(carItemPanel, BorderLayout.EAST);
		carPanel.add(trimPanel, BorderLayout.NORTH);
		carPanel.setPreferredSize(new Dimension(500, 180));
		carPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		vehicleDetailsPane.add(carPanel);


	}

	// @Override
	public void setLayout() {
		callInventory();
		setTopPanel();
		setLeftPanel();
		vehicleDetailsPane = new JPanel();
		BoxLayout layout = new BoxLayout(vehicleDetailsPane, BoxLayout.Y_AXIS);
		vehicleDetailsPane.setLayout(layout);
		vehicleDetailsPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

	public void setCarDetailsFrame(Inventory in, int index) {
		displayCarDetailsFrame = new JFrame(in.getVehicles().get(index).getMake() +" "+ in.getVehicles().get(index).getModel());
		imagePanel = new JPanel();
		detailsPanel = new JPanel();

		carTitle = new JLabel(in.getVehicles().get(index).getMake() +" "+ in.getVehicles().get(index).getModel());
		carTitle.setForeground(Color.DARK_GRAY);
		Font titleFont = new Font("MS UI Gothic", Font.BOLD, 22);
		carTitle.setFont(titleFont);
		carId = new JLabel("\nCar Id : " + in.getVehicles().get(index).getId());
		carCategory = new JLabel("" + in.getVehicles().get(index).getCategory().toUpperCase());
		carCategory.setForeground(Color.DARK_GRAY);
		Font carCategoryFont = new Font("MS UI Gothic", Font.ITALIC, 22);
		carCategory.setFont(carCategoryFont);
		carYear = new JLabel("Year : " + in.getVehicles().get(index).getYear());
		carMake = new JLabel("Brand : " + in.getVehicles().get(index).getMake());
		carModel = new JLabel("Model : " + in.getVehicles().get(index).getModel());
		carTrim = new JLabel("Trim : " + in.getVehicles().get(index).getTrim());
		carType = new JLabel("Body Type : " + in.getVehicles().get(index).getType());
		carPrice = new JLabel("Price : " + in.getVehicles().get(index).getPrice()); //or discounted price
		carDiscountedPrice = new JLabel("Discount Price : " + in.getVehicles().get(index).getDiscountprice());
		Color redColor = new Color(225,0,0);
		carDiscountedPrice.setForeground(redColor);
		//String imagePath = in.getVehicles().get(index).getImages();
		String imagePath = "src//ui//Images//Jaguar.png";
		ImageIcon image = new ImageIcon(imagePath);
		JLabel imageLabel = new JLabel(image);

		displayCarDetailsFrame.setLayout(new GridLayout(1,1));
		displayCarDetailsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		displayCarDetailsFrame.setSize(500,200);
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
		detailsPanel.setLayout(new GridBagLayout());

		displayCarDetailsFrame.add(imagePanel);
		displayCarDetailsFrame.add(detailsPanel);

		imagePanel.add(carCategory);
		imagePanel.add(carTitle);
		imagePanel.add(imageLabel);
		imagePanel.add(carId);
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		detailsPanel.add(carMake, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 2;
		detailsPanel.add(carModel, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		detailsPanel.add(carYear, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 4;
		detailsPanel.add(carTrim, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 5;
		detailsPanel.add(carType, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 6;
		detailsPanel.add(carPrice, gbc);

		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.WEST;
		gbc.gridx = 0;
		gbc.gridy = 7;
		detailsPanel.add(carDiscountedPrice, gbc);

		imagePanel.setVisible(true);
		detailsPanel.setVisible(true);
		displayCarDetailsFrame.setVisible(true);
	}
}
