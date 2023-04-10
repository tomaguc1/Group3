package InventoryManager.controller;

import InventoryManager.model.Inventory;
import InventoryManager.model.Session;
import InventoryManager.view.InventoryView;

public class ApplicationController {
	
	private LoginController loginController;
	private InventoryController inventoryController;
	
	public void manageInventory(Session session) {
		inventoryController = new InventoryController(new Inventory(), session);

		InventoryView invView = new InventoryView(inventoryController);
		inventoryController.setView(invView);
		inventoryController.display();
	}
	
	public void login() {
		loginController = new LoginController(this);
		loginController.display();
	}
	
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}
}
