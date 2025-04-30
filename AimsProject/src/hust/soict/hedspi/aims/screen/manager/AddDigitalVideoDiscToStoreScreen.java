package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField directorField, lengthField;

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
		setTitle("Add DVD");
	}

	@Override
	protected void addAdditionalFields(JPanel panel) {
		panel.add(new JLabel("Director:"));
		directorField = new JTextField();
		panel.add(directorField);

		panel.add(new JLabel("Length (minutes):"));
		lengthField = new JTextField();
		panel.add(lengthField);
	}

	@Override
	protected void addItem() {
		String title = titleField.getText();
		String category = categoryField.getText();
		float cost = Float.parseFloat(costField.getText());
		String director = directorField.getText();
		int length = Integer.parseInt(lengthField.getText());
		DigitalVideoDisc dvd = new DigitalVideoDisc(0, title, category, director, length, cost);
		store.addMedia(dvd);
		JOptionPane.showMessageDialog(this, "DVD added!");
	}
}
