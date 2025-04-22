package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0; 
    private int id; 

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;


    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.id = ++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    
    public DigitalVideoDisc(String title) {
        this(title, null, null, 0, 0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost);
    }
    
    public int getId() {
        return id;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "DVD [Title: " + getTitle() + ", Category: " + getCategory() + ", Director: " + director + ", Length: " + length + " mins, Cost: " + getCost() + "]";
    }
    
    public boolean isMatch(String title) {
        return this.title != null && this.title.equalsIgnoreCase(title);
    }
}
