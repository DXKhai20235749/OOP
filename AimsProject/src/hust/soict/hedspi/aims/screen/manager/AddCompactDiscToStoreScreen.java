package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField directorField, artistField, lengthField, trackTitleField, trackLengthField;

	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
		setTitle("Add CD");
	}

	@Override
	protected void addAdditionalFields(JPanel panel) {
		panel.add(new JLabel("Director:"));
		directorField = new JTextField();
		panel.add(directorField);

		panel.add(new JLabel("Artist:"));
		artistField = new JTextField();
		panel.add(artistField);

		panel.add(new JLabel("Length (minutes):"));
		lengthField = new JTextField();
		panel.add(lengthField);

		panel.add(new JLabel("Track Title:"));
		trackTitleField = new JTextField();
		panel.add(trackTitleField);

		panel.add(new JLabel("Track Length (minutes):"));
		trackLengthField = new JTextField();
		panel.add(trackLengthField);
	}

	@Override
	protected void addItem() {
		String title = titleField.getText();
		String category = categoryField.getText();
		float cost = Float.parseFloat(costField.getText());
		String director = directorField.getText();
		String artist = artistField.getText();
		int length = Integer.parseInt(lengthField.getText());
		CompactDisc cd = new CompactDisc(0, title, category, director, artist, length, cost);
		String trackTitle = trackTitleField.getText();
		int trackLength = Integer.parseInt(trackLengthField.getText());
		Track track = new Track(trackTitle, trackLength);
		cd.addTrack(track);
		store.addMedia(cd);
		JOptionPane.showMessageDialog(this, "CD added!");
	}
}
