package hust.soict.hedspi.aims.test;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", "Ron Clements", 88, 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // Print current cart
        System.out.println("\nCurrent items in cart:");
        cart.printCart(); 

        // Remove one item
        cart.removeMedia("The Lion King");

        // Print after removal
        System.out.println("\nCart after removing Star Wars:");
        cart.printCart(); 

    }
}
