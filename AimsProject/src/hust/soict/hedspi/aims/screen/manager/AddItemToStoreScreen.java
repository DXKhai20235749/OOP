package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store;
	protected JTextField titleField, categoryField, costField;

	public AddItemToStoreScreen(Store store) {
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createMenuBar(), BorderLayout.NORTH);
		cp.add(createFormPanel(), BorderLayout.CENTER);

		setTitle("Add Item to Store");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected JMenuBar createMenuBar() {
		StoreManagerScreen dummy = new StoreManagerScreen(store);
		return dummy.createMenuBar(); // reuse menu bar
	}

	private JPanel createFormPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		panel.add(new JLabel("Title:"));
		titleField = new JTextField();
		panel.add(titleField);

		panel.add(new JLabel("Category:"));
		categoryField = new JTextField();
		panel.add(categoryField);

		panel.add(new JLabel("Cost:"));
		costField = new JTextField();
		panel.add(costField);

		addAdditionalFields(panel);

		JButton addButton = new JButton("Add to Store");
		addButton.addActionListener(e -> addItem());
		panel.add(addButton);

		return panel;
	}
	
	protected abstract void addAdditionalFields(JPanel panel);
	protected abstract void addItem();
}
