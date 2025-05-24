package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) {
        if (media != null) {
            itemsOrdered.add(media);
        }
    }

    public void removeMedia(Media media) {
        if (media != null && itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media " + media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void filterByTitle(String title) {
        itemsOrdered.stream()
            .filter(media -> media.getTitle().contains(title))
            .forEach(System.out::println);
    }

    public void filterById(int id) {
        itemsOrdered.stream()
            .filter(media -> media.getId() == id)
            .forEach(System.out::println);
    }

    public void sortByTitle() {
        FXCollections.sort(itemsOrdered, (m1, m2) -> m1.getTitle().compareTo(m2.getTitle()));
        System.out.println("Cart sorted by title:");
        itemsOrdered.forEach(System.out::println);
    }

    public void sortByCost() {
        FXCollections.sort(itemsOrdered, (m1, m2) -> Float.compare(m1.getCost(), m2.getCost()));
        System.out.println("Cart sorted by cost:");
        itemsOrdered.forEach(System.out::println);
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart is now empty.");
    }

    public void printCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            itemsOrdered.forEach(System.out::println);
        }
    }
}
