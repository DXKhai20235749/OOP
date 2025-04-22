package Package;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0; 
    private int id; 

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;


    public DigitalVideoDisc(String title) {
        this.id = ++nbDigitalVideoDiscs; // assign id to the new disc
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.id = ++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this(category, title, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
        this(director, category, title, cost);
        this.length = length;
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
}
