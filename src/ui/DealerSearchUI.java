package ui;

import dao.ManageDealer;
import dao.ManageDealerImple;
import dto.Dealer;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DealerSearchUI extends JFrame{
	
	private JFrame frame;
	private JPanel panel;
	private JLabel searchBasedOn, dealerID, zipcode, location,  noDealerID;
	private JComboBox locationCB, zipcodeCB;
	private JTextField dealerNameTF;
	private JButton search;
	private Font font;
	private Container c;
	//private int[] ZC = {98109,98033};
	private String loc = "location",zip = "zipcode";
	
	ManageDealer md = new ManageDealerImple();
	
	public static void main(String[] args) throws IOException {
		
		DealerSearchUI ds = new DealerSearchUI();
	}
	
	public DealerSearchUI() throws IOException {
 		createComponents();
 		setLayoutAddComponents();
 		addListener();
 			
 	}

	private void createComponents() {
 		font = new Font("TimesRoman", Font.BOLD, 25);
 		
 		dealerNameTF = new JTextField(10);
 		searchBasedOn = new JLabel("Search Based On");
 		searchBasedOn.setFont(font);
 		dealerID = new JLabel("Dealer Name");
 		zipcode = new JLabel("Zipcode");
 		location = new JLabel("Location");

 		noDealerID = new JLabel("Invalid DealerID");
 		
 		locationCB = new JComboBox();
 		zipcodeCB = new JComboBox();
 		
 		addDataToLocationCB(locationCB, md);
 		
 		addDataToZipcodeCB(zipcodeCB,md);
 		
 		search = new JButton("Search");
 		}
 		

	private void addDataToLocationCB(JComboBox list, ManageDealer dealerManager) {
		ArrayList<String> dealersLocation = md.getAttributeList(loc);
		list.addItem(null);

		for (String location: dealersLocation) {
			list.addItem(location);
		}
	}
	
	private void addDataToZipcodeCB(JComboBox list, ManageDealer dealerManager) {
		ArrayList<String> dealerszipcode = md.getAttributeList(zip);
		list.addItem(null);

		for (String zipcode: dealerszipcode) {
			list.addItem(zipcode);
		}
	}
	private void setLayoutAddComponents() throws IOException {
 		
 		 	JFrame.setDefaultLookAndFeelDecorated(true);
 		 	JFrame frame = new JFrame("Search Dealer");
 		 	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/CarDealers.jpg")))));
 	 	 	c = frame.getContentPane();
 			GroupLayout gl = new GroupLayout(c);
 	 	 	c.setLayout(gl);

 	 	 	
 	 	 	gl.setAutoCreateGaps(true);
 	 	 	gl.setAutoCreateContainerGaps(true);
 	 	 	
 	 	 	gl.setHorizontalGroup(
	 	 			gl.createParallelGroup(GroupLayout.Alignment.CENTER)
	 	 					.addComponent(searchBasedOn)
	 	 				.addGroup(gl.createSequentialGroup()
	 	 				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
	 	 	        		  .addComponent(zipcode)
	 	 	        		  .addComponent(dealerID)
	 	 	        		  .addComponent(location))
	 	 	            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
	 	 	        		  .addComponent(zipcodeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	 	 	 			 		          GroupLayout.PREFERRED_SIZE)
	 	 	        		  .addComponent(dealerNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	 	 	        		          GroupLayout.PREFERRED_SIZE)
	 	 	        		  .addComponent(locationCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	 	 	 			 		          GroupLayout.PREFERRED_SIZE)
	 	 	        		  .addComponent(search)

	 	 					  .addComponent(noDealerID)))
	 	 	          );
 	 	 	
 	 	 	gl.linkSize(SwingConstants.HORIZONTAL, search);
 	 	 	
 	 	 	gl.setVerticalGroup(gl.createSequentialGroup()
 	 	 			.addComponent(searchBasedOn)
 	 	 			.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
 	 	 						.addComponent(zipcode)
 	 	 						.addComponent(zipcodeCB,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
	 	 	 			 		          GroupLayout.PREFERRED_SIZE))
 	 	 			.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
 	 	 			 		 	.addComponent(dealerID)
 	 	 			 		 	.addComponent(dealerNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
 	 	 			 		          GroupLayout.PREFERRED_SIZE))
 	 	 			.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
 	 	 			 		 	.addComponent(location)
 	 	 			 		 	.addComponent(locationCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
 	 	 	 			 		          GroupLayout.PREFERRED_SIZE))
 	 	 			.addComponent(search)

 	 	 			.addComponent(noDealerID)
 	 	 	);
 	 	 	
 	 	 	search.setEnabled(false);
 	 	 	

 	 	 	noDealerID.setVisible(false);
 	 	 	
 	 	 	frame.pack();
 		 	frame.setSize(1000, 500);
 		 	frame.setVisible(true);
 	 	 		 	 		
 	}
	
	private void addListener() {
		
		ComboBoxListener cbl = new ComboBoxListener();
		locationCB.addItemListener(cbl);
		zipcodeCB.addItemListener(cbl);
		
		dealerNameTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
				changed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				changed();
				
			}
			
			public void changed(){
				
				if(dealerNameTF.getText().equals("")) {
					search.setEnabled(false);
					locationCB.setEnabled(true);
					zipcodeCB.setEnabled(true);
				}
				else {
					locationCB.setEnabled(false);
					zipcodeCB.setEnabled(false);
					search.setEnabled(true);
					
				}
			}
			});

		ButtonListener buttonClicked = new ButtonListener();
		search.addActionListener(buttonClicked);
	}
	
	class ComboBoxListener implements ItemListener {

		@Override

		public void itemStateChanged(ItemEvent e) {
			boolean flag=false;
			if(locationCB.getSelectedItem() == null) {
				search.setEnabled(false);
				dealerNameTF.setEnabled(true);
				zipcodeCB.setEnabled(true);
			}
			else {
				dealerNameTF.setEnabled(false);
				zipcodeCB.setEnabled(false);
				search.setEnabled(true);
				flag=true;
				
			}
			if(flag==false) {
				if (zipcodeCB.getSelectedItem() == null) {
					search.setEnabled(false);
					dealerNameTF.setEnabled(true);
					locationCB.setEnabled(true);
				} else {
					dealerNameTF.setEnabled(false);
					locationCB.setEnabled(false);
					search.setEnabled(true);
				}
			}
				
		}
	}
	
 	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Dealer> dealers=new ArrayList<>();
			
			if(locationCB.getSelectedItem()!= null) {
				
				String location = (String) locationCB.getSelectedItem();
				dealers = md.getDealerByLocation(location,0);

					//new project.ListOfDealersUI(dealers);

			}
			else if(zipcodeCB.getSelectedItem()!= null) {
				
				String zipcode = (String) zipcodeCB.getSelectedItem();
				dealers = md.getDealerByZipcode(zipcode,0);

					//new project.ListOfDealersUI(dealers);

			}
			else {
				
				String dealerName = dealerNameTF.getText();
				dealers = md.getDealerByName(dealerName);
				if(dealers.size()==0) {
					noDealerID.setVisible(true);
				}
				else {
					//new project.ListOfDealersUI(dealers);
				}
			}
		}	
			
}
	
 	
}
