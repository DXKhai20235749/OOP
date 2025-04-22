package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int qtyInStore;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        qtyInStore = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("Added DVD: " + dvd.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {  // removing by removing the first dvd in the array
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {  
                    itemsInStore[j] = itemsInStore[j + 1]; 
                }
                itemsInStore[qtyInStore - 1] = null; 
                qtyInStore--;
                System.out.println("Removed DVD: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in the store.");
        }
    }

    public void printStore() { // add print method to test addDVD and removeDVD easier
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("DVDs available in the store:");
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i]);
            }
        }
    }
}