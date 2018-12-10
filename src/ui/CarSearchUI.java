package ui;

public class CarSearchUI {

	public static void main(String[] args) {
		CarSearchUI carSearchUI = new CarSearchUI("gmps-aj-dohmann");
	}

	public CarSearchUI(String dealerName){
		CarSearch c= new CarSearch(dealerName);
		c.setLayout();
		c.setVisible(true);
		c.setActionListener();
	}

}
