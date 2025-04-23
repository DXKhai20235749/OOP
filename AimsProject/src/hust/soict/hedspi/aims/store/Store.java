package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in the store.");
        }
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Items available in the store:");
            int i = 1;
            for (Media media : itemsInStore) {
                System.out.println(i + ". " + media);
                i++;
            }
        }
    }
}