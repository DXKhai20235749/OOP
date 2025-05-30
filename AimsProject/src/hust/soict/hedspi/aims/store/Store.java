package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Playable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(String title) {
        Media mediaToRemove = findMediaByTitle(title);
        if (mediaToRemove != null) {
            itemsInStore.remove(mediaToRemove);
            System.out.println("Media " + title + " has been removed from the store.");
        } else {
            System.out.println("Media with title " + title + " not found.");
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
    }

    // playMedia with Scanner
    public void playMedia(Scanner scanner) throws PlayerException {
        System.out.print("Enter the title of the media you want to play: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    // addMediaToCart with Scanner
    public void addMediaToCart(Scanner scanner, Cart cart) throws LimitExceededException {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media \"" + title + "\" has been added to your cart.");
            System.out.println("You now have " + cart.getItemsOrdered().size() + " items in your cart.");
        } else {
            System.out.println("Media titled \"" + title + "\" not found in the store.");
        }
    }
}
