package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(5);  // store with 5 slots to put empty dvds

        // Create new DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Print to check the store's content
        store.printStore();

        // Test removing a DVD
        store.removeDVD(dvd2);
        store.printStore();

        // Try printing a non-existed dvd in the store
        store.removeDVD(new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f));
    }
}