package ui;

public class CarSearchUI {
	String dealername;
	public CarSearchUI(String dealername) {
		this.dealername=dealername;
		CarSearch c= new CarSearch(dealername);
		c.setLayout();
		c.setVisible(true);
		c.setActionListener();
	}



}
