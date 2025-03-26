package Package;

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
            System.out.println("Disc added successfully!");
        }
    }
    
    
    
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
    {
    	for(DigitalVideoDisc disc: dvdList)
    	{
    		addDigitalVideoDisc(disc);
    	}
    }; // I would prefer to use this method since I am more familiar to array methods, and it could making a list with array is quite convenient. 
    
    
    
    

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

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += orderedItem[i].getCost();  
        }
        return total;
    }
}
