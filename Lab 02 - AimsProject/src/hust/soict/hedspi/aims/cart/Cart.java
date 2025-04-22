package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int max_order_count = 20;
    private DigitalVideoDisc[] orderedItem = new DigitalVideoDisc[max_order_count];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= max_order_count) {
            System.out.println("Cart is full, maximum amount of DVDs reached!");
        } else {
            orderedItem[qtyOrdered] = disc; 
            qtyOrdered++;  
            System.out.printf("%d. %s\n", qtyOrdered, disc.toString());
        }
    }
    
    
    
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
    {
    	for(DigitalVideoDisc disc: dvdList)
    	{
    		addDigitalVideoDisc(disc);
    	}
    }; // I would prefer to use this method since I am more familiar to array methods, and it could make a list with array is quite convenient. 
    
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {  // add 2 dvds in a row, should not use this if the amount is an odd number though.
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    
    

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (orderedItem[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    orderedItem[j] = orderedItem[j + 1];
                }
                orderedItem[qtyOrdered - 1] = null;  
                qtyOrdered--;  
                System.out.println("Item removed successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("Can't find item");
        }
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (orderedItem[i].getId() == id) {
                System.out.println("Found DVD by ID:");
                System.out.println(orderedItem[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (orderedItem[i].isMatch(title)) {
                System.out.println("Found DVD by Title:");
                System.out.println(orderedItem[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
    
    public void print() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.println((i + 1) + ". " + orderedItem[i]);
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += orderedItem[i].getCost();  
        }
        return total;
    }
}
