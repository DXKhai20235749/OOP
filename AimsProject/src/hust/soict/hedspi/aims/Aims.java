package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc[] dvdCart = {dvd1, dvd2, dvd3}; // Put those dvds into an array, which resembles a cart :)
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		anOrder.addDigitalVideoDisc(dvdCart);
		System.out.print("Total cost: ");
		System.out.println(anOrder.totalCost());
		System.out.println("***************************************************");
	}
}
