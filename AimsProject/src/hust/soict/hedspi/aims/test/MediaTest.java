package hust.soict.hedspi.aims.test;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class MediaTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        Book book = new Book(1, "Clean Code", "Programming", 12.5f);
        book.addAuthor("Robert C. Martin");
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Inception", "Science Fiction", "Christopher Nolan", 148, 12.0f);
        
        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Pop", "Various Artists", "Queen", 45, 17.0f);
        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("Don't Stop Me Now", 4));
        
        cart.addMedia(book);
        cart.addMedia(dvd);
        cart.addMedia(cd);

        System.out.println("Media before sorting:");
        cart.printCart();

        cart.sortByTitle();
        System.out.println("\nMedia sorted by title (then by cost in descending order):");
        cart.printCart();

        cart.sortByCost();
        System.out.println("\nMedia sorted by cost (then by title alphabetically):");
        cart.printCart();
    }
}
