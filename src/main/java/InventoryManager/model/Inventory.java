package InventoryManager.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class Inventory extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;
	private Map<String, Integer> products;
	
	public Inventory() {
		products = new HashMap<String, Integer>();
	}
	
	public void addProduct(String name) {
		if (products.containsKey(name)) {
			products.put(name, products.get(name) + 1);
		} else {
			products.put(name, 1);
		}
		fireTableDataChanged(); // notify the views that data changed
	}
	
	public void removeProduct(String name) {
		if (products.containsKey(name)) {
			int quantity = products.get(name) - 1;
			if (quantity == 0) {
				products.remove(name);
			} else {
				products.put(name,  quantity);
			}
		}
		fireTableDataChanged(); // notify the views that data changed
	}
	
	
	// methods below to extend table model
	
	@Override
	public int getColumnCount() {
		return 2; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<String> prodList = new ArrayList<String>(products.keySet());
		Collections.sort(prodList);
		if (columnIndex == 0) {
			return prodList.get(rowIndex);
		} else if (columnIndex == 1) {
			return products.get(prodList.get(rowIndex));
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Product name";
		} else if (column == 1) {
			return "Quantity";
		}
		return null;
	}
}
