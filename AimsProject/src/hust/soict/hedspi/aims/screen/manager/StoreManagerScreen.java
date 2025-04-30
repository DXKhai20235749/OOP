package hust.soict.hedspi.aims.screen.manager;

import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media; 
import hust.soict.hedspi.aims.store.MediaStore;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private Store store;

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    JMenuItem viewStoreItem = new JMenuItem("View Store");
	    viewStoreItem.addActionListener(e -> {
	        new StoreManagerScreen(store);
	        dispose(); 
	    });
	    menu.add(viewStoreItem);

	    JMenu smUpdateStore = new JMenu("Update Store");

	    JMenuItem addBookItem = new JMenuItem("Add Book");
	    addBookItem.addActionListener(e -> new AddBookToStoreScreen(store));
	    smUpdateStore.add(addBookItem);

	    JMenuItem addCDItem = new JMenuItem("Add CD");
	    addCDItem.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
	    smUpdateStore.add(addCDItem);

	    JMenuItem addDVDItem = new JMenuItem("Add DVD");
	    addDVDItem.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
	    smUpdateStore.add(addDVDItem);

	    menu.add(smUpdateStore);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);
	    return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel(); 
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));

		return header;
	}	

	JPanel createCenter() {
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    int itemsToDisplay = Math.min(mediaInStore.size(), 9);
	    for (int i = 0; i < itemsToDisplay; i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i));
	        center.add(cell);
	    }

	    for (int i = itemsToDisplay; i < 9; i++) {
	        center.add(new JPanel()); 
	    }
	    return center;
	}
	public StoreManagerScreen(Store store) {
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
	    Store store = new Store();

	    store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc(3, "Aladdin", "Animation", "Ron Clements", 88, 18.99f));

	    new StoreManagerScreen(store);
	}
}
