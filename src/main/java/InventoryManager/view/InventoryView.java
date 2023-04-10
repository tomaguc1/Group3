package InventoryManager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import InventoryManager.controller.InventoryController;
import InventoryManager.model.Session;

public class InventoryView extends JFrame {

	private static final long serialVersionUID = 989075282041187452L;
	private InventoryController controller;
	private JTable tblInventory;
	private JLabel lblSession;
	
	public InventoryView(InventoryController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Manager");
		setPreferredSize(new Dimension(800, 600));
		
		// buttons
		JButton btnNew = new JButton("Add inventory item");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addItem();
			}
		});
		JButton btnDelete = new JButton("Remove selected item");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.deleteItem(tblInventory.getSelectedRow());
			}
		});
		
		// toolbar
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JToolBar toolbar = new JToolBar();
		toolbar.add(btnNew);
		toolbar.add(btnDelete);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblSession);
		add(toolbar, BorderLayout.NORTH);
		
		// table
		tblInventory = new JTable();
		tblInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnDelete.setEnabled((tblInventory.getSelectedRow() >= 0));
			}
		});
		add(new JScrollPane(tblInventory), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void setTableModel(TableModel model) {
		tblInventory.setModel(model);
	}

	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + sessionModel.getRole() + ")</i></html>");
	}
}
