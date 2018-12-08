package ui;
import javax.swing.*;
import dto.*;
import dao.*;
import java.awt.*;
import java.util.*;
public class CarSearchDefination extends JFrame{
	//protected JFrame mainFrame;
	private static final String JLable = null;
	protected JPanel leftPanel, vehicleDetailsPanel, topPanel, 
	vehicleDetailsPane,carImagePanel;
	protected JButton homeButton, viewDetails, searchButton, 
	clearFiltersButton, applyFiltersButton, moreDetails, clearButton;
	protected JLabel topPicture, modelFilterLabel, yearFilterLabel,
	brandFilterLabel, priceFilterLabel, bodyTypeFilterLabel,categoryFilterLabel, sortLabel,
	vehicleImageLabel, vehicleModel, vehicleMake,
	vehicleBodyType, vehiclePrice, vehicleCategory,
	vehicleYear,searchVehicleLabel,minYearFilterLabel,maxYearFilterLabel,
	minPriceLabel,maxPriceLabel,trimLabel,yearLabel;
	protected JCheckBox categoryFilter1, categoryFilter2, categoryFilter3, categoryFilter4;
	protected JComboBox yearFilter, brandFilter, modelFilter, priceFilter, bodyTypeFilter, 
	categoryFilter, sortComboBox, minYearFilter,maxYearFilter,
	minPriceFilter,maxPriceFilter;
	protected JTextField searchBar;
	protected JScrollPane scrollPane,leftscrollPane;
	protected Container container;
	protected Inventory inventory;
	protected CarSearchDefination(){
	String Brand ;
	//protected  Set<String> makeItems = new TreeSet<String>();
	//protected Set<String>	bodyTypeItems = new TreeSet<String>();
	
	

		this.setSize(1924,500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		container=this.getContentPane();
		topPanel=new JPanel();
		leftPanel = new JPanel();
		vehicleDetailsPanel = new JPanel();


	}

}
