package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Aims {
    public static void main(String[] args) throws LimitExceededException {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc(3, "Aladdin", "Animation", "Ron Clements", 88, 18.99f));

        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayStore(store, scanner, cart);
                    break;
                case 2:
                    updateStore(scanner, store);
                    break;
                case 3:
                    displayCart(cart, scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3 ");
    }

    public static void displayStore(Store store, Scanner scanner, Cart cart) throws LimitExceededException {
        if (store.getItemsInStore().isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Items in Store: ");
            for (int i = 0; i < store.getItemsInStore().size(); i++) {
                System.out.println((i + 1) + ". " + store.getItemsInStore().get(i).toString());
            }
        }
        storeMenu(scanner, store, cart);
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) throws LimitExceededException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4 ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                seeMediaDetails(scanner, store, cart);
                break;
            case 2:
            case 3:
                playMedia(scanner, store);
                break;
            case 4:
                displayCart(cart, scanner);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
                storeMenu(scanner, store, cart);
        }
    }

    public static void seeMediaDetails(Scanner scanner, Store store, Cart cart) throws LimitExceededException {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(store, title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(scanner, media, cart);  // Passing cart here
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media, Cart cart) throws LimitExceededException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2 ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                addMediaToCart(scanner, media, cart); 
                break;
            case 2:
                playMedia(media);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
                mediaDetailsMenu(scanner, media, cart);
        }
    }

    public static Media findMediaByTitle(Store store, String title) {
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public static void addMediaToCart(Scanner scanner, Media media, Cart cart) throws LimitExceededException {
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart. Current number of items in cart: " + cart.getItemsOrdered().size());
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Scanner scanner, Store store) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(store, title);
        if (media != null && media instanceof Playable) {
            playMedia(media); // uses the updated version above
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    public static void playMedia(Media media) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.out.println("Exception!");
                System.out.println("Message: " + e.getMessage());
                System.out.println("ToString: " + e.toString());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                    "Exception while playing media:\n" + e.getMessage(),
                    "Playback Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void updateStore(Scanner scanner, Store store) {
        System.out.println("Update Store Options: ");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter the media title to add: ");
                String title = scanner.nextLine();
                store.addMedia(new DigitalVideoDisc(4, title, "Genre", "Director", 90, 20.00f));
                System.out.println("Media added: " + title);
                break;
            case 2:
                System.out.print("Enter the media title to remove: ");
                title = scanner.nextLine();
                store.removeMedia(title);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    public static void displayCart(Cart cart, Scanner scanner) {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in Cart: ");
            for (int i = 0; i < cart.getItemsOrdered().size(); i++) {
                System.out.println((i + 1) + ". " + cart.getItemsOrdered().get(i).toString());
            }
        }
        cartMenu(scanner, cart);
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5 ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                filterCart(scanner, cart);
                break;
            case 2:
                sortCart(scanner, cart);
                break;
            case 3:
                
                break;
            case 4:
                break;
            case 5:
                placeOrder(cart);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
                cartMenu(scanner, cart);
        }
    }

    public static void filterCart(Scanner scanner, Cart cart) {
        System.out.println("Filter Options: ");
        System.out.println("1. By title");
        System.out.println("2. By id");
        System.out.print("Choose filter option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter the title to filter by: ");
                String title = scanner.nextLine();
                cart.filterByTitle(title);
                break;
            case 2:
                System.out.print("Enter the id to filter by: ");
                int id = scanner.nextInt();
                cart.filterById(id);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void sortCart(Scanner scanner, Cart cart) {
        System.out.println("Sort Options: ");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        System.out.print("Choose sort option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    

    public static void placeOrder(Cart cart) {
        System.out.println("Order created successfully.");
        cart.clearCart();
    }
}
