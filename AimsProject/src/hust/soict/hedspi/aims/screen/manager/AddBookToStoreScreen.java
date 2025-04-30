package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField authorsField;

	public AddBookToStoreScreen(Store store) {
		super(store);
		setTitle("Add Book");
	}

	@Override
	protected void addAdditionalFields(JPanel panel) {
		panel.add(new JLabel("Authors (comma-separated):"));
		authorsField = new JTextField();
		panel.add(authorsField);
	}

	@Override
	protected void addItem() {
		// Retrieve values from input fields
		String title = titleField.getText();
		String category = categoryField.getText();
		float cost = Float.parseFloat(costField.getText());

		
		Book book = new Book(0, title, category, cost); 

		String[] authors = authorsField.getText().split(",");
		for (String author : authors) {
			book.addAuthor(author.trim());
		}

		store.addMedia(book);

		JOptionPane.showMessageDialog(this, "Book added!");
	}
}
