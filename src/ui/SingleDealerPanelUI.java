package project;

import dto.Dealer;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SingleDealerPanelUI extends JPanel{
	
	private JButton clickForDetails;
	private JLabel name, url, location, zipcode, address;
	
	public SingleDealerPanelUI(Dealer dealer) {
		
		name = new JLabel(dealer.getName());
		url = new JLabel(dealer.getUrl());
		location = new JLabel(dealer.getLocation());
		zipcode = new JLabel(dealer.getZipcode());
		address = new JLabel(dealer.getAddress());
		clickForDetails = new JButton("Click For Details");
		
		JPanel p = new JPanel();
		p.add(clickForDetails);
		
		this.setLayout(new GridLayout(6, 0));
		this.add(name);
		this.add(url);
		this.add(location);
		this.add(zipcode);
		this.add(address);
		this.add(p);
		this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.RED));
	}

}
