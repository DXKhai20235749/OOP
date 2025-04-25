package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Media> itemsInCart;

    public Cart() {
        this.itemsInCart = new ArrayList<>();
    }

    public void addMedia(Media media) {
        itemsInCart.add(media);
    }

    public void removeMedia(String title) {
        Media mediaToRemove = findMediaByTitle(title);
        if (mediaToRemove != null) {
            itemsInCart.remove(mediaToRemove);
            System.out.println("Media " + title + " has been removed from the cart.");
        } else {
            System.out.println("Media with title " + title + " not found in cart.");
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInCart) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public List<Media> getItemsInCart() {
        return itemsInCart;
    }

    public void filterByTitle(String title) {
        itemsInCart.stream()
            .filter(media -> media.getTitle().contains(title))
            .forEach(media -> System.out.println(media.toString()));
    }

    public void filterById(int id) {
        itemsInCart.stream()
            .filter(media -> media.getId() == id)
            .forEach(media -> System.out.println(media.toString()));
    }
//.
    public void sortByTitle() {
        itemsInCart.sort((media1, media2) -> media1.getTitle().compareTo(media2.getTitle()));
        System.out.println("Cart sorted by title: ");
        for (Media media : itemsInCart) {
            System.out.println(media.toString());
        }
    }

    public void sortByCost() {
        itemsInCart.sort((media1, media2) -> Float.compare(media1.getCost(), media2.getCost()));
        System.out.println("Cart sorted by cost: ");
        for (Media media : itemsInCart) {
            System.out.println(media.toString());
        }
    }

    public void clearCart() {
        itemsInCart.clear();
        System.out.println("The cart is now empty.");
    }



    public void printCart() {
        if (itemsInCart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            for (Media media : itemsInCart) {
                System.out.println(media.toString());
            }
        }
    }
}
