package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_ORDER_COUNT = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_ORDER_COUNT) {
            System.out.println("Cart is full, maximum amount of items reached!");
        } else {
            itemsOrdered.add(media);
            System.out.printf("%d. %s\n", itemsOrdered.size(), media.toString());
        }
    }

    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            addMedia(media);
        }
    }

    public void addMedia(Media media1, Media media2) {
        addMedia(media1);
        addMedia(media2);
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Item removed successfully");
        } else {
            System.out.println("Can't find item");
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found media by ID:");
                System.out.println(media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found media by Title:");
                System.out.println(media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }

    public void print() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i));
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
}