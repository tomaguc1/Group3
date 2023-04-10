package InventoryManager.controller;

import javax.swing.JOptionPane;

import InventoryManager.model.Inventory;
import InventoryManager.model.Session;
import InventoryManager.view.InventoryView;

public class InventoryController {

	private Inventory inventoryModel;
	private Session sessionModel;
	private InventoryView view;
	
	public InventoryController(Inventory inventory, Session session) {
		this.inventoryModel = inventory;
		this.sessionModel = session;
	}

	public void addItem() {
        String newProduct = JOptionPane.showInputDialog("Please insert the item you want to add to inventory:");
        inventoryModel.addProduct(newProduct);
	}

	public void deleteItem(int selectedRow) {
		if (selectedRow >= 0) {
			String productName = (String) inventoryModel.getValueAt(selectedRow, 0);
			inventoryModel.removeProduct(productName);
		}
	}

	public void setView(InventoryView view) {
		this.view = view;
		this.view.setTableModel(inventoryModel);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
}
