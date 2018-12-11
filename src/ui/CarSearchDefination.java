package ui;
import javax.swing.*;
import dto.*;
import dao.*;
import java.awt.*;
import java.util.*;
public class CarSearchDefination extends JFrame{

	private static final String JLable = null;
	protected JPanel leftPanel, vehicleDetailsPanel, topPanel, 
	vehicleDetailsPane,carImagePanel;
	protected JButton homeButton, viewDetails, searchButton, 
	clearFiltersButton, applyFiltersButton, moreDetails, clearButton, backButton;
	protected JLabel topPicture, modelFilterLabel, yearFilterLabel,
	brandFilterLabel, priceFilterLabel, bodyTypeFilterLabel,categoryFilterLabel, sortLabel,
	vehicleImageLabel, vehicleModel, vehicleMake,
	vehicleBodyType, vehiclePrice, vehicleCategory,
	vehicleYear,searchVehicleLabel,minYearFilterLabel,maxYearFilterLabel,
	minPriceLabel,maxPriceLabel,trimLabel,yearLabel;
	protected JCheckBox categoryFilter1, categoryFilter2, categoryFilter3;
	protected JComboBox yearFilter, brandFilter, modelFilter, priceFilter, bodyTypeFilter, 
	categoryFilter, sortComboBox, minYearFilter,maxYearFilter,
	minPriceFilter,maxPriceFilter;
	protected JTextField searchBar;
	protected JScrollPane scrollPane,leftscrollPane;
	protected Container container;
	protected Inventory inventory;
	protected Set<String> modelFilterItems = new TreeSet<>(),brandFilterItems = new TreeSet<>(),
			bodyTypeFilterItems = new TreeSet<>(),yearItems = new TreeSet<>();


	protected JFrame displayCarDetailsFrame;
	protected JPanel imagePanel, detailsPanel;
	protected JLabel carId, carCategory, carYear, carMake, carModel, carTrim, carType, carPrice, carDiscountedPrice;

	protected CarSearchDefination(){
		this.setSize(1924,500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		container=this.getContentPane();
		topPanel=new JPanel();
		leftPanel = new JPanel();
		vehicleDetailsPanel = new JPanel();


	}

}
