package dto;

import com.jidesoft.utils.DateUtils;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SpecialsTableModel extends AbstractTableModel{

	private ImageIcon validImageIcon, invalidImageIcon;
	enum ColumnIdx {
		Status,
		ID,
		StartDate,
		EndDate,
		Title,
		Discount,
		End,
	};

	private List<Special> speicals;

	private final String[] columnNames = {"Status", "Id", "Start date", "End date", "Title", "Discount"};


	public SpecialsTableModel() {
		validImageIcon = new ImageIcon("resources/icons/valid.png");
		invalidImageIcon = new ImageIcon("resources/icons/invalid.png");
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setRows(List<Special> speicals) {
		this.speicals = speicals;
	}

	@Override
	public int getColumnCount() {
		return ColumnIdx.End.ordinal();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		if (this.speicals == null)
			return 0;

		return this.speicals.size();
	}


	private Object getValue(Special special, int col){
		if (special != null) {
			ColumnIdx colIdx = ColumnIdx.values()[col];
			switch (colIdx) {
				case Status:
					return new Boolean(special.isExpired());
				case ID:
					return Integer.parseInt(special.getId());
				case StartDate:
					return special.getStartDate();
				case EndDate:
					return special.getEndDate();
				case Title:
					return special.getTitle();
				case Discount:
					Discount discount = special.getDiscount();
					if (discount == null) {
						return "";
					}

					if (discount.getCashBack())
						return "Cash back: " + discount.getValue() + "$";
					else
						return "Percentage off: " + (int)(100- discount.getValue() * 100) + "%";
			}
		}

		return null;
	}


	public Object getValueAt(Special speical, int col) {
		return this.getValue(speical, col);
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (row >= speicals.size() && row < 0) {
			System.out.println("GetValue At Wrong :" + row);
			return null;
		}

		try {
			Special special = speicals.get(row);
			return this.getValue(special, col);
		}
		catch (IndexOutOfBoundsException exception) {
			System.out.println("exception:" + exception);
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		if(columnIndex == 0) return ImageIcon.class;
		return getValueAt(0, columnIndex).getClass();
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
